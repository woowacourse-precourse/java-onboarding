package onboarding.problem1;

import onboarding.problem1.util.BookGameInputVailidator;

import java.util.ArrayList;
import java.util.List;

public class MaxValueBookGame {
	public Integer sumSeparatorNum(Integer page) {
		List<Integer> separatorNum = new ArrayList<>();
		while (page > 0) {
			separatorNum.add(page % 10);
			page /= 10;
		}
		return separatorNum.stream().mapToInt(Integer::intValue).sum();
	}

	public Integer multiSeparatorNum(Integer page) {
		List<Integer> separatorNum = new ArrayList<>();
		while (page > 0) {
			separatorNum.add(page % 10);
			page /= 10;
		}
		return separatorNum.stream().reduce(1, (currentNum, nextNum) -> currentNum * nextNum);
	}

	public Integer returnMaxValue(Integer compareNumFirst, Integer compareNumSecond) {
		return (compareNumFirst > compareNumSecond) ? compareNumFirst : compareNumSecond;
	}

	public boolean isFailedInputValidation(List<Integer> gamePlayer) {
		if (BookGameInputVailidator.playerHasNullItem(gamePlayer)) return true;
		if (!BookGameInputVailidator.listLengthValidator(gamePlayer)) return true;
		if (!BookGameInputVailidator.pageRangeValidator(gamePlayer)) return true;
		if (!BookGameInputVailidator.nextPageValidator(gamePlayer)) return true;
		if (!BookGameInputVailidator.oddPageValidator(gamePlayer)) return true;
		if (!BookGameInputVailidator.evenPageValidator(gamePlayer)) return true;

		return false;
	}
}
