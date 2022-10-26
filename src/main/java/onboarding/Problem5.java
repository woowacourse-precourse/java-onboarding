package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
    	int[] num = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		
		List<Integer> answer = new ArrayList<>();
		for(int i = 0; i < num.length; i++) {
			answer.add(money / num[i]);
			
			money %= num[i];
		}
        return answer;
    }
}
