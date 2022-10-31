package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;

		for(int i = 1; i <= number; i++) {
			answer += checkClab(i);
		}

		return answer;
	}

	public static int checkClab(int number) {

		int count = 0;

		int units = number % 10;
		int tens = 0;
		int hundreds = 0;
		int thousands = 0;

		if(units == 3 || units == 6 || units == 9) {
			count++;
		}

		if(9 < number && number <= 99) {
			tens = number / 10;

			if(tens == 3 || tens == 6 || tens == 9) {
				count++;
			}
		}

		if(99 < number && number <= 999) {
			hundreds = number / 100;

			if(hundreds == 3 || hundreds == 6 || hundreds == 9) {
				count++;
			}
		}

		if(999 < number && number <= 9999) {
			thousands = number / 1000;

			if(thousands == 3 || thousands == 6 || thousands == 9) {
				count++;
			}
		}

		return count;
	}

}