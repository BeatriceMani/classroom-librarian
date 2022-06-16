package util;

import org.apache.commons.lang3.RandomStringUtils;

public class ClassroomLibrarianUtils {
    private static final int ID_LENGTH = 10;

    private ClassroomLibrarianUtils() {}


    public static String generateId() {
        return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    }

    public static Boolean validateString(String s) {
        return true;
    }

}
