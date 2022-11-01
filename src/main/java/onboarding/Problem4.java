package onboarding;

public class Problem4 {

    public final static int ASCII_ALPHABET_UPPER_A = 65;
    public final static int ASCII_ALPHABET_UPPER_Z = 90;
    public final static int ASCII_ALPHABET_LOWER_A = 97;
    public final static int ASCII_ALPHABET_LOWER_Z = 122;

    public static String solution(String word) {
        String answer = "";

        answer = getChangedWord(word);

        return answer;
    }

    public static String getChangedWord(String word) {
        String result = "";
        for(int i = 0 ; i < word.length(); i++) {
            char changedChar = word.charAt(i);
            int asciiOfChar = (int)changedChar;
            if(asciiOfChar >= ASCII_ALPHABET_UPPER_A && asciiOfChar <= ASCII_ALPHABET_UPPER_Z) {
                changedChar = (char)(ASCII_ALPHABET_UPPER_A + ASCII_ALPHABET_UPPER_Z - asciiOfChar);
            }
            else if(asciiOfChar >= ASCII_ALPHABET_LOWER_A && asciiOfChar <= ASCII_ALPHABET_LOWER_Z) {
                changedChar = (char)(ASCII_ALPHABET_LOWER_A + ASCII_ALPHABET_LOWER_Z - asciiOfChar);
            }
            result += changedChar;
        }
        return result;
    }
}
