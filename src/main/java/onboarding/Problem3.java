package onboarding;

public class Problem3 {

	public static int solution(int number) {
		getAnswer(number);
		return getAnswer(number);
	}

	private static int getAnswer(int number) {
		int answer = 0;
		for (int i = 1; i <= number; i++) {
			answer += countClap(i);
		}
		return answer;
	}

	private static int countClap(int number) {
		String string = String.valueOf(number);
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '3' || string.charAt(i) == '6' || string.charAt(i) == '9') {
				count++;
			}
		}
		return count;
	}
}
