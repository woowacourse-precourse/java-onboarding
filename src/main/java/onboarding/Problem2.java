package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (!validation(cryptogram)) return "ERROR";
    }

    static boolean validation(String cryptogram) {
        int length = cryptogram.length();
        if (length == 0 || length > 1000) return false;
        for (char c : cryptogram.toCharArray()) {
            if (!Character.isLowerCase(c)) return false;
        }
        return true;
    }
}
