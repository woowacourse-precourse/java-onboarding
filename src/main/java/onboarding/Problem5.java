package onboarding;


import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		List<Integer> answer = new ArrayList<Integer>();
		int[] typeOfChanges = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

		convertToChanges(typeOfChanges, answer, money);

		return answer;
	}

	private static void convertToChanges(int[] typeOfChanges, List<Integer> answer, int money) {
		int credit = money;
		for (int i = 0; i < typeOfChanges.length; i++) {

			int count = credit / typeOfChanges[i];

			if (count != 0) {
				credit -= count * typeOfChanges[i];
				answer.add(count);
				continue;
			}
			answer.add(0);
		}
	}

}
