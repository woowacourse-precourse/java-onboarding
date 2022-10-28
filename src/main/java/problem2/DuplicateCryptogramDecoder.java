package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class DuplicateCryptogramDecoder {
    private static final String ERR_EMPTY_CODE = "암호는 1 이상 1000 이하 길이를 가져야 합니다.";
    private static final String ERR_LOWER_CASE = "암호는 영어 소문자로만 구성되어야 합니다.";
    private static final int LENGTH_LOWER_BOUNDS = 1;
    private static final int LENGTH_UPPER_BOUNDS = 1000;
    private static final char LETTER_LOWER_BOUNDS = 'a';
    private static final char LETTER_UPPER_BOUNDS = 'z';

    public static String decode(String cryptogram) {
        validateLength(cryptogram);
        validateLowerCase(cryptogram);
        return deleteContinuousDuplication(cryptogram);
    }

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

    private static String deleteContinuousDuplication(String cryptogram) {
        List<Character> deleted = deleteContinuousDuplication(cryptogram.toCharArray());

        return asString(deleted);
    }

    private static List<Character> deleteContinuousDuplication(char[] cryptogram) {
        List<Character> charactersInOrder = new ArrayList<>();
        List<Integer> numberOfDuplication = new ArrayList<>();

        for (int i = 0; i < cryptogram.length; ) {
            if (charactersInOrder.isEmpty()) {
                charactersInOrder.add(cryptogram[i]);
                numberOfDuplication.add(1);
                i++;
                continue;
            }
            int lastIndex = charactersInOrder.size() - 1;
            if (charactersInOrder.get(lastIndex) == cryptogram[i]) {
                numberOfDuplication.set(lastIndex
                        , numberOfDuplication.get(lastIndex) + 1);
                i++;
                continue;
            } else {
                if (numberOfDuplication.get(lastIndex) > 1) {
                    charactersInOrder.remove(lastIndex);
                    numberOfDuplication.remove(lastIndex);
                } else {
                    charactersInOrder.add(cryptogram[i]);
                    numberOfDuplication.add(1);
                    i++;
                }
            }
        }

        int lastIndex = numberOfDuplication.size() -1;
        if (numberOfDuplication.get(numberOfDuplication.size() - 1) > 1) {
            charactersInOrder.remove(lastIndex);
            numberOfDuplication.remove(lastIndex);
        }
        return charactersInOrder;
    }

    private static String asString(List<Character> characters) {
        StringBuilder sb = new StringBuilder();

        for (Character character : characters) {
            sb.append(character);
        }

        return sb.toString();
    }
}
