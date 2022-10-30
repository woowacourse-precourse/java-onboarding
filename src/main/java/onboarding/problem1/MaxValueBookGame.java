package onboarding.problem1;

import onboarding.problem1.repository.BookInfoRepository;

import java.util.ArrayList;
import java.util.List;

public class MaxValueBookGame {
	BookInfoRepository bookInfoRepository;

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
}
