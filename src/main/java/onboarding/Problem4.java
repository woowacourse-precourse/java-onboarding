package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] word_array = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            if (isChar(word_array[i])) {
                word_array[i] = swap_char(word_array[i]);
            }
        }

        return String.valueOf(word_array);
    }

    public static char swap_char(char c) {
        return (c >= 65 && c <= 90) ? (char) (90 - (c - 65)) : (char) (122 - (c - 97));
    }

    public static boolean isChar(char w) {
        return Character.isLetter(w) ? true : false;
    }
}
