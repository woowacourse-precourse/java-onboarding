package onboarding;

import net.bytebuddy.TypeCache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static List<Integer> sortMoney(int money)
    {
        List<Integer> answer = new ArrayList<Integer>();
        int[] won = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i =0 ;i<won.length;i++)
        {
            answer.add(money/won[i]);
            money%=won[i];
        }
        return answer;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer= sortMoney(money);
        return answer;
    }
}
