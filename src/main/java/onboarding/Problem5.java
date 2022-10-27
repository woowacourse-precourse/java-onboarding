package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    // 화폐 분류를 위한 화폐 리스트 생성
    private static final int[] currencyDenominationType = new int[] {
      50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1
    };

    public static List<Integer> solution(int money) {
        if (!validateMoney(money)) {
            return new LinkedList<>();
        }

        return classifyMoney(money);
    }

    /**
     * 숫자 검증
     * @param money 돈
     * @return 검증 결과 값
     */
    private static boolean validateMoney(int money) {
        return (money > 0 && money <= 1_000_000);
    }

    /**
     * 화폐 분류
     * @param money 돈
     * @return 화폐 분류 결과
     */
    private static LinkedList<Integer> classifyMoney(int money) {
        LinkedList<Integer> classifyMoney = new LinkedList<>();

        for (int denominationType : currencyDenominationType) {
            int countMoney = money / denominationType;
            money = money - (countMoney * denominationType);
            classifyMoney.add(countMoney);
        }

        return classifyMoney;
    }


}
