package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        int[] m={50000,10000,5000,1000,500,100,50,10,1};
        int n=0;
        for(int i=0;i<9;i++){
            n=money/m[i];
            answer.add(n);
            money=money%m[i];
        }

        return answer;
    }
}
