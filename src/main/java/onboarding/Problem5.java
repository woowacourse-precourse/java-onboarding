package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] exchange = {50000,10000,5000,1000,500,100,50,10,1};
		List<Integer> exchangeList= new ArrayList<Integer>();
		int moneyCount = 0;
		for(int minus : exchange){
			while(money>=minus) {
				money -= minus;
				moneyCount++;
			}
			if(money<=minus) {
				exchangeList.add(moneyCount);
				moneyCount = 0;
			}
		}
		answer=exchangeList;
        return answer;
    }
}
