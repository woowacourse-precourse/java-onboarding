package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 요구사항
 * 돈의 액수 money가 매개변수로 주어질 때, 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드를 완성하라.
 * money는 1 이상 1,000,000 이하인 자연수이다.
 */

/**
 * 설계
 * 1. money를 매개변수로 받는다.
 * 2. money를 각 단위로 나눠 몫을 list에 해당하는 index에 넣는다.
 * 3. 단위 기준으로 반복
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = bank(money);

        return answer;
    }

    public static List<Integer> bank(int money) {
        List<Integer> returnMoney = new ArrayList<>();

        int[] moneyUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i=0; i<moneyUnit.length; i++) {
            returnMoney.add(i ,money/moneyUnit[i]);
            money%=moneyUnit[i];
        }
        return returnMoney;
    }
}
