package onboarding;

import static onboarding.Problem1.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Problem1Test {

	@Test
	void 크롱이_이기는_경우() {
		List<Integer> pobi = List.of(11, 12);
		List<Integer> crong = List.of(197, 198);
		int result = 2;
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	void 포비가_이기는_경우() {
		List<Integer> pobi = List.of(197, 198);
		List<Integer> crong = List.of(11, 12);
		int result = 1;
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	void 비기는_경우() {
		List<Integer> pobi = List.of(97, 98);
		List<Integer> crong = List.of(197, 198);
		int result = 0;
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	void 페이지_간격이_2페이지_이상이면_예외처리() {
		List<Integer> pobi = List.of(97, 100);
		List<Integer> crong = List.of(197, 198);
		int result = -1;
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	void 페이지_순서_뒤바뀌면_예외처리() {
		List<Integer> pobi = List.of(98, 97);
		List<Integer> crong = List.of(197, 198);
		int result = -1;
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	void 페이지_범위_예외처리() {
		List<Integer> pobi = List.of(500, 100);
		List<Integer> crong = List.of(197, 198);
		int result = -1;
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	void 최대_점수_구하기() {
		List<Integer> pobi = List.of(98, 97);
		List<Integer> crong = List.of(197, 198);
		int max = 72;
		assertThat(Math.max(maxScore(pobi), maxScore(crong))).isEqualTo(max);
	}

	@Test
	void 더하기_최대_점수_구하기() {
		int pageNumber = 123;
		String[] pageNumberSplit = String.valueOf(pageNumber).split("");
		int result = 6;
		assertThat(maxPlusSum(pageNumberSplit)).isEqualTo(result);
	}

	@Test
	void 곱하기_최대_점수_구하기() {
		int pageNumber = 234;
		String[] pageNumberSplit = String.valueOf(pageNumber).split("");
		int result = 24;
		assertThat(maxMultiplySum(pageNumberSplit)).isEqualTo(result);
	}
}
