package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
    	int[] money_list = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>(9);
        
        int idx = 0;
        
        while(money!=0) {
        	int count = money/money_list[idx];
        	answer.add(count);
        	
        	money = money%money_list[idx];
        	idx++;
        }
        
        for(int i=idx;i<9;i++) {
        	answer.add(0);
        }
        
        return answer;
    }
}
