package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder convertedWord = new StringBuilder(word.length());
        for (char letter : word.toCharArray()) convertedWord.append(convertWithDictionary(letter));
        return convertedWord.toString();
    }

    static char convertWithDictionary(char letter) {
        final char ALPHABET_UPPERCASE_START = 'A';
        final char ALPHABET_UPPERCASE_END = 'Z';
        final char ALPHABET_LOWERCASE_START = 'a';
        final char ALPHABET_LOWERCASE_END = 'z';

        if (Character.isUpperCase(letter)) return (char) (ALPHABET_UPPERCASE_END - (letter - ALPHABET_UPPERCASE_START));
        if (Character.isLowerCase(letter)) return (char) (ALPHABET_LOWERCASE_END - (letter - ALPHABET_LOWERCASE_START));
        return letter;
    }
}
