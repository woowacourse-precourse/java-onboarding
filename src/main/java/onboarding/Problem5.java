package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if(money>0 && money<=1000000) {
        	List<0>=money/50000;
        	
        } else {	money=money%50000;
        	List<1>=money/10000;
        	money=money%10000;
        	List<2>=money/5000;
        	money=money%5000;
        	List<3>=money/1000;
        	money=money%1000;
        	List<4>=money/500;
        	money=money%500;
        	List<5>=money/100;
        	money=money%100;
        	List<6>=money/50;
        	money=money%50;
        	List<7>=money/10;
        	money=money%10;
        	List<8>=money;
        }
        return answer;
    }
}
