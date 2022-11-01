package onboarding.problem3;

import onboarding.problem3.util.Game369InputVailidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolveGame369 {
	public boolean isFailedInputValidation(int number) {
		if (!Game369InputVailidator.rangeValidator(number)) return true;

		return false;
	}

	// 숫자 number가 매개변수로 주어질 때, 숫자를 각 자릿수로 분리하여 3, 6, 9에 해당하는 횟수를 반환
	public Integer count369OfSeparatedNum(Integer gameNum) {
		Integer appear369Count = 0;
		List<Integer> arrGameNum = new ArrayList<>();

		for (int i = 1; i <= gameNum; i++) {
			List<Integer> listSeparatedNum = makeSeparatedNum(i);
			for (Integer separatedNum : listSeparatedNum) {
				arrGameNum.add(separatedNum);
			}
		}

		List<Integer> game369Number = Arrays.asList(3, 6, 9);
		for (Integer num : game369Number) {
			appear369Count += Collections.frequency(arrGameNum, num);
		}

		return appear369Count;
	}

	private List<Integer> makeSeparatedNum(Integer gameNum) {
		List<Integer> separatedNum = new ArrayList<>();
		while (gameNum > 0) {
			separatedNum.add(gameNum % 10);
			gameNum /= 10;
		}
		return separatedNum;
	}
}
