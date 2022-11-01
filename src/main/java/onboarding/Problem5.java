package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
       int count = 0, b = 50000;

        for (int i=0;i<9;i++) {
            count = money/b;
            answer.add(count);
            money-=(count*b);
            if (i%2==0) {
                b=b/5;
            } else if (i==7) {
                b=b/10;
            } else {
                b=b/2;
            }
            count=0;
        }

        return answer;
    }
}
