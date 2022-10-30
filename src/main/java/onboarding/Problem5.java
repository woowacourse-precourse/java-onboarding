package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 예외 처리
        if (checkInvalid(money)) {
            return null;
        }

        // 사용할 수 있는 지폐
        List<Integer> bills = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> result = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);

        for (int i = 0; i < bills.size(); i++) {
            int price = bills.get(i);
            int q = (money / price);

            // 큰 금액 화폐 가능한만큼 변환
            result.set(i, q);
            money -= (price*q);
        }
        return result;
    }

    private static boolean checkInvalid(int money) {
        // money 는 1이상 1000000 이하인 자연수
        if (money < 1 || money > 1000000) {
            return true;
        }
        return false;
    }
}
