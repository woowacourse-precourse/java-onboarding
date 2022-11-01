package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        
        answer = countMoney(money);
        
        return answer;
    }
    
    public static List<Integer> countMoney(int money) {
    	List<Integer> list = new ArrayList<>();
    	
    	list.add(money/50000);
    	money %= 50000;
    	list.add(money/10000);
    	money %= 10000;
    	list.add(money/5000);
    	money %= 5000;
    	list.add(money/1000);
    	money %= 1000;
    	list.add(money/500);
    	money %= 500;
    	list.add(money/100);
    	money %= 100;
    	list.add(money/50);
    	money %= 50;
    	list.add(money/10);
    	money %= 10;
    	list.add(money/1);
    	
    	return list;
    }
}
