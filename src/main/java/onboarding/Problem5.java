package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int [] won = {50000,10000,5000,1000,500,100,50,10,1};
        int count=0;
        for (int i = 0; i < 9; i++) {
            count= money/won[i];
            answer.add(count);
            money -= (count*won[i]);
        }

        return answer;
    }
}
