package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(9);
        for (int index = 0; index < 9; index++) {
            final int won;
            if ((index % 2 == 0) && index != 8) {
                won = (int)(5 * Math.pow(10,4 - index/2));
                answer.add(money / won);
            } else if (index == 8) {
                won = 1;
                answer.add(money/won);
            }
            else {
                won = (int)(1 * Math.pow(10,4- index/2));
                answer.add(money / won);
            }
            money = money % won;
        }
        return answer;
    }
}