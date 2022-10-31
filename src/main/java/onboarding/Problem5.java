package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    private static final int[] currencyDenominationType = new int[] {
      50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1
    };

    public static List<Integer> solution(int money) {
        checkMoneyCorrect(money);

        return classifyMoney(money);
    }

    /**
     * 금액 검증
     * @param money 금액
     */
    private static void checkMoneyCorrect(int money) {
        if (money < 1 || money > 1_000_000) {
            throw new RuntimeException("입력 가능한 금액을 초과하였습니다. 금액은 1 ~ 1,000,000 사이여야 합니다.");
        }
    }

    /**
     * 화폐 분류
     * @param money 금액
     * @return 화폐 분류 결과
     */
    private static List<Integer> classifyMoney(int money) {
        List<Integer> classifyMoney = new LinkedList<>();

        for (int denominationType : currencyDenominationType) {
            int countMoney = money / denominationType;
            money = money - (countMoney * denominationType);
            classifyMoney.add(countMoney);
        }

        return classifyMoney;
    }
}
