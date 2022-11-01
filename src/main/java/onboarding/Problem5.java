package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] unitOfMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int unit : unitOfMoney){
            int value = 0;
            if (money >= unit){
                value = money / unit;
                money = money % unit;
            }
            answer.add(value);
        }
        return answer;
    }
}
