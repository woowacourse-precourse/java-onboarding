package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    private static boolean hasDuplicatedChar(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1))
                return true;
        }
        return false;
    }
    private static boolean[] checkDuplicatedChar(String cryptogram) {
        int len = cryptogram.length();
        boolean[] isDuplicatedChar = new boolean[len];

        for (int i = 0; i < len - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                isDuplicatedChar[i] = true;
                isDuplicatedChar[i + 1] = true;
            }
        }
        return isDuplicatedChar;
    }
}