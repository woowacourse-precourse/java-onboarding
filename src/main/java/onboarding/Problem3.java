package onboarding;

public class Problem3 {

	public static int solution(int number) {
		int answer = 0;
		for (int i = 1; i <= number; i++) {
			String numberToString = String.valueOf(i);
			for (int j = 0; j < numberToString.length(); j++) {
				if (checked(numberToString, j)) {
					answer++;
				}
			}
		}
		return answer;
	}

	private static boolean checked(String numberToString, int j) {
		return numberToString.charAt(j) == '3' || numberToString.charAt(j) == '6' || numberToString.charAt(j) == '9';
	}
}
