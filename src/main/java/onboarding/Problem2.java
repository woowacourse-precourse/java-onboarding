package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (!validateInput(cryptogram)) {
            return cryptogram;
        }
        return decodeCryptogram(cryptogram);
    }

    private static boolean validateInput(String cryptogram) {
        return Validation.validate(cryptogram);
    }

    private static String decodeCryptogram(String cryptogram) {
        if (isDecoded(cryptogram)) {
            return cryptogram;
        }
        cryptogram = deleteDuplication(cryptogram);
        return decodeCryptogram(cryptogram);
    }

    private static String deleteDuplication(String cryptogram) {
        List<Character> newCharacterList = new ArrayList<>();
        List<Character> characterList = convertStringToCharacterList(cryptogram);
        int index = 0;

        newCharacterList.add(characterList.get(0));
        characterList.remove(0);
        for (char character : characterList) {
            if (newCharacterList.get(index) == character) {
                newCharacterList.remove(index--);
                continue;
            }
            newCharacterList.add(character);
            index++;
        }
        return convertCharacterListToString(newCharacterList);
    }

    private static boolean isDecoded(String cryptogram) {
        char previousCharacter = 0;
        for (char character : convertStringToCharacterList(cryptogram)) {
            if (previousCharacter == character) {
                return false;
            }
            previousCharacter = character;
        }
        return true;
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

    static abstract class Validation {

        private static final int MIN_LENGTH = 1;
        private static final int MAX_LENGTH = 1000;
        private static final String LOWER_ALPHABET_REGEX = "^[a-z]*$";

        public static boolean validate(String cryptogram) {
            return validateNotNull(cryptogram)
                    && validateSize(cryptogram)
                    && validateLowerAlphabet(cryptogram);
        }

        private static boolean validateNotNull(String cryptogram) {
            return cryptogram != null;
        }

        private static boolean validateSize(String cryptogram) {
            return cryptogram.length() >= MIN_LENGTH
                    && cryptogram.length() <= MAX_LENGTH;
        }

        private static boolean validateLowerAlphabet(String cryptogram) {
            return cryptogram.matches(LOWER_ALPHABET_REGEX);
        }
    }
}
