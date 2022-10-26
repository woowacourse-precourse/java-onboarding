package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static int getContinuousIndex(String text) {
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == text.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }

    private static String deleteDuplicateCharacters(String text) {
        return text.replaceAll("(\\w)\\1+", "");
    }

    private static String getDecryptionText(String text) {
        while (getContinuousIndex(text) != -1) {
            text = deleteDuplicateCharacters(text);
        }
        return text;
    }
}
