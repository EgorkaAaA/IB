package com.company;

public interface Encoder {
	StringBuilder encrypt(final String text);

	StringBuilder decrypt(final String text);

	void setKey(String key);
}
