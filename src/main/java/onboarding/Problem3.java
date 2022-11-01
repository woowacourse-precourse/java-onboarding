package onboarding;

import java.util.stream.Stream;

public class Problem3 {
	private static final int START_NUMBER = 1;

	public static int solution(int number) {
		return Stream.iterate(START_NUMBER, num -> num + 1)
				.limit(number)
				.map(Problem3::intToString)
				.map(Problem3::count369)
				.reduce(0, Integer::sum);
	}

	public static String intToString(int number) {
		return Integer.toString(number);
	}

	public static int count369(String number) {
		return (int) number.chars()
				.map(Character::getNumericValue)
				.filter(num -> num == 3 || num == 6 || num == 9)
				.count();
	}
}
