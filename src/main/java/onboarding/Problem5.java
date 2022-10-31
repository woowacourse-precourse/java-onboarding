package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        // 종별로 지폐를 모아놓은 배열
        int[] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] moneyCount = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        // 지폐 종별로 반복
        for (int i = 0; i < 9; i ++) {
            // 잔금이 0 이하인 경우 반복문 탈출
            if (money <= 0) break;

            int temp = money;
            int count = 1;

            // 해당 권종의 갯수 카운트하기
            // 만약 권종보다 잔금이 적다면 반복문을 탈출
            // 잔금이 299원이라면 5만원으로는 절대 지불할 수 없음
            while (money >= moneyType[i]) {
                money -= moneyType[i];
                count ++;
            }

            // 잔금을 계산하기
            money = temp - (moneyType[i] * -- count);
            moneyCount[i] = count;

        }

        for (int i : moneyCount)
            answer.add(i);

        return answer;
    }
}
