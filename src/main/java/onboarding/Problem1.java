package onboarding;

import java.util.List;

class Problem1 {
	private static boolean isValidList(List<Integer> list) {
		int left;
		int right;

		left = list.get(0);
		right = list.get(1);
		return (list.size() == 2
				&& right - left == 1
				&& 1 < left && left < 400
				&& left % 2 == 1
				&& 1 < right && right < 400
				&& right % 2 == 0);
	}
	private static int	getDigitSum(int page)
	{
		return (page / 100 + (page % 100) / 10 + page % 10);
	}
	private static int	getDigitMultiplication(int page)
	{
		int	remainder = page;
		int	result = 1;

		while (remainder > 0)
		{
			result *= remainder % 10;
			remainder /= 10;
		}
		return (result);
	}
	private static int	getMax(int page)
	{
		return (Math.max(getDigitSum(page), getDigitMultiplication(page)));
	}
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int	pobiMax;
		int	crongMax;

		if (!isValidList(pobi) || !isValidList(crong))
			return (-1);
		pobiMax = Math.max(getMax(pobi.get(0)), getMax(pobi.get(1)));
		crongMax = Math.max(getMax(crong.get(0)), getMax(crong.get(1)));
		if (pobiMax > crongMax)
			return (1);
		else if (pobiMax < crongMax)
			return (2);
		return (0);
	}
}