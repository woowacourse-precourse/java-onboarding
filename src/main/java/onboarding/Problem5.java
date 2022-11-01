package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
	public static void main(String[] args) {
		int money = 50237;
		List<Integer> list = solution(money);
		
		System.out.print("[");
		for(int i = 0; i<8 ; i++) {
			System.out.print(list.get(i));
			System.out.print(", ");
		}
		System.out.print(list.get(8));
		System.out.print("]");
	}
	
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> a = new ArrayList<Integer>();
		a.add(50000);
		a.add(10000);
		a.add(5000);
		a.add(1000);
		a.add(500);
		a.add(100);
		a.add(50);
		a.add(10);
		a.add(1);
        
		for(int i = 0; i<9; i++) {
			answer.add(money/a.get(i));
			
			money = money - (money/a.get(i))*a.get(i);
		}
        return answer;
    }
}
