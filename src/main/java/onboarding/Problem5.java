package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i=0;i<units.length;i++){
            int u = units[i];
            answer.add(money/u);
            money = money%u;
        }

        return answer;
    }
}
