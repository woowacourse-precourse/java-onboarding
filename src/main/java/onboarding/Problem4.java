package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static final int MIN_WORD_SIZE = 1;
    private static final int MAX_WORD_SIZE = 1000;

    private static final int UPPERCASE_ASCII_START = 65;
    private static final int UPPERCASE_ASCII_END = 90;

    private static final int LOWERCASE_ASCII_START = 97;
    private static final int LOWERCASE_ASCII_END = 122;
    public static String solution(String word) {
        wordRangeValidation(word);

        Map<Character, Character> cachedAlphabet = new HashMap<>();
        putUpperCaseKeyAndValue(cachedAlphabet);
        putLowerCaseKeyAndValue(cachedAlphabet);

        return makeSentence(word, cachedAlphabet);
    }

    private static String makeSentence(String word, Map<Character, Character> cachedAlphabet) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            answer += convertLetter(word.charAt(i), cachedAlphabet);
        }
        return answer;
    }

    private static String convertLetter(Character letter, Map<Character, Character> cachedAlphabet) {
        if (isAlphabet(letter, cachedAlphabet)) {
            return String.valueOf(cachedAlphabet.get(letter));
        }
        return String.valueOf(letter);
    }
    private static boolean isAlphabet(Character letter, Map<Character, Character> cachedAlphabet) {
        return cachedAlphabet.containsKey(letter);
    }

    private static void putLowerCaseKeyAndValue(Map<Character, Character> cachedAlphabet) {
        int lowercaseASCIIValue = 122;
        for (int i = LOWERCASE_ASCII_START; i <= LOWERCASE_ASCII_END; i++) {
            cachedAlphabet.put((char) i, (char) lowercaseASCIIValue);
            lowercaseASCIIValue -= 1;
        }
    }

    private static void putUpperCaseKeyAndValue(Map<Character, Character> cachedAlphabet) {
        int uppercaseASCIIValue = 90;
        for (int i = UPPERCASE_ASCII_START; i <= UPPERCASE_ASCII_END; i++) {
            cachedAlphabet.put((char) i, (char) uppercaseASCIIValue);
            uppercaseASCIIValue -= 1;
        }
    }
    private static void wordRangeValidation(String word) {
        if (word.length() < MIN_WORD_SIZE || word.length() > MAX_WORD_SIZE) {
            throw new IllegalArgumentException("1이상 1000 이하 길이의 문자열만 입력 가능합니다");
        }
    }
}
