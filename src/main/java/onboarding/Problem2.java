package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        try {
            ExceptionProblem2.validateCryptogram(cryptogram);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return "";
        }

        List<Character> cryptogramList = cryptogram.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> result = new ArrayList<>(cryptogramList);

        int beforeLength = cryptogramList.size();
        int afterLength = -1;

        while (beforeLength != afterLength) {

            beforeLength = cryptogramList.size();
            HashSet<Integer> indexSet = new HashSet<>();

            for (int i = 0; i < beforeLength - 1; i++) {

                if (cryptogramList.get(i) == cryptogramList.get(i+1)) {
                    indexSet.add(i);
                    indexSet.add(i+1);
                }
            }

            if (indexSet.size() == 0) {
                break;
            }

            List<Integer> indexList = new ArrayList<>(indexSet);
            Collections.sort(indexList, Collections.reverseOrder());

            for (int index : indexList) {
                result.remove(index);
            }
            afterLength = result.size();

            cryptogramList = new ArrayList<>(result);
        }

        if (result.size() != 0) {
            answer = result.stream()
                    .map(e -> e.toString())
                    .reduce((acc, e) -> acc + e)
                    .get();
        }

        return answer;
    }
}

class ExceptionProblem2 {
    static final String ERROR_MESSAGE = "입력이 잘못 입력되었습니다.";

    public static void validateCryptogram(String cryptogram) {
        enteredName(cryptogram);
        isSpace(cryptogram);
        validateStringLength(cryptogram);
        validateOnlyEnglish(cryptogram);
        validateLowerCase(cryptogram);
    }

    public static void enteredName(String cryptogram) {
        if (cryptogram.equals("")) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void isSpace(String cryptogram) {
        if (cryptogram.contains(" ")) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void validateStringLength(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void validateOnlyEnglish(String cryptogram) {
        if (!Pattern.matches("^[a-zA-Z]*$", cryptogram)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void validateLowerCase(String cryptogram) {
        for (char c : cryptogram.toCharArray()) {
            if (Character.isUpperCase(c)) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
    }
}