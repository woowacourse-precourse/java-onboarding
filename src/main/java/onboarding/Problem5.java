package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
       
        int[] units = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        
        Integer[] arr = new Integer[units.length];
        
        for(int i = 0, len = units.length; i < len; i++) {
        	arr[i] = divWithUnit(money,units[i]);
        	money = money%units[i];
        }
        
        answer = List.of(arr);
        
        return answer;
    }
    
    // 몫을 반환
    public static int divWithUnit(int money, int unit) {
    	return money/unit;
    }
}
