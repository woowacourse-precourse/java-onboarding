package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        
		if(money/50000>0) {
			answer.add((int)(money/50000));
			money -= answer.get(0)*50000;
		}
		if(money/10000>0) {
			answer.add((int)(money/10000));
			money -= answer.get(1)*10000;
		}
		if(money/5000>0) {
			answer.add((int)(money/5000));
			money -= answer.get(2)*5000;
		}
		if(money/1000>0) {
			answer.add((int)(money/1000));
			money -= answer.get(3)*1000;
		}
		if(money/500>0) {
			answer.add((int)(money/500));
			money -= answer.get(4)*500;
		}
		if(money/100>0) {
			answer.add((int)(money/100));
			money -= answer.get(5)*100;
		}
		if(money/50>0) {
			answer.add((int)(money/50));
			money -= answer.get(6)*50;
		}
		if(money/10>0) {
			answer.add((int)(money/10));
			money -= answer.get(7)*10;
		}
		answer.add(money);
        
        return answer;
    }
}
