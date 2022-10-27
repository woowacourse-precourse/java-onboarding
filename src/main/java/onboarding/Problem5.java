package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int moneyChange(int money, int unit) {
        int count = 0;
        if(money >= unit){
            count = money / unit;
        }
        return count;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        answer.add(moneyChange(money,50000));
        return answer;
    }
}
