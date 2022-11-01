package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem3 {

	public static int solution(int number) {
		try {
			validate(number);
			int answer = 0;
			for (int i = 1; i <= number; i++) {
				answer += count369ByNumber(i);
			}
			return answer;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	static int count369ByNumber(int number) {
		List<String> listOfNumber = convertNumberToArrayList(number);
		int count = countByArrayListOfNumber(listOfNumber);
		return count;
	}

	static int countByArrayListOfNumber(List<String> listOfNumber) {
		int count = 0;
		count += Collections.frequency(listOfNumber, "3");
		count += Collections.frequency(listOfNumber, "6");
		count += Collections.frequency(listOfNumber, "9");
		return count;
	}

	static List<String> convertNumberToArrayList(int number) {
		String stringOfNumber = Integer.toString(number);
		List<String> listOfStringNumber = new ArrayList<>(
			Arrays.asList(stringOfNumber.split("")));
		return listOfStringNumber;
	}

	static void validate(int number) throws Exception {
		if (number < 1 || number > 10000) {
			throw new Exception("1 이상 10000 이하의 자연수만 계산할 수 있습니다");
		}
	}
}
