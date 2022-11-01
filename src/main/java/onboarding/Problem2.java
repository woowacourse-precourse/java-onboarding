package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decode(cryptogram);
    }

    private static List<Integer> findConsecutiveChar(StringBuffer cryptogram) {
        List<Integer> charsToRemove = new ArrayList<>();

        for (int index = 0; index < cryptogram.length() - 1; index++) {
            if (cryptogram.charAt(index) == cryptogram.charAt(index + 1)) {     // 다음 글자와 같을 경우
                charsToRemove.add(index);
                charsToRemove.add(index + 1);
            }
        }
        return charsToRemove;
    }

    private static StringBuffer removeConsecutiveChar(StringBuffer cryptogram) {
        List<Integer> charsToRemove = findConsecutiveChar(cryptogram);

        if (charsToRemove.size() == 0) {    // 더이상 연속되는 문자가 없을 경우
            return cryptogram;
        }

        charsToRemove = charsToRemove.stream().distinct().collect(Collectors.toList());
        Collections.sort(charsToRemove);
        Collections.reverse(charsToRemove);

        for (int index : charsToRemove) {
            cryptogram.deleteCharAt(index);
        }

        return cryptogram;
    }

    private static String decode(String cryptogram) {
        StringBuffer newCryptogram = new StringBuffer(cryptogram);

        while (findConsecutiveChar(newCryptogram).size() != 0) {
            newCryptogram = removeConsecutiveChar(newCryptogram);
        }

        return newCryptogram.toString();
    }

}
