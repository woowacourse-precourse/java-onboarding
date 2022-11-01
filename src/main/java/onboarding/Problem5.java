package onboarding;

import java.util.Arrays;

import java.util.List;
/*
기능 구현 사항
1. 각 단위로 나눠지면 몫을 해당하는 인덱스에 저장한다.
2. 몫이 0이면 변환이 불가능하다.
 */

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        Integer[] moneyCount = calculateMoneyCount(money, moneyType);
        List<Integer> answer = Arrays.asList(moneyCount);
        return answer;
    }

    private static Integer[] calculateMoneyCount(int money, int[] moneyType) {
        int leftMoney = money;
        Integer[] moneyCount = new Integer[moneyType.length];
        Arrays.fill(moneyCount, 0);
        int moneyUnit = 0;
        while(leftMoney > 0) {
            int changeMoney = leftMoney / moneyType[moneyUnit];
            if(changeMoney > 0) {
                moneyCount[moneyUnit] = changeMoney;
                leftMoney -= (moneyType[moneyUnit] * changeMoney);
            }
            moneyUnit++;
        }
        return moneyCount;
    }
}
