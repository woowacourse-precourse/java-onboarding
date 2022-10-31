package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    //  연속되는 중복 문자의 Index를 확인하는 메소드
    private static List<Integer> checkCryptogram(String cryptogram) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) index.add(i);
        }
        return index;
    }

    //  연속되는 중복문자를 삭제하는 메소드
    private static String deleteOverlap(StringBuilder stringBuilder, List<Integer> index) {
        Collections.reverse(index);
        for (int i : index) {
            stringBuilder.delete(i, i + 2);
        }
        return stringBuilder.toString();
    }
}
