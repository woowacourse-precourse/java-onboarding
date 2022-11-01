package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>() {};

        int[] list_money = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int tmp;

        for (int i:list_money){
            tmp = money/i;
            answer.add(tmp);
            money %= i;
        }

        return answer;
    }
}
