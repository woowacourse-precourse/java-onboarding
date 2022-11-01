package onboarding;

public class Problem4 {

    private static int MIN_WORD_LENGTH = 1;
    private static int MAX_WORD_LENGTH = 1000;

    public static String solution(String word) {
        if (isOutOfRange(word)) return "";
        
        return convertWord(word);
    }

    private static String convertWord(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i);
            int n = 32; // ASCII 공백 ' '

            if (Character.isUpperCase(c)) n = 64 + 26 - ((int)c - 65);
            else if (Character.isLowerCase(c)) n = 96 + 26 - ((int)c - 97);

            answer.append((char) n);
        }

        return answer.toString();
    }

    private static boolean isOutOfRange(String word) {
        return word.length() < MIN_WORD_LENGTH || word.length() > MAX_WORD_LENGTH;
    }
}
