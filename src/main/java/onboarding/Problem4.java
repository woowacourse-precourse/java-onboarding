package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return encode(word);
    }

    private static String encode(String word) {
        char[] words = word.toCharArray();
        char[] encodedWords = new char[words.length];

        for (int i = 0; i < words.length; i++) {
            char encodedCharacter = encodeCharacter(words[i]);
            encodedWords[i] = encodedCharacter;
        }
        return convertArrayToString(encodedWords);
    }
}
