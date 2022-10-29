package onboarding;

import onboarding.problem2.Problem2Validation;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class Problem2 {

    private static final int INPUT_MAX_LENGTH = 1000;
    private static final int INPUT_MIN_LENGTH = 1;


    public static String solution(String cryptogram) {
        if (Problem2Validation.problem2InputValidation(cryptogram, INPUT_MIN_LENGTH, INPUT_MAX_LENGTH)) {
            while (true) {
                Optional<String> duplicateIndex = returnExceptForDuplicateSubString(cryptogram);
                if (duplicateIndex.isPresent()) {
                    cryptogram = duplicateIndex.get();
                } else {
                    return cryptogram;
                }
            }
        } else {
            return "";
        }
    }

    private static Optional<String> returnExceptForDuplicateSubString(String cryptogram) {
        if (cryptogram.length() <= 1) {
            return Optional.ofNullable(null);
        }
        StringBuilder result = new StringBuilder();
        int front = 0;
        int back = 1;
        for (; front < cryptogram.length()-1; front++) {
            for (back = front + 1; back < cryptogram.length(); back++) {
                if (cryptogram.charAt(front) != cryptogram.charAt(back)) {
                    break;
                }
            }
            if (front + 1 != back) {
                break;
            }
        }
        if (front != back) {
            result.append(cryptogram, 0, front);
            result.append(cryptogram.substring(back));
            return Optional.ofNullable(result.toString());
        } else {
            return Optional.ofNullable(null);
        }


    }


}
