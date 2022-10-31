package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * @Problem: 돈의 액수 money가 매개변수로 주어질 때, 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드를 완성하라.
 */
public class Problem5 {
    // 1. 1 ~ 50,000까지 9가지 화폐를 설정한다.
    private static final int[] currencies = new int[]{50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    /**
     * @Method: getMoney
     */
    private static List<Integer> getMoney(int money) {
        List<Integer> answer = new ArrayList<>();
        int temp = money;
        for (int currency : currencies) {
            answer.add(temp / currency);
            temp = temp % currency;
        }
        return answer;
    }

    public static List<Integer> solution(int money) {
        return getMoney(money);
    }
}
