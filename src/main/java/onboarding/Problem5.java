package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        
        int[] wallet = new int[9];
        int nowUnit = 50000;
        int firstNum = 5;
        
        for(int i=0; i<wallet.length; i++) {
        	wallet[i] = money/nowUnit;
        	money = money%nowUnit;
        	
        	if(firstNum==5) {
        		nowUnit = nowUnit/5;
        		firstNum = 1;
        	}else if(firstNum==1 && nowUnit==10) {
        		nowUnit = nowUnit/10;
        	}else {
            	nowUnit = nowUnit/2;
            	firstNum = 5;
        	}
        }
        
        answer = new ArrayList<Integer>();
        for(int transfer : wallet) {
        	answer.add(transfer);
        }
        
        return answer;
    }
}
