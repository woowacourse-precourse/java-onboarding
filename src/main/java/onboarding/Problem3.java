package onboarding;

public class Problem3 {

	// 1부터 입력받은 숫자까지 "3" "6" "9"가 포함되어 있는 개수를 반환하는 메소드
	public static int solution(int number) {
		int answer = 0;

		for (int i = 1; i <= number; i++) {
			String num = String.valueOf(i);
			answer += count_3_6_9(num);
		}

		return answer;
	}

	// 입력받은 문자열에 "3" "6" "9" 가 포함되어 있는 개수를 반환하는 메소드
	private static int count_3_6_9(String num) {
		int count = 0;
		for (int i = 0; i < num.length(); i++) {
			if (Contains_3_6_9(num.charAt(i))) {
				count++;
			}
		}
		
		return count;
	}

	// 입력받은 문자에 '3' '6' '9'가 포함되어 있는지 확인하는 메소드
	private static boolean Contains_3_6_9(char c) {
		return (c == '3' || c == '6' || c == '9');
	}

}
