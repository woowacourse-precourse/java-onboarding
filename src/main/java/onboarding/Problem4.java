package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static onboarding.Problem4.Alphabet.*;

public class Problem4 {

    private static final char UPPER_A = 'A';
    private static final char UPPER_M = 'M';
    private static final char UPPER_N = 'N';
    private static final char LOWER_A = 'a';
    private static final char LOWER_M = 'm';
    private static final char LOWER_N = 'n';
    private static final char ALL_ALPHABET_LENGTH = 'Z' - 'A' + 1;

    public static String solution(String word) {
        if (!validateInput(word)) {
            return word;
        }
        return calculateAnswer(word);
    }

    private static boolean validateInput(String word) {
        return Validate.validate(word);
    }

    private static String calculateAnswer(String word) {
        List<Character> answer = new ArrayList<>();

        for (Character character : convertStringToCharacterList(word)) {
            if (Character.isAlphabetic(character)) {
                character = convertToOpposite(character);
            }
            answer.add(character);
        }
        return convertCharacterListToString(answer);
    }

    private static Character convertToOpposite(char character) {
        if (Character.isUpperCase(character)) {
            return convertUpperToOpposite(character);
        }
        return convertLowerToOpposite(character);
    }

    private static char convertUpperToOpposite(char character) {
        if (character < N.alphabet) {
            return (char) (M.alphabet + (N.alphabet - character));
        }
        return (char) (N.alphabet - (character - M.alphabet));
    }

    private static char convertLowerToOpposite(char character) {
        if (character < n.alphabet) {
            return (char) (m.alphabet + (n.alphabet - character));
        }
        return (char) (n.alphabet - (character - m.alphabet));
    }

    private static List<Character> convertStringToCharacterList(String string) {
        return string
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    private static String convertCharacterListToString(List<Character> characterList) {
        return characterList
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    static abstract class Validate {

        private static final int MIN_LENGTH = 1;
        private static final int MAX_LENGTH = 1000;

        public static boolean validate(String word) {
            return validateNotNull(word)
                    && validateSize(word);
        }

        private static boolean validateNotNull(String word) {
            return word != null;
        }

        private static boolean validateSize(String word) {
            return word.length() >= MIN_LENGTH
                    && word.length() <= MAX_LENGTH;
        }

    }

    enum Alphabet {
        A('A'), M('M'), N('N'),
        a('a'), m('m'), n('n');

        private final char alphabet;

        Alphabet(char alphabet) {
            this.alphabet = alphabet;
        }
    }
}
