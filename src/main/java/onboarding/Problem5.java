/*
 * 우테코 1주차 프리코스 미션 - 문제 5
 * [https://github.com/gilyeon00/java-onboarding/blob/main/docs/PROBLEM5.md]
 *
 */
package onboarding;

import java.util.Collections;
import java.util.List;

/**
 * checkNum : 전달받은 숫자가 제한사항과 맞는지 체크하는 메서드
 **/

public class Problem5 {
    public static List<Integer> solution(int money) {
        /* 제한 사항 처리 */
        if(checkNum(money) == 0) {
            return null;
        }
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
    
    private static int checkNum(int money) {
        /* money가 1이상 1,000,000이하인지 확인 */
        if (money < 1 || money > 1000000){
            return 0;
        }
        return money;
    }
}
