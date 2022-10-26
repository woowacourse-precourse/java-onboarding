package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        
        for(int i=1;i<=number;i++) {
        	answer += count369(i);
        }
        
        return answer;
    }
    
    private static List<Integer> getElements(int number){
    	List<Integer> elements = new ArrayList<>();
    	while(number!=0) {
    		elements.add(number%10);
    		number = number/10;
    	}
    	
    	return elements;
    }
    
    private static int count369(int number) {
    	int count = 0;
    	List<Integer> elements = getElements(number);
    	for(int element : elements) {
    		if((element==3)||(element==6)||(element==9)) {
    			count++;
    		}
    	}
    	return count;
    }
}
