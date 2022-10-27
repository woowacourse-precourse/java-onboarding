package onboarding;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class Problem1Test {

	@Test
	void 게임_결과값() throws Exception {
		Integer pobi = 56;
		Integer crong = 88;
		assertThat(Problem1.getPageGameResult(pobi, crong)).isEqualTo(2);

		pobi = 102;
		crong = 45;
		assertThat(Problem1.getPageGameResult(pobi, crong)).isEqualTo(1);

		pobi = 90;
		crong = 90;
		assertThat(Problem1.getPageGameResult(pobi, crong)).isEqualTo(0);
	}

	@Test
	void 큰_숫자_찾기() {
		List<Integer> pobi = List.of(97, 98);
		List<Integer> crong = List.of(197, 198);
		assertThat(Problem1.getMaxPageNumber(pobi)).isEqualTo(72);
		assertThat(Problem1.getMaxPageNumber(crong)).isEqualTo(72);

		pobi = List.of(131, 132);
		crong = List.of(211, 212);
		assertThat(Problem1.getMaxPageNumber(pobi)).isEqualTo(6);
		assertThat(Problem1.getMaxPageNumber(crong)).isEqualTo(5);
	}

	@Test
	void 범위에_맞지않는_수() {
		int result = -1;

		List<Integer> pobi = List.of(-1, 0);
		List<Integer> crong = List.of(345, 346);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(401, 402);
		crong = List.of(77, 78);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(37, 38);
		crong = List.of(-11, -12);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(109, 110);
		crong = List.of(607, 608);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	void 시작면() {
		int result = -1;

		List<Integer> pobi = List.of(1, 2);
		List<Integer> crong = List.of(211, 212);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(301, 302);
		crong = List.of(1, 2);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(1, 2);
		crong = List.of(1, 2);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	void 마지막면() {
		int result = -1;

		List<Integer> pobi = List.of(101, 102);
		List<Integer> crong = List.of(399, 400);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(301, 302);
		crong = List.of(399, 400);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(1, 2);
		crong = List.of(399, 400);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	void 리스트_길이가_2개가_아닐_때() {
		int result = -1;

		List<Integer> pobi = List.of(11, 12, 13);
		List<Integer> crong = List.of(197, 198);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(311, 312);
		crong = List.of(45, 46, 47);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(101);
		crong = List.of(277, 278);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(215, 216);
		crong = List.of(87);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(93);
		crong = List.of(145, 146, 147);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	void 홀수_짝수_순서가_아니거나_연속적인_값이_아닐_때() {
		int result = -1;

		List<Integer> pobi = List.of(82, 83);
		List<Integer> crong = List.of(95, 96);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(59, 60);
		crong = List.of(106, 107);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(311, 313);
		crong = List.of(45, 46);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(103, 104);
		crong = List.of(277, 304);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

}