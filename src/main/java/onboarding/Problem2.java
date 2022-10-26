package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return getDecryptionText(cryptogram);
    }

    private static boolean hasDuplicateCharacters(String text) {
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == text.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static String deleteDuplicateCharacters(String text) {
        return text.replaceAll("(\\w)\\1+", "");
    }

    private static String getDecryptionText(String text) {
        while (hasDuplicateCharacters(text)) {
            text = deleteDuplicateCharacters(text);
        }
        return text;
    }
}
