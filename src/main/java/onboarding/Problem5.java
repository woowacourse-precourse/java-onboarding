package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int[] moneyTypes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        withdraw(money, answer);

        return answer;
    }

    public static void withdraw(int money, List<Integer> answer){
        for(int moneyType : moneyTypes){
            answer.add(money/moneyType);
            money %= moneyType;
        }
    }
}
