package onboarding;

import static onboarding.enums.problem3.Index.*;
import static onboarding.enums.problem3.ClapNumber.*;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
	private static final String REGEX = "";
	private static int[] memoization;

	public static int solution(int number) {
		initMemoizationArr();

		return countClap(number);
	}

	public static void initMemoizationArr() {
		memoization = new int[10001];
		memoization[0] = memoization[1] = memoization[2] = 0;
	}

	public static int countClap(int number) {
		for (int index = MEMOIZATION_START_INDEX.getNumber(); index < number + 1; index++) {
			memoization[index] = memoization[index - 1];
			checkThreeSixNine(Arrays.asList(String.valueOf(index).split(REGEX)), index);
		}
		return memoization[number];
	}

	public static void checkThreeSixNine(List<String> list, int index) {
		for (String number : list) {
			if (isThreeSixNine(number)) {
				clap(index);
			}
		}
	}

	public static void clap(int index) {
		memoization[index]++;
	}

	public static boolean isThreeSixNine(String number) {
		return (number.equals(THREE.getSpecialNumber())
			|| number.equals(SIX.getSpecialNumber())
			|| number.equals(NINE.getSpecialNumber()));
	}
}
