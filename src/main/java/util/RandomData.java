package util;

import java.security.SecureRandom;

public class RandomData {
    public static final int RANDOM_STRING_LENGTH = 5;
    public static final int RANDOM_NUMBER_LENGTH_ONE = 1;
    public static final int RANDOM_NUMBER_LENGTH_TWO = 2;
    public static final int RANDOM_NUMBER_LENGTH_TEN = 10;

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String getRandomString() {
        StringBuilder sb = new StringBuilder(RANDOM_STRING_LENGTH);
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            int index = SECURE_RANDOM.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }
        return sb.toString();
    }

    public static String getRandomString(final String name) {
        return name + "_test";
    }

    public static Integer getRandomInteger() {
        int length = RANDOM_NUMBER_LENGTH_ONE + SECURE_RANDOM
                .nextInt(RANDOM_NUMBER_LENGTH_TWO - RANDOM_NUMBER_LENGTH_ONE + RANDOM_NUMBER_LENGTH_ONE);
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int digit = SECURE_RANDOM.nextInt(RANDOM_NUMBER_LENGTH_TEN);
            sb.append(digit);
        }
        return Integer.parseInt(sb.toString());
    }

    public static String getRandomAlphaNumeric() {
        StringBuilder sb = new StringBuilder(RANDOM_NUMBER_LENGTH_TEN);
        for (int i = 0; i < RANDOM_NUMBER_LENGTH_TEN; i++) {
            int index = SECURE_RANDOM.nextInt(ALPHANUMERIC.length());
            sb.append(ALPHANUMERIC.charAt(index));
        }
        return sb.toString();
    }
}
