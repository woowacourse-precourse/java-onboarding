package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static String getDecryptedWord(String cryptogram) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (i != 0 && cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
                continue;
            }
            else if (i != cryptogram.length() - 1 && cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                continue;
            }

            result.append(cryptogram.charAt(i));
        }

        return result.toString();
    }
}