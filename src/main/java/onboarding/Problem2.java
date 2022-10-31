package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2 {

    //반복되는 문자 인덱스 찾기
    private static List<Integer> findRepeatedIndex(String cryptogram) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                index.add(i);
                index.add(i+1);
            }
        }
        Set<Integer> set = new HashSet<>(index);
        List<Integer> repeatedIndex = new ArrayList<>();
        return repeatedIndex;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";


        return answer;
    }
}
