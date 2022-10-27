package onboarding;

import onboarding.validatechecker.Problem1ValidateChecker;

import java.util.List;

class Problem1 {
	private static final int LEFT_PAGE=0;
	private static final int RIGHT_PAGE=1;
	private static final int POBI_WIN=1;
	private static final int CRONG_WIN=2;
	private static final int DRAW=0;
	private static final int ERROR_CODE=-1;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if(!Problem1ValidateChecker.isPageValidate(pobi)
				|| !Problem1ValidateChecker.isPageValidate(crong))
			return ERROR_CODE;

		int pobiScore = compareLeftAndRight(pobi);
		int crongScore = compareLeftAndRight(crong);

		if(pobiScore > crongScore)
			return POBI_WIN;
		else if(pobiScore < crongScore)
			return CRONG_WIN;
		else
			return DRAW;
	}

	private static int compareLeftAndRight(List<Integer> pages){
		if(compareSumAndMulti(pages.get(LEFT_PAGE)) > compareSumAndMulti(pages.get(RIGHT_PAGE)))
			return compareSumAndMulti(pages.get(LEFT_PAGE));
		return compareSumAndMulti(pages.get(RIGHT_PAGE));
	}

	private static int compareSumAndMulti(Integer number){
		if(sumNumberOfDigit(number) > multiNumberOfDigit(number))
			return sumNumberOfDigit(number);
		return multiNumberOfDigit(number);
	}

	private static int sumNumberOfDigit(Integer number){
		int result = 0;
		while(number!=0){
			result += number % 10;
			number = number / 10;
		}
		return result;
	}

	private static int multiNumberOfDigit(Integer number){
		int result = 1;
		while(number!=0){
			result *= number % 10;
			number = number / 10;
		}
		return result;
	}
}