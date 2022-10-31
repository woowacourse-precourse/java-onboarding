package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int won = 50000;
        int count = 0;
        int flag = 0;

        while (won >= 1) {
            count = 0;

            while (money >= won) {
                money -= won;
                count += 1;
            }
            answer.add(count);

            if(flag == 7) {
                won = won / 10;
            }
            else if(flag % 2 == 0) {
                won = won / 5;
            }
            else {
                won = won / 2;
            }
            flag += 1;
        }

        return answer;
    }
}
