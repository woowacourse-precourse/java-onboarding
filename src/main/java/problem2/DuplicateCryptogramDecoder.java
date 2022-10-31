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
        List<Character> cryptogramList = asCharacterList(cryptogram);
        while (hasContinuousDuplication(cryptogramList)) {
            cryptogramList = deleteContinuousDuplicationFrom(cryptogramList);
        }
        return asString(cryptogramList);
    }

    private static List<Character> asCharacterList(String str) {
        return Arrays.stream(str.split(""))
                .map(sttr -> Character.valueOf(sttr.charAt(0)))
                .collect(Collectors.toList());
    }

    public static List<Character> deleteContinuousDuplicationFrom(List<Character> target) {


        List <Character> result = new ArrayList<>();
        for (int i = 0; i < target.size(); i++) {
            Character character = target.get(i);
            if (isDifferentWithPrev(target, i) && isDifferentWithNext(target, i)) {
                result.add(character);
            }
        }

        return result;
    }

    static boolean hasContinuousDuplication(List<Character> target) {
        for (int i = 0; i < target.size() - 1; i++) {
            if (target.get(i).equals(target.get(i + 1))) return true;
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
