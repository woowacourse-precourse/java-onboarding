package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
       
		int[] m = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		for(int i = 0; i < m.length; i++) {
			answer.add(money/m[i]);
			money %= m[i];
		}
        return answer;
    }
}
