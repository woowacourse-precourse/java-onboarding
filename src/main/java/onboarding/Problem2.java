package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        //  중복 문자의 시작 Index를 담을 List 변수 선언
        List<Integer> index;

        //  입력된 문자열의 중복값이 없을때까지 중복문자를 삭제하는 반복문 작성
        while (!(index = checkCryptogram(cryptogram)).isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder(cryptogram);
            deleteOverlap(stringBuilder, index);
            cryptogram = stringBuilder.toString();
        }

        return cryptogram;
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
