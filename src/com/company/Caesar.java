package com.company;

public class Caesar implements Encoder{
	private int key;

	@Override
	public StringBuilder encrypt(final String text) {
		StringBuilder encrypt = new StringBuilder();
		int c = 0;
		int y = 0;

		for (int i = 0; i < text.length(); i++) {
			c =  (text.charAt(i) + key);
			y = (c - 1040) % 32 + 1040; // 1040 - это код буквы А, 32 - это кол-во букв
			encrypt.append((char) y); // получаем букву по коду
		}

		return encrypt;
	}

	@Override
	public StringBuilder decrypt(final String text) {
		StringBuilder decrypt = new StringBuilder();
		int c = 0;
		int y ;

		for (int i = 0; i < text.length(); i++) {
			c =  (text.charAt(i) - key);
			y = (c - 1040) % 32 + 1040; // 1040 - это код буквы А, 32 - это кол-во букв
			decrypt.append((char) y); // получаем букву по коду
		}

		return decrypt;
	}

	@Override
	public void setKey(String key) {
		this.key = Integer.parseInt(key);
	}

}
