package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DuplicateCryptogramDecoder {
    public static String decode(String cryptogram) {
        Validator.validateLength(cryptogram);
        Validator.validateLowerCase(cryptogram);
        while (hasDuplication(cryptogram)) {
            cryptogram = deleteFrom(cryptogram);
        }
        return cryptogram;
    }

    public static String deleteFrom(String target) {
        List<Character> chars = Arrays.stream(target.split(""))
                .map(str -> Character.valueOf(str.charAt(0)))
                .collect(Collectors.toList());

        List <Character> result = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
            Character character = chars.get(i);
            if (isDifferentWithPrev(chars, i) && isDifferentWithNext(chars, i)) {
                result.add(character);
            }
        }

        return asString(result);
    }

    static boolean hasDuplication(String target) {
        for (int i = 0; i < target.length() - 1; i++) {
            if (target.charAt(i) == target.charAt(i + 1)) return true;
        }
        return false;
    }
    private static boolean isDifferentWithPrev(List<Character> characters, int index) {
        return index == 0 || !characters.get(index - 1).equals(characters.get(index));
    }

    private static boolean isDifferentWithNext(List<Character> characters, int index) {
        return index == characters.size() - 1 || !characters.get(index + 1).equals(characters.get(index));
    }


    private static String asString(List<Character> characters) {
        StringBuilder sb = new StringBuilder();

        for (Character character : characters) {
            sb.append(character);
        }

        return sb.toString();
    }

    private static class Validator {
        private static final String ERR_EMPTY_CODE = "암호는 1 이상 1000 이하 길이를 가져야 합니다.";
        private static final String ERR_LOWER_CASE = "암호는 영어 소문자로만 구성되어야 합니다.";
        private static final int LENGTH_LOWER_BOUNDS = 1;
        private static final int LENGTH_UPPER_BOUNDS = 1000;
        private static final char LETTER_LOWER_BOUNDS = 'a';

        private static final char LETTER_UPPER_BOUNDS = 'z';

        private static void validateLength(String cryptogram) {
            if (Objects.requireNonNull(cryptogram).length() < LENGTH_LOWER_BOUNDS
                    ||  cryptogram.length() > LENGTH_UPPER_BOUNDS)
                throw new IllegalArgumentException(ERR_EMPTY_CODE);

        }

        private static void validateLowerCase(String cryptogram) {
            for (char letter : cryptogram.toCharArray()) {
                validateLowerCase(letter);
            }
        }

        private static void validateLowerCase(char letter) {
            if (letter < LETTER_LOWER_BOUNDS || letter > LETTER_UPPER_BOUNDS)
                throw new IllegalArgumentException(ERR_LOWER_CASE);
        }
    }

}
