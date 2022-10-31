package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        int moneyArrIdx = 0;
        while (answer.size() != moneyArr.length) {
            int count = money / moneyArr[moneyArrIdx];
            money = money % moneyArr[moneyArrIdx];

            moneyArrIdx++;
            answer.add(count);
        }
        
        return answer;
    }
}
