package onboarding;

import onboarding.problem2.Problem2Validation;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class Problem2 {

    private static final int INPUT_MAX_LENGTH = 1000;
    private static final int INPUT_MIN_LENGTH = 1;


    public static String solution(String cryptogram) {
        String result = "";
        if (Problem2Validation.problem2InputValidation(cryptogram, INPUT_MIN_LENGTH, INPUT_MAX_LENGTH)) {
            result = compressOverlappingWord(cryptogram);
        }
        return result;
    }

    private static String compressOverlappingWord(String cryptogram) {
        StringBuilder afterCompressionExtractFromStack = new StringBuilder();


    }


}
