package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = Arrays.asList(0,0,0,0,0,0,0,0,0);
        int i=1;
        do{
            int change = money % 10;
            if(i==9) change = money;
            if(i==1) answer.set(9-i,change);
            else if(change >=5){
                answer.set(9-i,change/5);
                answer.set(9-i+1,change-(5*(change/5)));
            }else answer.set(9-i+1,change);
            i +=2;
        }while((money=money/10) > 0 && i<=9);

        return answer;
    }
}
