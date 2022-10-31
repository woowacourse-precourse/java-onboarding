package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem5 기능 목록
 * 1. 화폐의 수를 배열로 만들기
 * 2. answer 리스트를 선언하기
 * 3. answer리스트에 input된 돈을 화폐 단위별로 나눈 몫을 넣어주기
 * 4. 돈의 양을 화폐 단위별로 나눈 나머지로 바꿔주기
 * 5. 반복문이 끝났다면 answer 리스트를 리턴하기
 */
public class Problem5 {
		// 나눠줄 액수 리스트화 하기,
	private static final int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

	public static List<Integer> solution(int money) {
		// 돈을 받고
		List<Integer> answer = new ArrayList<>();
		for (int j : moneyArr) {
			// 몫은 리스트에 입력,
			answer.add(money / j);
			// 돈의 액수는 잔액으로 바꿔주기
			money %= j;
		}
		return answer;
	}
}
