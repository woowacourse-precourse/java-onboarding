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
        System.out.println(solution("I love you"));
    }

    public static String solution(String word) {
        return converterAlphabet(word);
    }

    private static String converterAlphabet(String word) {
        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);

            if (65 <= alphabet && alphabet <= 90) {
                converterUpperAlphabet(alphabet);
            } else if (97 <= alphabet && alphabet <= 122) {
                converterLowerAlphabet(alphabet);
            } else {
                characterList.add(alphabet);
            }

        }

        StringBuilder sb = new StringBuilder();
        for (char alphabet : characterList) {
            sb.append(alphabet);
        }

        return sb.toString();
    }

    private static void converterUpperAlphabet(char alphabet) {
        int alphabetInterval = 27;

        if (alphabet < Constants.MIDDLE_UPPER_ALPHABET) {
            for (int j = Constants.FIRST_UPPER_ALPHABET; j <= alphabet; j++) {
                alphabetInterval -= 2;
            }
            alphabet += alphabetInterval;

        } else {
            for (int j = Constants.LAST_UPPER_ALPHABET; j >= alphabet; j--) {
                alphabetInterval -= 2;
            }
            alphabet -= alphabetInterval;
        }
        characterList.add(alphabet);
    }

    private static void converterLowerAlphabet(char alphabet) {
        int alphabetInterval = 27;

        if (alphabet < Constants.MIDDLE_LOWER_ALPHABET) {
            for (int j = Constants.FIRST_LOWER_ALPHABET; j <= alphabet; j++) {
                alphabetInterval -= 2;
            }
            alphabet += alphabetInterval;

        } else {
            for (int j = Constants.LAST_LOWER_ALPHABET; j >= alphabet; j--) {
                alphabetInterval -= 2;
            }
            alphabet -= alphabetInterval;
        }
        characterList.add(alphabet);
    }
}
