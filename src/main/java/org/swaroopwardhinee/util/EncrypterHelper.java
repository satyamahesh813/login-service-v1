package org.swaroopwardhinee.util;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.swaroopwardhinee.exception.CustomException;
import org.swaroopwardhinee.mappers.ErrorInfoMapper;
import org.swaroopwardhinee.models.ErrorInfoExample;

@Component
public final class EncrypterHelper {
	
	@Autowired
	private ErrorInfoMapper swaErrorInfoMapper;

	@Value("${spec_key}")
	private String key;

	private static final String PBE_WITH_MD_5_AND_DES_MODE = "PBEWithMD5AndDES";

	final byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x34, (byte) 0xE3,
			(byte) 0x03 };

	int iterationCount = 19;

	public String encrypt(String pass, String specKey) throws CustomException {

		try {
			final KeySpec keySpec;
			if (StringUtils.isNotBlank(specKey)) {
				keySpec = new PBEKeySpec(specKey.toCharArray(), salt, iterationCount);
			} else {
				keySpec = new PBEKeySpec(key.toCharArray(), salt, iterationCount);
			}
			final SecretKey key = SecretKeyFactory.getInstance(PBE_WITH_MD_5_AND_DES_MODE).generateSecret(keySpec);
			Cipher ecipher = Cipher.getInstance(PBE_WITH_MD_5_AND_DES_MODE);
			final AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			final byte[] utf8 = pass.getBytes("UTF8");
			final byte[] enc = ecipher.doFinal(utf8);
			return javax.xml.bind.DatatypeConverter.printBase64Binary(enc);
		} catch (Exception e) {
			throw new CustomException();
		}
	}

	public String decrypt(String enc, String specKey) throws CustomException {
		ErrorInfoExample errorInfoExample = new ErrorInfoExample();
		try {
			final KeySpec keySpec;
			if (StringUtils.isNotBlank(specKey)) {
				keySpec = new PBEKeySpec(specKey.toCharArray(), salt, iterationCount);
			} else {
				keySpec = new PBEKeySpec(key.toCharArray(), salt, iterationCount);
			}
			final SecretKey key = SecretKeyFactory.getInstance(PBE_WITH_MD_5_AND_DES_MODE).generateSecret(keySpec);
			Cipher decipher = Cipher.getInstance(PBE_WITH_MD_5_AND_DES_MODE);
			final AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
			decipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
			final byte[] dec = javax.xml.bind.DatatypeConverter.parseBase64Binary(enc);
			final byte[] utf8 = decipher.doFinal(dec);
			return new String(utf8, "UTF8");
		} catch (Exception e) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C020");
			throw new CustomException(swaErrorInfoMapper.selectByExample(errorInfoExample).get(0));
		}
	}
}