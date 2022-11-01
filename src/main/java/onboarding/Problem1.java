package onboarding;

import java.util.List;

class Problem1 {
	private static int addValue(int num) {
		int answer = 0;
		while (true){
			answer += num % 10;
			if (num / 10 == 0){
				break;
			}
			num = num / 10;
		}
		return answer;
	}

	private static int multiplyValue(int num) {
		int answer = 1;
		while (true){
			answer *= num % 10;
			if (num / 10 == 0){
				break;
			}
			num = num / 10;
		}
		return answer;
	}

	private static int findMax(int num1, int num2, int num3, int num4) {
		if (num1 > num2 && num1 > num3 && num1 > num4)
			return num1;
		if (num2 > num3 && num2 > num4)
			return num2;
		if (num3 > num4)
			return num3;
		return num4;
	}

	private static int findAnswer(int pobiMax, int crongMax) {
		if (pobiMax > crongMax)
			return 1;
		if (pobiMax < crongMax)
			return 2;
		return 0;
	}

	private static boolean checkValid(List<Integer> pages) {
		if (pages.get(0) % 2 == 0 || pages.get(0) < 2)
			return false;
		if (pages.get(1) != pages.get(0) + 1 || pages.get(1) > 399)
			return false;
		return true;
	}

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer;
		if (checkValid(pobi) && checkValid(crong)) {
			int pobiMax = findMax(addValue(pobi.get(0)), multiplyValue(pobi.get(0)),
				addValue(pobi.get(1)), multiplyValue(pobi.get(1)));
			int crongMax = findMax(addValue(crong.get(0)), multiplyValue(crong.get(0)),
				addValue(crong.get(1)), multiplyValue(crong.get(1)));
			answer = findAnswer(pobiMax, crongMax);
			return answer;
		}
		answer = -1;
		return answer;
	}
}
