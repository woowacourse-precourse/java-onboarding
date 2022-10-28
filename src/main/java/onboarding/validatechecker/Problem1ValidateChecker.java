package onboarding.validatechecker;

import java.util.List;

public class Problem1ValidateChecker {
	private static final int LEFT_PAGE=0;
	private static final int RIGHT_PAGE=1;
	private static final int PAGE_SIZE=2;
	private static final int MIN_PAGE_NUM=1;
	private static final int MAX_PAGE_NUM=400;

	public static boolean isPageValidate(List<Integer> pages){
		return  isPagesNotNull(pages) && isPageSizeCorrect(pages)
			&& isPageNumberNotNull(pages) && isPageNumberContinuous(pages)
			&& isPageNumberCheckOddOrEven(pages) && isRightBiggerThanLeft(pages)
			&& isPageNumberInRange(pages);
	}

	private static boolean isPagesNotNull(List<Integer> pages){
		return pages != null;
	}

	private static boolean isPageNumberNotNull(List<Integer> pages){
		return pages.get(RIGHT_PAGE) != null && pages.get(LEFT_PAGE) != null;
	}

	private static boolean isPageSizeCorrect(List<Integer> pages){
		return pages.size() == PAGE_SIZE;
	}

	private static boolean isPageNumberContinuous(List<Integer> pages){
		return pages.get(LEFT_PAGE)+1 == pages.get(RIGHT_PAGE);
	}

	private static boolean isPageNumberCheckOddOrEven(List<Integer> pages){
		return pages.get(LEFT_PAGE)%2==1 && pages.get(RIGHT_PAGE)%2==0;
	}

	private static boolean isPageNumberInRange(List<Integer> pages){
		return pages.get(LEFT_PAGE) >= MIN_PAGE_NUM && pages.get(RIGHT_PAGE) <= MAX_PAGE_NUM;
	}

	private static boolean isRightBiggerThanLeft(List<Integer> pages){
		return pages.get(LEFT_PAGE) < pages.get(RIGHT_PAGE);
	}
}
