package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {

		// 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
		int pobiLeft = getSideValue(pobi, "left");
		int crongLeft = getSideValue(crong, "left");

		// 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
		int pobiRight = getSideValue(pobi, "right");
		int crongRight = getSideValue(crong, "right");


		//2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
		int pobiMaxValue = Math.max(pobiLeft, pobiRight);
		int crongMaxValue = Math.max(crongLeft, crongRight);

		//점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
		if (isException(pobi) && isException(crong)) {
			if (pobiMaxValue == crongMaxValue) {
				return 0;
			}
			return (pobiMaxValue > crongMaxValue) ? 1 : 2;
		} else
			return -1;
	}

	static boolean isException(List<Integer> list) {
		return list.get(0) == list.get(1) - 1 && list.get(0) % 2 == 1 && list.size() == 2;
	}
	static int getSide(String side) {
		return (side.equals("left")) ? 0 : 1;
	}
	static int[] getDigitArray(int number) {
		return Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
	}

	static int getSideValue(List<Integer> list, String side) {
		int leftRight = getSide(side);
		int[] array = getDigitArray(list.get(leftRight));
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
