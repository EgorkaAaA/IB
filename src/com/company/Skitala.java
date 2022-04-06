package com.company;

public class Skitala implements Encoder{
	private int key;

	@Override
	public StringBuilder encrypt(String text) {
		int length = text.length();
		int n =(((Integer) (length-1)/key)+1);
		StringBuilder encrypt = new StringBuilder("");
		for(int i = 0;i <n; i++){
			for(int j = 0;j < key; j++)
			{
				try{
					encrypt.append(text.charAt(i + n * j));
				}catch(IndexOutOfBoundsException e){
					encrypt.append(" ");
				}
			}
		}
		return encrypt;
	}

	@Override
	public StringBuilder decrypt(String text) {
		StringBuilder decrypt = new StringBuilder("");
		int length = text.length();
		int n =(((Integer) (length-1)/key)+1);
		char[] s = new char[text.length()];
		int number =0;
		for(int i = 0; i < n;i++){
			for(int j = 0;j < key; j++)
			{
				s[i+n*j]= text.charAt(number);
				number++;
			}
		}
		for (int i = 0; i < s.length; i++) {
			decrypt.append(s[i]);
		}
		return decrypt;
	}

	@Override
	public void setKey(String key) {
		this.key = Integer.parseInt(key);
	}

}
