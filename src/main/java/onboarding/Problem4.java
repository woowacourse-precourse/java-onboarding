package onboarding;

public class Problem4 {
    public static final byte ALPHABET_A = 65;
    public static final byte ALPHABET_Z = 90;
    public static final byte ALPHABET_a = 97;
    public static final byte ALPHABET_z = 122;
    public static final byte ALPHABET_CONVERT_SMALL = 32;
    public static final char[] WORD_CONVERTED = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R'
                                                , 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I'
                                                , 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};

    public static String solution(String word) {
        /*문자 순회하면서 알파벳 찾기*/
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; ++i) {
            /*문자를 사전을 참고하여 변환*/
            wordConverted(words, i);
        }

        String answer = String.valueOf(words);
        return answer;
    }

    private static void wordConverted(char[] words, int i) {
        int wordToInt = 0;

        if (words[i] >= ALPHABET_A && words[i] <= ALPHABET_Z) {
            wordToInt = words[i] - 'A';
            words[i] = WORD_CONVERTED[wordToInt];

        } else if (words[i] >= ALPHABET_a && words[i] <= ALPHABET_z) {
            wordToInt = words[i] - 97;
            words[i] = (char) (WORD_CONVERTED[wordToInt] + ALPHABET_CONVERT_SMALL);
        }
    }
}
