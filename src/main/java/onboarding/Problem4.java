package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static List<Character> characterList = new ArrayList<>();

    private static class Constants {
        public static final char FIRST_UPPER_ALPHABET = 'A';
        public static final char MIDDLE_UPPER_ALPHABET = 'M';
        public static final char LAST_UPPER_ALPHABET = 'Z';

        public static final char FIRST_LOWER_ALPHABET = 'a';
        public static final char MIDDLE_LOWER_ALPHABET = 'm';
        public static final char LAST_LOWER_ALPHABET = 'z';
    }

    public static void main(String[] args) {
        System.out.println(solution("WootE"));
    }

    public static String solution(String word) {
        return converterAlphabet(word);
    }

    private static String converterAlphabet(String word) {
        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);
            if (Constants.FIRST_UPPER_ALPHABET <= alphabet && alphabet <= Constants.LAST_UPPER_ALPHABET) {
                converterUpperAlphabet(alphabet);
            } else if (Constants.FIRST_LOWER_ALPHABET <= alphabet && alphabet <= Constants.LAST_LOWER_ALPHABET) {
                converterLowerAlphabet(alphabet);
            } else {
                characterList.add(alphabet);
            }
        }

        return charsToString();
    }

    private static void converterUpperAlphabet(char alphabet) {
        int alphabetInterval = 27;
        if (alphabet < Constants.MIDDLE_UPPER_ALPHABET) {
            for (int i = Constants.FIRST_UPPER_ALPHABET; i <= alphabet; i++) {
                alphabetInterval -= 2;
            }
            alphabet += alphabetInterval;
        } else {
            for (int i = Constants.LAST_UPPER_ALPHABET; i >= alphabet; i--) {
                alphabetInterval -= 2;
            }
            alphabet -= alphabetInterval;
        }
        characterList.add(alphabet);
    }

    private static void converterLowerAlphabet(char alphabet) {
        int alphabetInterval = 27;
        if (alphabet < Constants.MIDDLE_LOWER_ALPHABET) {
            for (int i = Constants.FIRST_LOWER_ALPHABET; i <= alphabet; i++) {
                alphabetInterval -= 2;
            }
            alphabet += alphabetInterval;
        } else {
            for (int i = Constants.LAST_LOWER_ALPHABET; i >= alphabet; i--) {
                alphabetInterval -= 2;
            }
            alphabet -= alphabetInterval;
        }
        characterList.add(alphabet);
    }

    private static String charsToString() {
        StringBuilder sb = new StringBuilder();
        for (char alphabet : characterList) {
            sb.append(alphabet);
        }

        return sb.toString();
    }
}
