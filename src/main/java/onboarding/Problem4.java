package onboarding;


public class Problem4 {
    public static String solution(String word) {
        return convertWord(word);
    }

    private static String convertWord(String word) {
        StringBuilder result = new StringBuilder();

        for (char c : word.toCharArray()) {
            result.append((char) findPair(c));
        }

        return result.toString();
    }

    private static int findPair(char targetChar) {
        if (65 <= targetChar && targetChar <= 90) {
            return 155 - targetChar;
        } else if (97 <= targetChar && targetChar <= 122) {
            return 219 - targetChar;
        }
        return targetChar;
    }
}
