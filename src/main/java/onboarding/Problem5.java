package onboarding;

import java.util.Collections;
import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int m=money;
        int a[]={50000,10000,5000,1000,500,100,50,10};
        for(int i=0;i<8;i++){
            answer.add(i,m/a[i]);
            m=m%a[i];
        }
        answer.add(8,m);
        return answer;
    }
}
