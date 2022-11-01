package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final int[] MONEY = {50000, 10000, 5000, 1000,
            500, 100, 50, 10, 1};

    public static void convertMoney(List<Integer> answer, int money) {
        for(int value:MONEY){
            answer.add(money/value);
            money %= value;
        }
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        convertMoney(answer, money);
        return answer;
    }
}
