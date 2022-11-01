package onboarding;

import java.util.ArrayList;
import java.util.List;

import static onboarding.Problem4.Problem4Validation.validate;
import static onboarding.Util.*;

public class Problem4 {
    public static String solution(String word) {
        if (!validateInput(word)) {
            return word;
        }
        return calculateAnswer(word);
    }

    private static boolean validateInput(String word) {
        return validate(word);
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

    static abstract class Problem4Validation extends Validation {
        private static final int MIN_LENGTH = 1;
        private static final int MAX_LENGTH = 1000;

        public static boolean validate(String word) {
            return validateNotNull(word)
                    && validateStringLengthRange(word, MIN_LENGTH, MAX_LENGTH);
        }
    }
}
