package onboarding;

import onboarding.problem2.Problem2Validation;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

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
        String beforeCompression;
        do {
            beforeCompression = cryptogram;
            cryptogram = compressString(cryptogram);
        } while (beforeCompression.length() != cryptogram.length());
        return cryptogram;
    }

    private static String compressString(String cryptogram) {
        int idx = 0;
        StringBuilder thisTurnCompression = new StringBuilder();
        while (idx < cryptogram.length()) {
            if (idx + 1 < cryptogram.length()) {
                if (cryptogram.charAt(idx) == cryptogram.charAt(idx + 1)) {
                    idx = findOverlappingWordCharIdx(cryptogram.charAt(idx), cryptogram, idx + 1);
                } else if (cryptogram.charAt(idx) != cryptogram.charAt(idx + 1)) {
                    thisTurnCompression.append(cryptogram.charAt(idx));
                }
            } else if (idx + 1 == cryptogram.length()) {
                thisTurnCompression.append(cryptogram.charAt(idx));
            }
            idx += 1;
        }

        return thisTurnCompression.toString();
    }

    private static int findOverlappingWordCharIdx(char word, String cryptogram, int idx) {
        while (idx < cryptogram.length()) {
            char thisTurnWord = cryptogram.charAt(idx);
            if (thisTurnWord == word) {
                idx += 1;
            } else if (thisTurnWord != word) {
                break;
            }
        }
        return idx - 1;
    }


}
