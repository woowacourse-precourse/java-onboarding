package onboarding.problem1.domain;

import java.util.function.BinaryOperator;

import static java.util.Arrays.stream;

public class Page {

	private final int number;

	public Page(int number) {
		this.number = number;
	}

	/**
	 * 현재 페이지와 인자로 들어온 페이지 사이의 간격을 반환한다.
	 */
	public int interval(Page page) {
		return this.number - page.number;
	}

	public boolean isOdd() {
		return (number & 1) == 1;
	}

	public boolean isEven() {
		return (number & 1) == 0;
	}

	/**
	 * 열린 구간을 벗어났는지 검사한다.
	 * @param low 가능한 최소 범위 - 1
	 * @param upper 가능한 최대 범위 + 1
	 */
	public boolean isOutOfRange(int low, int upper) {
		return (this.number <= low)
				|| (this.number >= upper);
	}

	/**
	 * 입력받은 연산을 통해 점수를 계산한다.
	 * @param operator 연산
	 * @param init 연산의 초기값
	 */
	public int scoreByOperator(BinaryOperator<Integer> operator, int init) {
		return stream(Integer.toString(number).split(""))
				.map(Integer::parseInt)
				.reduce(init, operator);
	}
}

