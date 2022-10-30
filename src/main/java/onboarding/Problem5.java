package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] money_size = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<Integer>();
        int i = 0;

        while (money > 0){
            int cnt = (int) (money / money_size[i]);
            answer.add(cnt);
            money -= money_size[i++] * cnt;
        }

        int tmp_size = answer.size();
        for (i=0; i<9 - tmp_size; i++){
            answer.add(0);
        }

        return answer;
    }
}
