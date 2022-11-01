package onboarding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String pattern = "^[0-9]+$";
		
		int money = 0;
		
		if(Pattern.matches(pattern, money+"")) {
			if(money>=1 && money<=1000000) {
				solution(money);
			}
		}

	}
	 public static List<Integer> solution(int money) {
	    	int[] bill= new int[] {50000,10000,5000,1000,500,100,50,10,1};
	        List<Integer> answer = Collections.emptyList();
	        Integer[] result = new Integer[9];
	        for(int i=0;i<9;i++) {
				result[i]=money/bill[i];
				money %= bill[i];
			}
	        answer = Arrays.asList(result);
	        
	        return answer;
	 }
}
