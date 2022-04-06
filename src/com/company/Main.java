package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class Main {

	private static String text;

	public static void main(String[] args) {
//		laba1();
		laba2();
	}

	private static void laba2() {
		doEncode(new DesAesEncrypter());
	}

	private static void laba1() {
		while (true) {
			Scanner in = new Scanner(System.in);
			System.out.println("Выберите метод шифровки: "
					+ "\n1.Шифр Цезаря"
					+ "\n2.Шифр виженера"
					+ "\n3.Шифр Скитала(СПАРТА)"
					+ "\n4.Выход");
			System.out.print("Цифра: ");
			int flag = 0;
			try {
				flag = in.nextInt();
			} catch (Exception e) {
				System.out.println("Введите число");
				clrscr();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}

			if (flag == 1) {
				doEncode(new Caesar());
			} else if (flag == 2) {
				doEncode(new Vigenère());
			} else if (flag == 3) {
				doEncode(new Skitala());
			} else if (flag == 4) {
				break;
			}
		}
	}

	private static void doEncode(Encoder encoder) {
		Scanner in = new Scanner(System.in);
		if(encoder instanceof DesAesEncrypter) {
			while (true) {
				System.out.println("1.Des \n2.Aes");
				int flag = in.nextInt();
				if (flag == 1) {
					encoder.setKey("DES");
					break;
				}
				if (flag == 2) {
					encoder.setKey("AES");
					break;
				}
			}
		} else {
			System.out.print("Введите ключ: ");
			encoder.setKey(in.nextLine());
		}

		while (true) {
			try {
				in = new Scanner(System.in);
				System.out.print("Введите сообщение: ");
				text = in.nextLine();
				if (encDec()) {
					System.out.println("Зашифрованное сообщение: " + encoder.encrypt(text));
				} else {
					System.out.println("Расшифрованное сообщение: " + encoder.decrypt(text));
				}
			} catch (Exception e) {
				break;
			}
		}
	}

	private static boolean encDec() throws NotFound {
		ArrayList<Integer> ints = new ArrayList<>();
		ints.add(1);
		ints.add(2);
		System.out.println("1.Шифровка\n2.Дешифровка\nДругое число выход");
		int flag = 0;
		try {
			flag = new Scanner(System.in).nextInt();
		} catch (Exception e) {
			clrscr();
		}
		if (ints.contains(flag)) {
			return flag == 1;
		} else {
			throw new NotFound();
		}
	}

	private static void clrscr() {
		for (int i = 0; i < 300; i++) // Default Height of cmd is 300 and Default width is 80
		{
			System.out.println("\b"); // Prints a backspace
		}
	}

}
