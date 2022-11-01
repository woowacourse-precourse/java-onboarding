package onboarding;

import java.util.ArrayList;
import java.util.List;

import static onboarding.Problem2.Problem2Validation.validate;
import static onboarding.Util.convertCharacterListToString;
import static onboarding.Util.convertStringToCharacterList;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (!validateInput(cryptogram)) {
            return cryptogram;
        }
        return calculateAnswer(cryptogram);
    }

    private static boolean validateInput(String cryptogram) {
        return validate(cryptogram);
    }

    private static String calculateAnswer(String cryptogram) {
        if (calculateIsDecoded(cryptogram)) {
            return cryptogram;
        }
        cryptogram = deleteDuplication(cryptogram);
        return calculateAnswer(cryptogram);
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

    private static boolean calculateIsDecoded(String cryptogram) {
        char previousCharacter = 0;
        for (char character : convertStringToCharacterList(cryptogram)) {
            if (previousCharacter == character) {
                return false;
            }
            previousCharacter = character;
        }
        return true;
    }

    static abstract class Problem2Validation extends Validation {
        private static final int MIN_LENGTH = 1;
        private static final int MAX_LENGTH = 1000;

        public static boolean validate(String cryptogram) {
            return validateNotNull(cryptogram)
                    && validateStringLengthRange(cryptogram, MIN_LENGTH, MAX_LENGTH)
                    && validateLowerAlphabet(cryptogram);
        }
    }
}
