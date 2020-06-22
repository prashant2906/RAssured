package com.utilities;

import java.io.IOException;
import java.util.Random;

import com.driver.Driver;


public class TestDataGenerator extends Driver {

	public final static String ALPHABET_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public final static int NUMERICS = 123456789;

	public static String randomString() throws IOException {

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			int character = (int) (Math.random() * ALPHABET_STRING.length());
			builder.append(ALPHABET_STRING.charAt(character));
		}

		return builder.toString();

	}

	public String generateMobNum() throws IOException {

		String mobNum = generateRandomChars("i", 9);
		System.out.println("Mobile Number : " + mobNum);

		return mobNum;

	}

	public String generatePANCard() throws IOException {

		String panCardNo = "BCSPG" + generateRandomChars("i", 4)
				+ generateRandomChars("a", 1);

		return panCardNo;

	}

	public String generatePassportNo() throws IOException {

		String passportNo = "M" + generateRandomChars("i", 7);

		return passportNo;

	}

	public String generateRandomChars(String candidateType, int length) {

		String candidateChars = "";
		if (candidateType == "a") {
			candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		}
		if (candidateType == "i") {
			candidateChars = "0123456789";
		}
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
		}

		return sb.toString();
	}

}
