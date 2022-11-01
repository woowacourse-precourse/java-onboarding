package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            if (isChar(wordArray[i])) {
                wordArray[i] = swapChar(wordArray[i]);
            }
        }

        return String.valueOf(wordArray);
    }

    public static char swapChar(char c) {
        return (c >= 65 && c <= 90) ? (char) (90 - (c - 65)) : (char) (122 - (c - 97));
    }

    public static boolean isChar(char w) {
        return Character.isLetter(w) ? true : false;
    }
}
