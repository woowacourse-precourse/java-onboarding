package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
	
    public static List<Integer> solution(int money) {
    	List<Integer> answer = Collections.emptyList();
    	answer = new ArrayList<Integer>();
    	
    	int a = 50000;	int b = 10000;
    	int c = 5000; 	int d = 1000;	
    	int e = 500; 	int f = 100; 
    	int g = 50; 	int h = 10; 	
    	int i = 1;
    	
    	answer.add(money/a);
    	answer.add((money - a*answer.get(0)) / b);
    	answer.add((money - a*answer.get(0) - b*answer.get(1)) / c);
    	answer.add((money - a*answer.get(0) - b*answer.get(1) - c*answer.get(2)) / d);
    	answer.add((money - a*answer.get(0) - b*answer.get(1) - c*answer.get(2) - d*answer.get(3)) / e);
    	answer.add((money - a*answer.get(0) - b*answer.get(1) - c*answer.get(2) - d*answer.get(3) - e*answer.get(4)) / f);
    	answer.add((money - a*answer.get(0) - b*answer.get(1) - c*answer.get(2) - d*answer.get(3) - e*answer.get(4) - f*answer.get(5)) / g);
    	answer.add((money - a*answer.get(0) - b*answer.get(1) - c*answer.get(2) - d*answer.get(3) - e*answer.get(4) - f*answer.get(5) - g*answer.get(6)) / h);
    	answer.add((money - a*answer.get(0) - b*answer.get(1) - c*answer.get(2) - d*answer.get(3) - e*answer.get(4) - f*answer.get(5) - g*answer.get(6) - h*answer.get(7)) / i);
    	
    	return answer;
    }
}
