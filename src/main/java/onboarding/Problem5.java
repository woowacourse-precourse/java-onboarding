package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem5 {
    /*
        기능 요구 사항 목록
        1. 변환할 돈의 개수와 나머지를 반환하는 함수
        2. solution (변환할 돈을 차례대로 입력)
    */

    // 변환할 돈의 개수와 나머지 반환 함수
    private static HashMap<String, Integer> countMoney(int money, int convert) {
        HashMap<String, Integer> result = new HashMap<>();
        int count = money / convert;
        int left = money % convert;

        result.put("count", count);
        result.put("left", left);
        return result;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
