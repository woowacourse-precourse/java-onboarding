package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
    	int x=0;
    	int y=0;
    	int z=100000;
    	List<Integer> arrIntegers=new ArrayList<>();
    	for(int i=0;i<8;i++) {
    		if(i%2==0) {
    			z=z/2;
    			x=money/z;
    			arrIntegers.add(i,x);
    			money=money%z;
    		}else if(i%2==1) {
    			z=z/5;
    			x=money/z;
    			arrIntegers.add(i,x);
    			money=money%z;
    		}	
    	}
		x=money;
		arrIntegers.add(8,x);
        List<Integer> answer = arrIntegers;
        return answer;
    }
}
