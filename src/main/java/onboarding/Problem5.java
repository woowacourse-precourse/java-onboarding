package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    static final int[] monetaryUnits = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    private static void bankWithdrawal(List<Integer> answer, int money) {

        for (int monetaryUnit : monetaryUnits) {
            money = getLeftMoney(answer, money, monetaryUnit);
        }
    }

    /**
     * 돈의 액수 money가 매개변수로 주어질 때
     * 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지
     * 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드를 완성하라.
     *
     * @param money
     * @return
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        bankWithdrawal(answer, money);
        return answer;
    }
}
