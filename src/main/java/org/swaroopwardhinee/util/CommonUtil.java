package org.swaroopwardhinee.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.swaroopwardhinee.exception.CustomException;
import org.swaroopwardhinee.mappers.UsersMapper;
import org.swaroopwardhinee.models.UsersExample;

@Component
public class CommonUtil {

	@Autowired
	private UsersMapper usersMapper;

	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

	public void handleServiceExceptio(CustomException ex) throws CustomException {
		if (ex != null && ex.getErrorInfo() != null) {
			throw new CustomException(ex.getErrorInfo());
		}
	}

	public String generateStudentId() {
		String id = null;
		Random rand = new Random();
		long x = (long) (rand.nextDouble() * 100000000L);
		id = "88" + String.format("%08d", x);
		UsersExample infoExample = new UsersExample();
		infoExample.createCriteria().andUserIdEqualTo(id);
		long count = usersMapper.countByExample(infoExample);
		return count == 0 ? id : generateStudentId();
	}

	public Date convertStringToDate(String birthDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse(birthDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String generateToken() {
		StringBuilder token = new StringBuilder();
		return token.append(UUID.randomUUID().toString()).append(UUID.randomUUID().toString()).toString();
	}

	public boolean isTokenExpired(final LocalDateTime tokenCreationDate) {

		LocalDateTime now = LocalDateTime.now();
		Duration diff = Duration.between(tokenCreationDate, now);
		return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
	}

	public String getSaltString() {
		String saltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) {
			int index = (int) (rnd.nextFloat() * saltChars.length());
			salt.append(saltChars.charAt(index));
		}
		return salt.toString();
	}
}
