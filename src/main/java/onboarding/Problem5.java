package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> withdrawMoney(int money) {
        List<Integer> moneyList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for(int i = 0; i < moneyList.size(); i++) {
            int divisor = moneyList.get(i);                // 나눠지는 수
            moneyList.set(i, money / moneyList.get(i));    // 리스트 값을 화폐 개수로 변경
            money = money % divisor;                       // 다음 계산을 위해 money 값 초기화
        }

        return moneyList;
    }
    public static List<Integer> solution(int money) {
        return withdrawMoney(money);
    }
}
