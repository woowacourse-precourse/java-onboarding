package onboarding;

import java.util.*;

/**
 * [풀이 방법]
 * 1. 초기 money_bill 50000원으로 설정,
 * 2. money_bill /5 그리고 /2 가 번갈아 진행되기 때문에 이를 switch 해줄 boolean flag 설정,
 * 3. 10원 -> 1원은 /10 이고 마지막 경우이기 때문에 따로 조건을 걸어줌
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        boolean flag = false;
        int money_bill = 50000; //
        while (true) {
            answer.add(money / money_bill);
            money -= (money / money_bill) * money_bill;

            // 10원 -> 1원으로 변경될때는 예외사항 & 종료조건
            if (money_bill == 10) {
                money_bill /= 10; // 1
                answer.add(money / money_bill); // 1
                money -= (money / money_bill) * money_bill;
                break;
            }

            // boolean flag 사용하여 money_bill /5 와 /2 를 번갈아가며 실행함
            if (!flag) {
                money_bill /= 5;
                flag = true;
            } else {
                money_bill /= 2;
                flag = false;
            }
        }

        return answer;
    }
}
