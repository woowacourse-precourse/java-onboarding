package onboarding;

public class Problem3 {
	public static int solution(int number) {
		// 손뼉 칠 때마다 올라가는 변수 answer
		int answer = 0;

		for (int i = 1; i <= number; i++) {
			// 현재 숫자가 3 6 9를 포함 시 answer++
			int cur = i;
			while (cur > 0) {
				if (cur % 10 == 3 || cur % 10 == 6 || cur % 10 == 9) {
					answer++;
				}
				cur /= 10;
			}
		}

		return answer;
	}
}
