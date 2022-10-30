package onboarding;

import static onboarding.Problem1.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.*;

class Problem1Test {

	@Nested
	class IntegrationTest {

		@Test
		@DisplayName("포비의 페이지가 범위 밖일 경우 -1을 반환해야 한다")
		public void pobiPageOutOfRangeTest() {
			List<Integer> pobi = List.of(-1, 0);
			List<Integer> crong = List.of(3, 4);
			assertThat(solution(pobi, crong)).isEqualTo(-1);
		}

		@Test
		@DisplayName("크롱의 페이지가 범위 밖일 경우 -1을 반환해야 한다")
		public void crongPageOutOfRangeTest() {
			List<Integer> pobi = List.of(97, 98);
			List<Integer> crong = List.of(399, 400);
			assertThat(solution(pobi, crong)).isEqualTo(-1);
		}

		@Test
		@DisplayName("크롱의 페이지가 연속되지 않은 경우 -1을 반환해야 한다")
		public void crongPageNotSerialTest() {
			List<Integer> pobi = List.of(97, 98);
			List<Integer> crong = List.of(3, 5);
			assertThat(solution(pobi, crong)).isEqualTo(-1);
		}

		@Test
		@DisplayName("포비의 페이지가 좌측이 1 더 큰 경우 -1을 반환해야 한다")
		public void pobiRightPageIs1BiggerTest() {
			List<Integer> pobi = List.of(98, 97);
			List<Integer> crong = List.of(3, 4);
			assertThat(solution(pobi, crong)).isEqualTo(-1);
		}

		@Test
		@DisplayName("포비의 왼쪽 페이지가 짝수인경우 -1을 반환한다")
		public void pobiLeftPageIsEvenTest() {
			List<Integer> pobi = List.of(98, 99);
			List<Integer> crong = List.of(5, 6);
			assertThat(solution(pobi, crong)).isEqualTo(-1);
		}

		@Test
		@DisplayName("크롱의 왼쪽 페이지가 짝수인경우 -1을 반환한다")
		public void crongLeftPageIsEvenTest() {
			List<Integer> pobi = List.of(55, 56);
			List<Integer> crong = List.of(10, 11);
			assertThat(solution(pobi, crong)).isEqualTo(-1);
		}

		@Test
		@DisplayName("크롱의 더한 페이지가 곱한 페이지보다 크고, 그것이 포비의 점수인 더한 페이지보다 크다")
		public void crongMaxIsAddAndBiggerThanPobiMaxIsAdd() {
			List<Integer> pobi = List.of(111, 112);
			List<Integer> crong = List.of(115, 116);
			assertThat(solution(pobi, crong)).isEqualTo(2);
		}

		@Test
		@DisplayName("포비의 곱한 페이지가 더한 페이지보다 크고, 그것이 크롱의 점수인 곱한 페이지보다 크다")
		public void pobiMaxIsProductAndBiggerThanCrongMaxIsProduct() {
			List<Integer> pobi = List.of(187, 188);
			List<Integer> crong = List.of(77, 78);
			assertThat(solution(pobi, crong)).isEqualTo(1);
		}
	}

	@Nested
	class GetMaxDigitTest {

		@Test
		@DisplayName("정수의 각 자리 수 합을 반환해야 한다")
		public void getMaxDigitSumTest() {
			List<Integer> pageList = List.of(123, 124);
			assertThat(getMaxDigitSum(pageList)).isEqualTo(1+2+4);
		}

		@Test
		@DisplayName("정수의 각 자리 수 곱을 반환해야 한다")
		public void getMaxDigitProductTest() {
			List<Integer> pageList = List.of(129, 130);
			assertThat(getMaxDigitProduct(pageList)).isEqualTo(1*2*9);
		}
	}

	@Nested
	class GetScoreTest {

		@Test
		@DisplayName("곱한 값이 더 큰 경우 곱한 값을 반환해야 한다")
		public void getScoreTest1() {
			List<Integer> pageList = List.of(357, 358);
			assertThat(getScore(pageList)).isEqualTo(120);
		}

		@Test
		@DisplayName("더한 값이 더 큰 경우 더한 값을 반환해야 한다")
		public void getScoreTest2() {
			List<Integer> pageList = List.of(19, 20);
			assertThat(getScore(pageList)).isEqualTo(10);
		}
	}

	@Nested
	class GetWinnerTest {

		@Test
		public void drawTest1() {
			List<Integer> pobi = List.of(199, 200);
			List<Integer> crong = List.of(99, 100);
			assertThat(getWinner(pobi, crong)).isEqualTo(0);
		}

		@Test
		public void drawTest2() {
			List<Integer> pobi = List.of(199, 200);
			List<Integer> crong = List.of(199, 200);
			assertThat(getWinner(pobi, crong)).isEqualTo(0);
		}

		@Test
		public void pobiWinTest() {
			List<Integer> pobi = List.of(17, 18);
			List<Integer> crong = List.of(15, 16);
			assertThat(getWinner(pobi, crong)).isEqualTo(1);
		}

		@Test
		public void crongWinTest() {
			List<Integer> pobi = List.of(395, 396);
			List<Integer> crong = List.of(397, 398);
			assertThat(getWinner(pobi, crong)).isEqualTo(2);
		}
	}

	@Nested
	class ExceptionHandlingTest {

		@Test
		public void checkPageHasAscending1DifferenceTest() {
			List<Integer> pageList = List.of(234, 233);
			assertThrows(IllegalStateException.class, () -> {
				checkPageHasAscending1Difference(pageList);
			});
		}

		@Test
		public void checkListInGivenRangeTest1() {
			List<Integer> pageList = List.of(0, 1);
			assertThrows(IllegalStateException.class, () -> {
				checkListInGivenRange(pageList);
			});
		}

		@Test
		public void checkListInGivenRangeTest2() {
			List<Integer> pageList = List.of(399, 400);
			assertThrows(IllegalStateException.class, () -> {
				checkListInGivenRange(pageList);
			});
		}

		@Test
		public void checkLeftPageIsOddTest() {
			List<Integer> pageList = List.of(272, 273);
			assertThrows(IllegalStateException.class, () -> {
				checkLeftPageIsOdd(pageList);
			});
		}
	}
}
