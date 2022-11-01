package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		if (getMax(pobi) > getMax(crong))
			answer = 1;
		else if (getMax(pobi) < getMax(crong))
			answer = 2;
		else if (getMax(pobi) == getMax(crong))
			answer = 0;
		if (!itemCheck(pobi) || !itemCheck(crong))
			answer = -1;
		return answer;
	}

	public static boolean itemCheck(List<Integer> pages)//페이지 입력이 제대로 되었는가 조건체크
	{
		if (pages.get(0) + 1 != pages.get(1))
			return false;
		if (pages.get(0) > 399 && pages.get(0) < 2)
			return false;
		if (pages.get(1) > 399 && pages.get(1) < 2)
			return false;
		return true;
	}

	public static List<Integer> giveDigitNum(Integer page) //페이지 각 자리의 수를 list로 return
	{
		List<Integer> digitNum = new ArrayList<Integer>();
		while (page != 0) {
			int num = page % 10;
			page /= 10;
			digitNum.add(num);
		}
		return digitNum;
	}

	public static int MulOrSum(List<Integer> digitNum) // 페이지의 각자리수를 곱하는게 큰가 더하는게 큰가
	{
		int max;
		int mul = 1;
		int sum = 0;
		for (Integer num : digitNum) {
			mul *= num;
			sum += num;
		}
		max = (mul > sum) ? mul : sum;
		return max;
	}

	public static int getMax(List<Integer> pages) {
		int max = 0;
		for (Integer num : pages) {
			if (max < MulOrSum(giveDigitNum(num)))
				max = MulOrSum(giveDigitNum(num));
		}
		return max;
	}
}
