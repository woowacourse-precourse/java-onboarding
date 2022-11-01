package onboarding;

import java.util.*;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));

        // 잔액이 0이 될 때까지 계속 화폐 개수와 잔액 업데이트하기
        while (money != 0) {
            List<Integer> updateInfo = createUpdateInfo(money);
            int index = updateInfo.get(0);
            int price = updateInfo.get(1);
            int count = updateInfo.get(2);
            answer.set(index, answer.get(index) + count);   // 화폐 개수 업데이트
            money -= price * count;     // 잔액 업데이트
        }
        return answer;
    }

    private static List<Integer> createUpdateInfo(int money) {
        List<Integer> prices = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        for (int price : prices) {
            if (money >= price) {
                int index = prices.indexOf(price);
                int count = money / price;
                return List.of(index, price, count);
            }
        }
        return List.of();
    }
}
