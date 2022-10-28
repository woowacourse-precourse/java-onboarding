package onboarding;

public class Problem2 {

    public static boolean validCheck(String cryptogram) {
        char[] charArray = cryptogram.toCharArray();
        if (cryptogram.length() > 1000 || cryptogram.length() < 1) {
            return false;
        }
        for (char c : charArray) {
            if (Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
