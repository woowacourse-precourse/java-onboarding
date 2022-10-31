package onboarding;

import java.util.*;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));

        // 모두 가장 큰 화폐로 바꿀 때까지 계속 업데이트하기
        while (money != 0) {
            List<Integer> updateInfo = createUpdateInfo(money);
            int index = updateInfo.get(0);
            int price = updateInfo.get(1);
            int count = updateInfo.get(2);
            answer.set(index, answer.get(index) + count);
            money -= price * count;
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
