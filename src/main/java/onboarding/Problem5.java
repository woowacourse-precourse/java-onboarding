package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    // TODO 금액(지폐, 동전)의 개수를 리스트에 담는 메서드
    public static List<Integer> countMoney(int money) {
        List<Integer> result = new ArrayList<>();
        int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int x : coin) {
            result.add(money / x);
            money = money % x;
        }
        return result;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = countMoney(money);
        return answer;
    }
}
