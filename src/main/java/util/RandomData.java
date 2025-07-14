package util;

import org.apache.commons.lang3.RandomStringUtils;



public class RandomData {
    public static final int RANDOM_STRING_LENGHT = 5;
    public static final int RANDOM_NUMBER_LENGHT_ONE = 1;
    public static final int RANDOM_NUMBER_LENGHT_TWO = 2;
    public static final int RANDOM_NUMBER_LENGHT_TEN = 10;

    public static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(RANDOM_STRING_LENGHT, RANDOM_STRING_LENGHT);
    }

    public static final String getRandomString(final String name) {
        return name + "_test";
    }

    public static Integer getRandomInteger() {
        return Integer.parseInt(RandomStringUtils.randomNumeric(RANDOM_NUMBER_LENGHT_ONE, RANDOM_NUMBER_LENGHT_TWO));
    }

    public static String getRandomAlphaNumeric() {
        return RandomStringUtils.randomAlphanumeric(RANDOM_NUMBER_LENGHT_TEN);
    }
}
