package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;
		
		// 모든 수 369확인
		for (int i = 1; i <= number; i++) {
			answer += calculateNumber(i);
		}
		
		return answer;
	}
	
	private static int calculateNumber(int num) {
		int count = 0;
		String strNum = String.valueOf(num);
		
		for (int i = 0; i < strNum.length(); i++) {
			char target = strNum.charAt(i);
			if (target == '3' || target == '6' || target == '9') {
				count++;
			}
		}
		return count;
	}
}
