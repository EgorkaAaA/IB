package com.company;

public class Vigenère implements Encoder {
	final int bias = 1072;
	final int letters = 33;

	private String key;

	@Override
	public StringBuilder encrypt(String text) {
		StringBuilder encrypt = new StringBuilder();
		final int keyLen = key.length();
		for (int i = 0, len = text.length(); i < len; i++) {
			encrypt.append((char) (((text.charAt(i) + key.charAt(i % keyLen)) % letters) + bias));
		}
		return encrypt;
	}

	@Override
	public StringBuilder decrypt(String text) {
		StringBuilder decrypt = new StringBuilder();

		final int keyLen = key.length();
		for (int i = 0, len = text.length(); i < len; i++) {
			decrypt.append((char) (((text.charAt(i) - key.charAt(i % keyLen) + letters) % letters) + bias));
		}
		return decrypt;
	}

	@Override
	public void setKey(String key) {
		this.key = key;
	}

}
