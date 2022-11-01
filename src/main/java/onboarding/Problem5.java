package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //화폐 단위를 매개변수로 갖는 메서드
        List<Integer> answer = new ArrayList<>();
    	if(money/50000>0) {
    		answer.add(0, money/50000);
    		money-=50000*(money/50000);
    	} else answer.add(0, 0);
    	if(money/10000>0) {
    		answer.add(1, money/10000);
    		money-=10000*(money/10000);
    	} else answer.add(1, 0);
    	if(money/5000>0) {
    		answer.add(2, money/5000);
    		money-=5000*(money/5000);
    	} else answer.add(2, 0);
    	if(money/1000>0) {
    		answer.add(3, money/1000);
    		money-=1000*(money/1000);
    	} else answer.add(3, 0);
    	if(money/500>0) {
    		answer.add(4, money/500);
    		money-=500*(money/500);
    	} else answer.add(4, 0);
    	if(money/100>0) {
    		answer.add(5, money/100);
    		money-=100*(money/100);
    	} else answer.add(5, 0);
    	if(money/50>0) {
    		answer.add(6, money/50);
    		money-=50*(money/50);
    	} else answer.add(6, 0);
    	if(money/10>0) {
    		answer.add(7, money/10);
    		money-=10*(money/10);
    	} else answer.add(7, 0);
    	if(money/1>0) {
    		answer.add(8, money/1);
    		money-=1*(money/1);
    	} else answer.add(8, 0);
    	return answer;
    }
    /*
    public static void countBilltoCoin(List<Integer> answer, int money, int won, int index) {
    	if(money/won>0) {
    		answer.add(index, money/won);
    		money-=10*(money/won);
    	} else answer.add(index, 0);
    }
    */
}

