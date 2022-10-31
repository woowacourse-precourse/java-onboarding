package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static Integer[] unit = {
            50000, 10000, 5000, 1000, 500, 100, 50, 10, 1
    };

    public static List<Integer> solution(int money) {
        if (isException(money)) throw new RuntimeException("잘못된 인자입니다.");
        List<Integer> answer = new ArrayList<>();
        for (Integer u : unit) {
            money = getCoinNumber(money, answer, u);
        }
        return answer;
    }

    private static Boolean isException(int number) {
        return number < 1 || number > 1000000;
    }

    private static Integer getCoinNumber(Integer money, List<Integer> wallet, Integer unit) {
        Integer count = money / unit;
        wallet.add(count);
        return money % unit;
    }
}
