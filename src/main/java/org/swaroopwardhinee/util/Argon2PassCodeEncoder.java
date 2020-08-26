package org.swaroopwardhinee.util;

import org.springframework.stereotype.Component;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;

@Component
public class Argon2PassCodeEncoder {

	Argon2 argon2 = null;

	public Argon2PassCodeEncoder() {
		this.argon2 = Argon2Factory.create(Argon2Types.ARGON2id);
	}

	public String encode(String passCd) {

		String hashValue = null;
		long start = System.nanoTime();
		hashValue = argon2.hash(6, 512 * 1024, 8, passCd);
		System.out.println("duration: " + (System.nanoTime() - start) / 1000000000.0);
		return hashValue;
	}

	public boolean decode(String hashValue, String password) {
		return argon2.verify(hashValue, password);
	}
}
