package onboarding;

public class Problem3 {
	public static int solution(int number) {

		int count = 0;
		for (int i = 1; i <= number; i++) {
			String numberStr = String.valueOf(i);
			count = (int) (count + countChar(numberStr, '3') + countChar(numberStr, '6') + countChar(numberStr, '9'));
		}
		int answer = count;
		return answer;
	}

	public static long countChar(String numberStr, char threeSixNine) {
		return numberStr.chars()
				.filter(character -> character == threeSixNine)
				.count();
	}
}
