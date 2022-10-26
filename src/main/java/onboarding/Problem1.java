package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

        Integer pobiMax = pobi.stream()
                .map(Problem1::getMaxPage)
                .max(Integer::compareTo)
                .orElse(-1);

		Integer crongMax = crong.stream()
				.map(Problem1::getMaxPage)
				.max(Integer::compareTo)
				.orElse(-1);

		if (pobiMax > crongMax) {
			return 1;
		}
		if (pobiMax < crongMax) {
			return 2;
		}
		return 0;
	}

	private static int getMaxPage(Integer page) {
		int sum = 0;
		int mul = 1;
		int temp;
		while (page > 0) {
			temp = page % 10;
			page /= 10;
			sum += temp;
			mul *= temp;
		}
		return Math.max(sum, mul);
	}
}