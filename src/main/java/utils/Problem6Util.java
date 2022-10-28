package utils;

public class Problem6Util {

    public static final int LIMIT = 2;

    public static boolean isDuplicated(String str1, String str2) {
        if (str1.length() < LIMIT || str2.length() < LIMIT) return false;
        if (str1.length() < str2.length() && isValid(str1, str2)) {
            return true;
        }
        return isValid(str2, str1);
    }

    private static boolean isValid(String str1, String str2) {
        for (int i = LIMIT; i <= str1.length(); i++) {
            if (str2.contains(str1.substring(0, i))) {
                return true;
            }
        }
        return false;
    }
}
