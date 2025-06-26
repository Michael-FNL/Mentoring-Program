package util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {
    public static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(5,5);
    }

    public static final String getRandomString(final String name) {
        return name + "_test";
    }

    public static Integer getRandomInteger() {
        return Integer.parseInt(RandomStringUtils.randomNumeric(1,2));
    }

    public static String getRandomAlphaNumeric() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
