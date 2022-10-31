package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Integer[] digits = new Integer[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i = 0; i<digits.length; i++) {
        	int digit = digits[i];
        	digits[i] = exchangeMoney(money, digit);
        	money -= digit*digits[i];
        }
        
        return Arrays.asList(digits);
    }
    public static int exchangeMoney(int money, int digit) {
    	if(money/digit != 0) {
    		return money/digit;
    	}else {
    		return 0;
    	}
    }
    
}
