package onboarding;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * 기능 목록 1) changes
 * 
 * @version java11 2022년 10월 31일
 * @author 이규호(tlqkrus012345)
 *
 */
public class Problem5 {

	static List<Integer> answer = new ArrayList<>();
	static int[] coinAndPaper = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

	public static List<Integer> solution(int money) {
		changes(money);
		return answer;
	}

	/**
	 * 
	 * 각 지폐와 동전으로 바꾸는 기능이다
	 * 
	 * @param money
	 */
	public static void changes(int money) {
		int restMoney = money;

		for (int i = 0; i < coinAndPaper.length; i++) {
			answer.add(restMoney / coinAndPaper[i]);
			restMoney %= coinAndPaper[i];
		}
	}
}
