package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int[] solution(int money) {
        int[] answer=new int[9];
        int[] sort_money = new int[]{50000,10000,5000,1000,500,100,50,10,1};

        for(int s = 0; s< sort_money.length; s++){ //s= sort
            if(s==0) answer[s]=(money/sort_money[s]);
            else answer[s] = (money%sort_money[s-1])/sort_money[s];
        }
        return answer;
    }
}
