package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    /*
    기능목록
    1. 돈을 큰 화폐 순으로 리스트에 저장하고 리턴하는 기능
     */
    public static List<Integer> solution(int money) {
        return exchangeMoney(money);
    }

    private static List<Integer> exchangeMoney(int money) {
        int[] kindOfMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < kindOfMoney.length; i++) {
            result.add(money / kindOfMoney[i]);
            money = money % kindOfMoney[i];
        }
        return result;
    }
}
