package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = withdrawMoney(money);

        return answer;
    }

    private static List<Integer> withdrawMoney(int money){
        List<Integer> answer = new ArrayList<>();
        int[] sortMoney = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i=0; i<sortMoney.length; i++){
            answer.add(money / sortMoney[i]);
            money %= sortMoney[i];
        }
        return answer;
    }
}
