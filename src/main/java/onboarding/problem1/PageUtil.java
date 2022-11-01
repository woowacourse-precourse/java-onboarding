package onboarding.problem1;

import java.util.LinkedList;
import java.util.List;

public class PageUtil {

	public static boolean isValidPages(Book book) {
		if (book.getLeftPageNumber() + PageInfo.NEXT_INDEX.getInfo() != book.getRightPageNumber()) {
			return false;
		}

		if(book.getLeftPageNumber() < PageInfo.MIN_PAGE_INDEX.getInfo()
			|| book.getRightPageNumber() < PageInfo.MIN_PAGE_INDEX.getInfo()){
			return false;
		}

		if(book.getLeftPageNumber() > PageInfo.MAX_PAGE_INDEX.getInfo()
			|| book.getRightPageNumber() > PageInfo.MAX_PAGE_INDEX.getInfo()){
			return false;
		}

		return true;
	}


	public static long getMaxTimesPageNumber(Book book) {
		long leftTimesNumber = 1L;
		long rightTimesNumber = 1L;

		for (int i : splitNumber(book.getLeftPageNumber())) {
			leftTimesNumber *= i;
		}

		for (int i : splitNumber(book.getRightPageNumber())) {
			rightTimesNumber *= i;
		}


		return Math.max(leftTimesNumber, rightTimesNumber);
	}

	public static long getMaxPlusPageNumber(Book book) {
		long plusLeftNumber = 0L;
		long plusRightNumber = 0L;

		for (int i : splitNumber(book.getLeftPageNumber())) {
			plusLeftNumber += i;
		}

		for (int i : splitNumber(book.getRightPageNumber())) {
			plusRightNumber += i;
		}

		return Math.max(plusLeftNumber, plusRightNumber);
	}


	private static List<Integer> splitNumber(int number) {
		List<Integer> numberList = new LinkedList<>();

		for (char i : Integer.toString(number).toCharArray()) {
			numberList.add(Integer.parseInt(Character.toString(i)));
		}

		return numberList;
	}
}
