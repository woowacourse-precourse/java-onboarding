package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int[] type={50000,10000,5000,1000,500,100,50,10,1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int q,r;
        for(int i=0; i<9; i++){
            q=money/type[i];
            money=money%type[i];
            answer.add(q);
        }
        return answer;
    }
}
