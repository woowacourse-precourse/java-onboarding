package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyList = {50000,10000,5000,1000,500,100,50,10,1};
        int temp = money;
        int value = 0;
        
        for(int i=0; i<moneyList.length;i++) {
        	value = temp/moneyList[i];
        	if(value>0)
        		answer.add(value);
        	else
        		answer.add(0);
        	temp = temp%moneyList[i];
        }
        
        return answer;
    }
}
