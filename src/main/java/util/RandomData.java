package util;

import org.apache.commons.lang3.RandomStringUtils;
import java.security.SecureRandom;

public class RandomData {
    public static final int RANDOM_STRING_LENGTH = 5;
    public static final int RANDOM_NUMBER_LENGTH_ONE = 1;
    public static final int RANDOM_NUMBER_LENGTH_TWO = 2;
    public static final int RANDOM_NUMBER_LENGTH_TEN = 10;

    private static final SecureRandom secureRandom = new SecureRandom();

    public static String getRandomString() {
        // Генеруємо рядок з точною довжиною RANDOM_STRING_LENGTH
        return RandomStringUtils.randomAlphabetic(RANDOM_STRING_LENGTH);
    }

    public static String getRandomString(final String name) {
        return name + "_test";
    }

    public static Integer getRandomInteger() {
        // Визначаємо довжину випадкового числа (між 1 і 2)
        int length = RANDOM_NUMBER_LENGTH_ONE + secureRandom.nextInt(RANDOM_NUMBER_LENGTH_TWO - RANDOM_NUMBER_LENGTH_ONE + 1);

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int digit = secureRandom.nextInt(10); // цифра 0-9
            sb.append(digit);
        }
        return Integer.parseInt(sb.toString());
    }

    public static String getRandomAlphaNumeric() {
        // Залишаємо як є — це не для безпеки
        return RandomStringUtils.randomAlphanumeric(RANDOM_NUMBER_LENGTH_TEN);
    }
}
