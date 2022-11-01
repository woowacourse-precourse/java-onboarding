package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int num = money;
        int m = 50000;
        int tmp = 0;
        int i=0;

        while(m >= 10){
            tmp = num/m;
            answer.add(tmp);
            num = num - (m*tmp);
            if(i % 2 == 0)
                m = m/5;
            else
                m = m/2;
            ++i;
        }
        answer.add(num);

        return answer;
    }
}
