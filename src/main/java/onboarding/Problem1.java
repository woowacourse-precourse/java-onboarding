package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Problem1 {


	public static int solution(List<Integer> pobi, List<Integer> crong) {

		int pobiFirstNumber = getNumber(pobi, 0);
		int pobiSecondNumber = getNumber(pobi, 1);

		int crongFirstNumber = getNumber(crong, 0);
		int crongSecondNumber = getNumber(crong, 1);

		List<Integer> pobiMaxNumbersList = new ArrayList<>();
		List<Integer> crongMaxNumbersList = new ArrayList<>();

		pobiMaxNumbersList.add(getMaxNumber(pobiFirstNumber));
		pobiMaxNumbersList.add(getMaxNumber(pobiSecondNumber));
		crongMaxNumbersList.add(getMaxNumber(crongFirstNumber));
		crongMaxNumbersList.add(getMaxNumber(crongSecondNumber));

		Integer pobiMaxValue = getMaxValue(pobiMaxNumbersList);
		Integer crongMaxValue = getMaxValue(crongMaxNumbersList);

		if (!doesPageContinue(pobiFirstNumber, pobiSecondNumber) || !doesPageContinue(crongFirstNumber, crongSecondNumber)) {
			return -1;
		}

		int answer = getTheAnswer(pobiMaxValue, crongMaxValue);

		return answer;
	}

	private static int getTheAnswer(Integer pobiMaxValue, Integer crongMaxValue) {

		return compareLogic(pobiMaxValue, crongMaxValue);
	}

	private static int compareLogic(Integer pobiMaxValue, Integer crongMaxValue) {

		if (Objects.equals(pobiMaxValue, crongMaxValue)) {
			return 0;
		}

		if (pobiMaxValue > crongMaxValue) {
			return 1;
		}

		return 2;
	}

	private static boolean doesPageContinue(int FirstNumber, int SecondNumber) {
		return FirstNumber + 1 == SecondNumber;
	}

	private static Integer getNumber(List<Integer> pobi, int index) {
		return pobi.get(index);
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
