package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
               
        answer = new ArrayList<>();
    	
		
		int[] moneyArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		
	
		
		for (int i=0; i<moneyArray.length; i++) {
			int count = 0;
			
			while (money >= moneyArray[i]) {
				money -= moneyArray[i];
				count += 1;
			}
			
			answer.add(count);
		}
		
		
		return answer;
    }
}