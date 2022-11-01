package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;

		for (int i = 1; i <= number; i++) {
			if (i < 10) {
				if (i % 3 == 0) {
					answer += 1;
				}
			} else {
				String numberToString = Integer.toString(i);
				String[] splitNumber = numberToString.split("");

				for (int k = 0; k < splitNumber.length; k++) {
					if (splitNumber[k].contains("3") || splitNumber[k].contains("6") || splitNumber[k].contains("9")) {
						answer += 1;
					}
				}
			}
		}

		return answer;
	}
}
