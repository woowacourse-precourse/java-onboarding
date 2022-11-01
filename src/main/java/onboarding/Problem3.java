package onboarding;

import java.util.Arrays;

public class Problem3 {
	
	public static int solution(int number) {
		
		int answer = 0;
		int[] clapNumbers = { 3, 6, 9 };
		
		// ㅜ 같다를 통해 0까지는 검사하겠다는 의미
		for (int i = number; i > 0; i--) {

			int j = i;
			while (j >= 1) {
				
				int remainder = j % 10;
				boolean isClap = Arrays.stream(clapNumbers).anyMatch(num -> num == remainder);
				
				// ㅜ contains() 문자열에 사용 가능한 함수
				// boolean isClap = Arrays.asList(clapNumbers).contains(remainder);
				
				if (isClap) {
					answer++;
				}
				
				j = (int) j / 10;
			}
		}
		
		return answer;
	}
}
