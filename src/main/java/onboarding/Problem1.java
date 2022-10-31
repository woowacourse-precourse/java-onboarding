package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		return getAnswer(pobi, crong);
	}

	private static int getAnswer(List<Integer> pobi, List<Integer> crong) {
		if (pobi.get(1) != pobi.get(0) + 1 || crong.get(1) != crong.get(0) + 1)
			return -1;
		if (getScroe(pobi.get(0), pobi.get(1)) > getScroe(crong.get(0), crong.get(1)))
			return 1;
		if (getScroe(pobi.get(0), pobi.get(1)) == getScroe(crong.get(0), crong.get(1)))
			return 0;
		return -2;
	}

	private static int maxOfPage(int page) {
		int[] arr = new int[3];
		int sum = 0;
		int multiple = 1;
		for (int i : arr) {
			arr[i] = page % 10;
			sum += arr[i];
			multiple *= arr[i];
			if (page / 10 == 0)
				break;
			page /= 10;
		}
		if (sum > multiple)
			return sum;
		return multiple;
	}

	private static int getScroe(int page_1, int page_2) {
		if (maxOfPage(page_1) > maxOfPage(page_2))
			return maxOfPage(page_1);
		return maxOfPage(page_2);
	}
}
