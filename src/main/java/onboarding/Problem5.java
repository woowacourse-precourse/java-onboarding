/*
 * 우테코 1주차 프리코스 미션 - 문제 5
 * [https://github.com/gilyeon00/java-onboarding/blob/main/docs/PROBLEM5.md]
 *
 */
package onboarding;

import java.util.ArrayList;
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
        List<Integer> answer = new ArrayList<>();
        List<Integer> unit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (int i = 0; i < unit.size(); i++) {
            int cnt = 0;    // 각 unit(단위)에 대한 개수를 담는 변수

            /* unit의 길이까지, 혹은 money가 0원이 될 때까지 반복한다. */
            if (money >= unit.indexOf(i) || money != 0) {
                cnt = money / unit.get(i);
                money = money % unit.get(i);
            }
            answer.add(cnt);
        }
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
