package onboarding;

import java.util.List;
import java.util.stream.Stream;

/**
 * Problem1 기능 목록
 * 1. input 값 확인 후 예외 처리
 * 2. 포비와 크롱의 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구하기
 * 3. 포비와 크롱의 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 4. 2~3 과정에서 가장 큰 수를 포비와 크롱의 점수로 정하기
 * 5. 점수를 비교해 더 큰 사람을 리턴하기
 */
class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		// input 값 확인 후 예외 처리
		if (is1to400(pobi) || is1to400(crong) || isException(pobi) || isException(crong)) {
			return -1;
		}

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
		return getResult(pobiMaxValue, crongMaxValue);
	}

	private static int getResult(int pobiMaxValue, int crongMaxValue) {
		if (pobiMaxValue == crongMaxValue) {
			return 0;
		}
		return (pobiMaxValue > crongMaxValue) ? 1 : 2;
	}

	private static boolean is1to400(List<Integer> list) {
		return list.get(0) <= 0 || list.get(0) >= 401 || list.get(1) <= 0 || list.get(1) >= 401;
	}

	private static boolean isException(List<Integer> list) {
		return list.get(0) != list.get(1) - 1 || list.get(0) % 2 != 1 || list.size() != 2;
	}

	private static int getSide(String side) {
		return (side.equals("left")) ? 0 : 1;
	}

	static int[] getDigitArray(int number) {
		return Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
	}

	private static int getSideValue(List<Integer> list, String side) {
		int leftRight = getSide(side);
		int[] array = getDigitArray(list.get(leftRight));
		return Math.max(getArraySum(array), getArrayMultiply(array));
	}

	private static int getArraySum(int[] array) {
		int sum = 0;
		for (int j : array) {
			sum += j;
		}
		return sum;
	}

	private static int getArrayMultiply(int[] array) {
		int sum = 1;
		for (int j : array) {
			sum *= j;
		}
		return sum;
	}
}
