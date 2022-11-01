package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        
        answer = withdrawal(money);
        
        return answer;
    }
    
    /**
     * 각 지폐의 갯수를 찾는다.
     * @param 대상 금액
     * @return 각 지폐별 갯수(50000,10000,5000,1000,500,100,50,10,1원 순서대로 갯수가 들어있는 배열)
     */
	private static List<Integer> withdrawal(int money) {
		
		int tagerMoney = money; 
		
		List<Integer> cashWithdrawn =  new ArrayList<Integer>();
		int[] monetaryUnit = {50000,10000,5000,1000,500,100,50,10,1};
		
		for(int unit : monetaryUnit) {
			int numberPaperMoney = tagerMoney/unit;
			cashWithdrawn.add(numberPaperMoney);
			tagerMoney = tagerMoney%unit;
		}
		
		return cashWithdrawn;
	}

}

