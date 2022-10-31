package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] value={50000,10000,5000,1000,500,100,50,10,1};
        for(int i=0;i<value.length;i++)
        {
            answer.add(0);
        }
        for(int i=0;i<value.length;i++)
        {
            answer.set(i,money/value[i]);
            money=money%value[i];
        }
        return answer;
    }
}
