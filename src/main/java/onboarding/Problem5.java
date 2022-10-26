package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = CashCount(money);
        return answer;
    }
    public static List<Integer> CashCount(Integer money){
        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < moneyList.length; i++) {
            Integer temp = money / moneyList[i];
            answer.add(temp);
            money = money % moneyList[i];
        }
        return answer;
    }
}
