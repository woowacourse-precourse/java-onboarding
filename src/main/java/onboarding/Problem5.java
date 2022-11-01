package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
    	int cash = money;
		int exmoney = 0;
		
		List<Integer> exchange = new ArrayList<>(9);
		
		for(int i =0; i < 9; i++) {
			exchange.add(0);
		}
		
		if(cash / 50000 >= 1) {
			exmoney = cash/ 50000;
			exchange.set(0, exmoney);
			cash = cash - (exmoney * 50000);
		}
		if(cash / 10000 >= 1) {
			exmoney = cash/ 10000;
			exchange.set(1, exmoney);
			cash = cash - (exmoney * 10000);
		}
		if(cash / 5000 >= 1) {
			exmoney = cash/ 5000;
			exchange.set(2, exmoney);
			cash = cash - (exmoney * 5000);
		}
		if(cash / 1000 >= 1) {
			exmoney = cash/ 1000;
			exchange.set(3, exmoney);
			cash = cash - (exmoney * 1000);
		}
		if(cash / 500 >= 1) {
			exmoney = cash/ 500;
			exchange.set(4, exmoney);
			cash = cash - (exmoney * 500);
		}
		if(cash / 100 >= 1) {
			exmoney = cash/ 100;
			exchange.set(5, exmoney);
			cash = cash - (exmoney * 100);
		}
		if(cash / 50 >= 1) {
			exmoney = cash/ 50;
			exchange.set(6, exmoney);
			cash = cash - (exmoney * 50);
		}
		if(cash / 10 >= 1) {
			exmoney = cash/ 10;
			exchange.set(7, exmoney);
			cash = cash - (exmoney * 10);
		}
		if(cash % 10 >= 1) {
			exchange.set(8, cash);
			cash = cash - (cash * 1);
		}
	
		
		return exchange;
	
    }
}
