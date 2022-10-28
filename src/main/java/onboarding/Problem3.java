package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;
		return answer;
	}

	static class Counter {

		public int count369(int number) {
			List<Integer> numberList = new ArrayList<>();
			int result = 0;

			while (number > 0) {
				numberList.add(number % 10);
				number = number / 10;
			}

			for (int n : numberList) {
				if (n > 0 && n % 3 == 0) {
					result += 1;
				}
			}
			return result;
		}
	}
}
