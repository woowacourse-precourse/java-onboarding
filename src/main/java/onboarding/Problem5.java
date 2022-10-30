package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    // 1. 예외처리 : money가 1~1,000,000 사이인지 체크
    public static boolean isException(Integer money){
        if(money >= 1 && money <= 1000000){
            return true;
        }
        return false;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        // 2. 큰 금액부터 순서대로 값을 구하는 함수 만들기.
        return answer;
    }
}
