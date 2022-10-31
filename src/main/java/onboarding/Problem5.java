package onboarding;

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
        }
        
        return answer;
    }
}
