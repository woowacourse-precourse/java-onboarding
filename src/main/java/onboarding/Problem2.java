package onboarding;

// 기능 목록
// 1. 문자열을 분석하기 위해 문자열을 배열 -> 리스트 로 변환하는 기능.
// 2. 배열에서 연속된 중복된 문자들을 제거하는 기능.
// 3. 배열을 다시 문자열로 변환한 뒤 결과를 반환한다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String[] str = cryptogram.split("");
        List<String> strList = new ArrayList<>(Arrays.asList(str));


        String answer = "answer";
        return answer;
    }
}
