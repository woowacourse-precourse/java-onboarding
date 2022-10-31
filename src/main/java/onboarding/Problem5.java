package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

	public static List<Integer> solution(int money) {
		// 정답을 출력할 빈 리스트 생성  
		ArrayList<Integer> ans = new ArrayList<>();
		// int[] 배열만들기 
		int[] won = {50000,10000,5000,1000,500,100,50,10,1};
		// 돈이 0월 될때 까지 반복 
		while(money > 0) {
			for (int i = 0; i < won.length; i++) {
				// 몇개가 필요한지 ans에 추가      
				ans.add(money / won[i]);
				// 계산후 나머지 금액 
				money %= won[i];
			}
		}return ans;
	}
}
