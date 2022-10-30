package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final Integer[] baseCurrencyArr = new Integer[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    /**
     * 주어진 금액의 화폐 구성을 반환하는 함수
     *
     * @param money 금액
     * @return 주어진 금액의 화폐 구성 List
     */
    private static List<Integer> getCureencyCombination(int money) {
        List<Integer> answer = new ArrayList<>();

        int rest = money;
        for (Integer baseCurrency : baseCurrencyArr) {
            answer.add(rest / baseCurrency);
            rest = rest % baseCurrency;
        }

        return answer;

    }

    public static List<Integer> solution(int money) {
        return getCureencyCombination(money);
    }
}
