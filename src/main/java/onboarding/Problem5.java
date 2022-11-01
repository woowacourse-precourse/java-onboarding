package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int unitOfMoney[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        
        answer = changeMoney(money, unitOfMoney);
        
        return answer;
    }
    
    private static List<Integer> changeMoney(int money, int[] unit){
    	List<Integer> moneyList = new ArrayList<>();
    	
    	for(int i = 0; i < unit.length; i++) {
    		moneyList.add(money / unit[i]);
    		money %= unit[i];
    	}
    	
    	return moneyList;
    }
}