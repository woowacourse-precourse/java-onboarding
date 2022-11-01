package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        
		int [] moneyUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		
		for(int i=0; i < moneyUnit.length; i++) {
			int moneyCount = 0;
			moneyCount = money/moneyUnit[i];
			answer.add(moneyCount);
			money = money - moneyCount*moneyUnit[i];
		}
		
        return answer;
    }
}
