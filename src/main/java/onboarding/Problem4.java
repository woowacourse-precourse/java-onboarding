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

    private static String convertArrayToString(char[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : array) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    private static char encodeCharacter(char ch) {
        if (isAlphabet(ch)) {
            return encodeAlphabet(ch);
        }
        return ch;
    }

    private static boolean isAlphabet(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
    }

    private static char encodeAlphabet(char ch) {
        if (isAlphabetUpperCase(ch)) {
            return encodeAlphabetUpperCase(ch);
        }
        return encodeAlphabetLowerCase(ch);
    }

    private static boolean isAlphabetUpperCase(char ch) {
        return 'A' <= ch && ch <= 'Z';
    }

    private static char encodeAlphabetLowerCase(char ch) {
        return (char) ('a' + 'z' - ch);
    }

    private static char encodeAlphabetUpperCase(char ch) {
        return (char) ('A' + 'Z' - ch);
    }
}
