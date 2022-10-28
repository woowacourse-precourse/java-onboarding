package onboarding;

import onboarding.problem2Validation.Problem2Validation;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class Problem2 {

    private final static int INPUT_MAX_LENGTH = 1000;
    private final static int INPUT_MIN_LENGTH = 1;

    class FromTo {
        private int from;

        private int to;

        public void setFromTo(int fr, int to) {
            this.from = fr;
            this.to = to;
        }
    }

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
        return null;
    }


}
