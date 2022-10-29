package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final List<Integer> moneyList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static boolean validCheck(int money) {
        return money >= 1 && money <= 1000000;
    }

    public static List<Integer> getSortedMoney(int money) {
        List<Integer> result = new ArrayList<>();
        for (Integer list : moneyList) {
            result.add(money / list);
            money %= list;
        }
        return result;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if(!validCheck(money)){
            throw new IllegalStateException("잘못된 입력입니다.");
        }
        answer = getSortedMoney(money);
        return answer;
    }
}
