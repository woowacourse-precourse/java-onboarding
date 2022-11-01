package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int m1 =money;
        int[] m2 = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> a = new ArrayList<>();

        for(int i=0 ; i<m2.length ; i++){
            if (m1 == 0){
                a.add(0);
                continue;
            }
            a.add(m1/m2[i]);
            m1 = m1 % m2[i];
        }

        List<Integer> answer = Collections.emptyList();
        answer = a;
        return answer;
    }
}
