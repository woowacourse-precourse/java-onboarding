package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int num=0;
        int[] cost={50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<Integer>();
        for(int i=0;i<9;i++){
            num=money/cost[i];
            money=money-(num*cost[i]);
            answer.add(num);
        }
        return answer;
    }
}
