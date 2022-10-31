package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return cryptogramChecker(cryptogram);
    }
    private static String cryptogramChecker(String cryptogram) {
        StringBuilder str = new StringBuilder(cryptogram);
        for (int i = 0; i < str.length(); i++) {
            if ((i + 1) != str.length()) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    str.delete(i, i + 2);
                    return cryptogramChecker(str.toString());
                }
            }
        }
        return str.toString();
    }
}
