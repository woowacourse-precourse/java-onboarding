package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Problem1 {


	public static int solution(List<Integer> pobi, List<Integer> crong) {

		int answer = 2;

		int pobiFirstNumber = pobi.get(0);
		int pobiSecondNumber = pobi.get(1);

		int crongFirstNumber = crong.get(0);
		int crongSecondNumber = crong.get(1);

		List<Integer> pobiMaxNumbersList = new ArrayList<>();
		List<Integer> crongMaxNumbersList = new ArrayList<>();

		pobiMaxNumbersList.add(getMaxNumber(pobiFirstNumber));
		pobiMaxNumbersList.add(getMaxNumber(pobiSecondNumber));
		crongMaxNumbersList.add(getMaxNumber(crongFirstNumber));
		crongMaxNumbersList.add(getMaxNumber(crongSecondNumber));

		Integer pobiMaxValue = getMaxValue(pobiMaxNumbersList);
		Integer crongMaxValue = getMaxValue(crongMaxNumbersList);

		if (pobiFirstNumber + 1 != pobiSecondNumber || crongFirstNumber + 1 != crongSecondNumber) {
			return -1;
		}

		if (Objects.equals(pobiMaxValue, crongMaxValue)) {
			return 0;
		}

		if (pobiMaxValue > crongMaxValue) {
			return 1;
		}

		return answer;
	}

	private static Integer getMaxValue(List<Integer> MaxNumbersList) {
		return Collections.max(MaxNumbersList);
	}

	private static int getNumberLength(int number) {
		return (int) (Math.log10(number) + 1);
	}

	private static int getMaxNumber(int number) {

		if (getNumberLength(number) == 3) {
			int firstNumberFirstDigit = number / 100;
			int firstNumberSecondDigit = (number % 100) / 10;
			int firstNumberThirdDigit = (number % 100) % 10;

			int addition = getAddition(firstNumberFirstDigit, firstNumberSecondDigit, firstNumberThirdDigit);
			int multiplication = getMultiplication(firstNumberFirstDigit, firstNumberSecondDigit, firstNumberThirdDigit);

			return Math.max(addition, multiplication);
		}

		if (getNumberLength(number) == 2) {
			int firstNumberFirstDigit = (number % 100) / 10;
			int firstNumberSecondDigit = (number % 100) % 10;

			int addition = getAddition(firstNumberFirstDigit, firstNumberSecondDigit);
			int multiplication = getMultiplication(firstNumberFirstDigit, firstNumberSecondDigit);

			return Math.max(addition, multiplication);
		}

		return number;
	}

	public static int getAddition(int... numbers) {
		int sum = 0;

		for (int number : numbers) {
			sum += number;
		}

		return sum;
	}

	public static int getMultiplication(int... numbers) {
		int multiply = 1;

		for (int number : numbers) {
			multiply = multiply * number;
		}

		return multiply;
	}
}
