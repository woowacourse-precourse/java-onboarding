package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {

		int pobiLeft = getMaxValue(getDigitArray(pobi, "left"));
		int crongLeft = getMaxValue(getDigitArray(crong, "left"));

		int pobiRight = getMaxValue(getDigitArray(pobi, "right"));
		int crongRight = getMaxValue(getDigitArray(crong, "right"));

		int pobiMaxValue = Math.max(pobiLeft, pobiRight);
		int crongMaxValue = Math.max(crongLeft, crongRight);

		if (isException(pobi) && isException(crong)) {
			if (pobiMaxValue == crongMaxValue) {
				return 0;
			}
			return (pobiMaxValue > crongMaxValue) ? 1 : 2;
		} else
			return -1;
	}

	static boolean isException(List<Integer> list) {
		return list.get(0) == list.get(1) - 1;
	}

	static int[] getDigitArray(List<Integer> list, String side) {
		int leftRight = (side.equals("left")) ? 0 : 1;
		return Stream.of(String.valueOf(list.get(leftRight)).split("")).mapToInt(Integer::parseInt).toArray();
	}

	static int getMaxValue(int[] array) {
		return Math.max(getArraySum(array), getArrayMultiply(array));
	}

	static int getArraySum(int[] array) {
		int sum = 0;
		for (int j : array) {
			sum += j;
		}
		return sum;
	}

	static int getArrayMultiply(int[] array) {
		int sum = 1;
		for (int j : array) {
			sum *= j;
		}
		return sum;
	}
}
