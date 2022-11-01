package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int min=0;
		if(money/50000>0) {
			min=(int)(money/50000);
			answer.add(0,min);
			money -= min*50000;
		}
		if(money/10000>0) {
			min=(int)(money/10000);
			answer.add(1,min);
			money -= min*10000;
		}
		if(money/5000>0) {
			min=(int)(money/5000);
			answer.add(2,min);
			money -= min*5000;
		}
		if(money/1000>0) {
			min=(int)(money/1000);
			answer.add(3,min);
			money -= min*1000;
		}
		if(money/500>0) {
			min=(int)(money/500);
			answer.add(4,min);
			money -= min*500;
		}
		if(money/100>0) {
			min=(int)(money/100);
			answer.add(5,min);
			money -= min*100;
		}
		if(money/50>0) {
			min=(int)(money/50);
			answer.add(6,min);
			money -= min*50;
		}
		if(money/10>0) {
			min=(int)(money/10);
			answer.add(7,min);
			money -= min*10;
		}
		answer.add(8,money);
		System.out.println(answer.size());
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
        return answer;
    }
}
