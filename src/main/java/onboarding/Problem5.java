package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
		List<Integer> answer = new ArrayList<>(Arrays.asList());
		int changes = 50000;
		
		for(int i = 1; i <= 8; i++) {
			answer.add((int)(money/changes));
			money %= changes;
			
			if(i%2 != 0) changes /= 5;
			else if(i%2 == 0) changes /= 2;
		}
		answer.add(money);
		return answer;
    }
}
