package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
    	
        List<Integer> answer = Collections.emptyList();
        
        List<Integer> list = new ArrayList<>();
        
        int[] pay = {50000,10000,5000,1000,500,100,50,10,1};
    	for(int i=0; i<pay.length; i++) {
    		int num1 = money/pay[i];
    		list.add(i,num1);
    		money = money%pay[i];
    	}
        return answer = list;
    }
    
    public static void main(String[] args){
    	//System.out.println(solution(4790));
    	
    	
    }
}
