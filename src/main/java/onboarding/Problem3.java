package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
	public static int solution(int number) {
		validateNumber(number);

		int answer = IntStream.rangeClosed(1, number)
				.mapToObj(String::valueOf)
				.mapToInt(x-> getThreeSixNineConut(x))
				.sum();

		return answer;
	}

	/**
	 * 주어진 정수에 대한 유효성 검사
	 * @param number
	 */
	public static void validateNumber(int number) {
		if(number > 10000 || number < 1) throw new IllegalArgumentException();
	}

	/**
	 * 주어진 숫자를 변환한 문자열에 3,6,9를 가지고 있는 수만큼 반환한다.
	 * @param numberString
	 * @return
	 */
	public static int getThreeSixNineConut(String numberString) {
		return (int) numberString.chars()
				.filter(ch->ch == '3' || ch == '6' || ch == '9')
				.count();
	}
}
