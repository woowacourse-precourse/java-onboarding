package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Problem1Test {

	@Test
	@DisplayName("캐릭터별 큰 숫자 찾기")
	void 캐릭터별_큰_숫자_찾기(){
		List<Integer> pobi = List.of(97, 98);
		List<Integer> crong = List.of(197, 198);

		assertThat(new Problem1.Friend(pobi).getMaxNumber()).isEqualTo(72);
		assertThat(new Problem1.Friend(crong).getMaxNumber()).isEqualTo(72);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(0);

		pobi = List.of(99, 100);
		crong = List.of(11, 12);
		assertThat(new Problem1.Friend(pobi).getMaxNumber()).isEqualTo(81);
		assertThat(new Problem1.Friend(crong).getMaxNumber()).isEqualTo(3);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(1);
	}

	@Test
	@DisplayName("인자값이 2개가 아닐 때 pobi")
	void 인자값이_2개가_아닐_때() {
		List<Integer> pobi = List.of(100);
		List<Integer> crong = List.of(197, 198);
		int result = -1;
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(99,100);
		crong = List.of(198);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(99,100);
		crong = List.of(198,199,200);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(99, 100, 101);
		crong = List.of(198,199);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of();
		crong = List.of();
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(101);
		crong = List.of(199);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(99, 100, 101);
		crong = List.of(198,199, 200);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	@DisplayName("시작면, 마지막 면이 나올 때")
	void 시작면_마지막면이_나올때() {
		List<Integer> pobi = List.of(1, 2);
		List<Integer> crong = List.of(197, 198);
		int result = -1;
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(197, 198);
		crong = List.of(1 ,2);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(399, 400);
		crong = List.of(197, 198);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(197, 198);
		crong = List.of(399, 400);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	@DisplayName("페이지 수가 연속적이지 않거나, 순서가 바꼈을 때")
	void 페이지수가_연속적이지_않을_때_OR_순서가_바꼈을_때(){
		List<Integer> pobi = List.of(5, 7);
		List<Integer> crong = List.of(197, 198);
		int result = -1;
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(197, 195);
		crong = List.of(11, 12);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(197, 198);
		crong = List.of(11, 13);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(197, 198);
		crong = List.of(11, 10);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	@DisplayName("왼쪽페이지가 짝수일 때")
	void 왼쪽페이지가_짝수일_때() {
		List<Integer> pobi = List.of(10, 11);
		List<Integer> crong = List.of(197, 198);
		int result = -1;
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	@DisplayName("왼쪽페이지가 홀수일 때")
	void 왼쪽페이지가_홀수일_때() {
		List<Integer> pobi = List.of(11, 12);
		List<Integer> crong = List.of(10, 11);
		int result = -1;
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	@DisplayName("페이지 수가 요구상에서 벗어날 때 pobi")
	void 페이지_수가_요구사항에서_벗어날_때1() {
		List<Integer> pobi = List.of(-100, -99);
		List<Integer> crong = List.of(197, 198);
		int result = -1;
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(-1, 0);
		crong = List.of(197, 198);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(401, 402);
		crong = List.of(197, 198);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(599, 600);
		crong = List.of(197, 198);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}

	@Test
	@DisplayName("페이지 수가 요구상에서 벗어날 때 crong")
	void 페이지_수가_요구사항에서_벗어날_때2() {
		List<Integer> pobi = List.of(197, 198);
		List<Integer> crong = List.of(-100, -99);
		int result = -1;
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(197, 198);
		crong = List.of(-1, 0);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(197, 198);
		crong = List.of(401, 402);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);

		pobi = List.of(197, 198);
		crong = List.of(599, 600);
		assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
	}
}