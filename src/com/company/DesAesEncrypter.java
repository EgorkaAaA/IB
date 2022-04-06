package com.company;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import sun.misc.BASE64Encoder;


class DesAesEncrypter implements Encoder {
	Cipher ecipher;
	Cipher dcipher;

	public StringBuilder encrypt(String str) {
		try {
			byte[] utf8 = str.getBytes("UTF8");
			byte[] enc = ecipher.doFinal(utf8);
			return new StringBuilder(new BASE64Encoder().encode(enc));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public StringBuilder decrypt(String str) {
		try {
			byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
			byte[] utf8 = dcipher.doFinal(dec);
			return new StringBuilder(new String(utf8, "UTF8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setKey(String key) {
		try {
			SecretKey secretKey = KeyGenerator.getInstance(key).generateKey();
			ecipher = Cipher.getInstance(key);
			dcipher = Cipher.getInstance(key);
			ecipher.init(Cipher.ENCRYPT_MODE, secretKey);
			dcipher.init(Cipher.DECRYPT_MODE, secretKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}