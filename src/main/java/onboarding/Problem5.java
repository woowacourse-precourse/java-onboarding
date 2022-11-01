package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        Integer[] scale = {50000,10000,5000,1000,500,100,50,10,1};
        int n=0;
        for (int i=0;i<scale.length;i++){
            n = money/scale[i];
            answer.add(n);
            money -= n*scale[i];
        }
        return answer;
    }
}
