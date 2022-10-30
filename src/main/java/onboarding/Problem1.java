package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {


	public static int solution(List<Integer> pobi, List<Integer> crong) {

		int answer = 0;
		int pobiMaxValue;
		int crongMaxValue;

		int pobiFirstNumber = pobi.get(0);
		int pobiSecondNumber = pobi.get(1);

		int crongFirstNumber = crong.get(0);
		int crongSecondNumber = crong.get(1);

		if (pobiFirstNumber + 1 != pobiSecondNumber || crongFirstNumber + 1 != crongSecondNumber) {
			answer = -1;
		} else {

			List pobiMaxNumbersList = new ArrayList();
			List crongMaxNumbersList = new ArrayList();

			pobiMaxNumbersList.add(getMaxNumber(pobiFirstNumber));
			pobiMaxNumbersList.add(getMaxNumber(pobiSecondNumber));
			crongMaxNumbersList.add(getMaxNumber(crongFirstNumber));
			crongMaxNumbersList.add(getMaxNumber(crongSecondNumber));

			pobiMaxValue = (int) Collections.max(pobiMaxNumbersList);
			crongMaxValue = (int) Collections.max(crongMaxNumbersList);

			if (pobiMaxValue == crongMaxValue) {
				answer = 0;
			} else if (pobiMaxValue > crongMaxValue) {
				answer = 1;
			} else if (pobiMaxValue < crongMaxValue) {
				answer = 2;
			}
		}

		return answer;
	}

	private static int getNumberLength(int number) {
		int length = (int) (Math.log10(number) + 1);
		return length;
	}

	private static int getMaxNumber(int number) {
		int maxValue = 0;

		if (getNumberLength(number) == 3) {
			int firstNumberFirstDigit = number / 100;
			int firstNumberSecondDigit = (number % 100) / 10;
			int firstNumberThirdDigit = (number % 100) % 10;

			int addition = getAddition(firstNumberFirstDigit, firstNumberSecondDigit, firstNumberThirdDigit);
			int multiplication = getMultiplication(firstNumberFirstDigit, firstNumberSecondDigit, firstNumberThirdDigit);
			if (addition > multiplication) {
				maxValue = addition;
			} else {
				maxValue = multiplication;
			}


		} else if (getNumberLength(number) == 2) {
			int firstNumberFirstDigit = (number % 100) / 10;
			int firstNumberSecondDigit = (number % 100) % 10;

			int addition = getAddition(firstNumberFirstDigit, firstNumberSecondDigit);
			int multiplication = getMultiplication(firstNumberFirstDigit, firstNumberSecondDigit);
			if (addition > multiplication) {
				maxValue = addition;
			} else {
				maxValue = multiplication;
			}
		} else {
			maxValue = number;
		}

		return maxValue;
	}

	public static int getAddition(int... numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		return sum;
	}

	public static int getMultiplication(int... numbers) {
		int multiply = 1;
		for (int i = 0; i < numbers.length; i++) {
			multiply = multiply * numbers[i];
		}
		return multiply;
	}
}
