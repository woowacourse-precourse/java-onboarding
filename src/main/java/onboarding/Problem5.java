package onboarding;

import onboarding.PROBLEM5.MoneyRangeException;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) throws MoneyRangeException {
        List<Integer> answer = new ArrayList<>();
        // 지갑에 넣을 수 있는 지폐와 동전
        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        // money의 범위가 벗어난 경우
        if (money<1 || money>1000000) {
            throw new MoneyRangeException("[Error] money의 범위 초과");
        }

        // 가격이 비싼 지폐를 시작으로 가격이 싼 동전까지 계산
        while (money != 0){
            for(int i=0; i<moneyList.length; i++) {
                if (money / moneyList[i] > 0) {
                    answer.add(i, money / moneyList[i]);
                    money %= moneyList[i];
                } else answer.add(i, 0);
            }
        }

        return answer;
    }
}
