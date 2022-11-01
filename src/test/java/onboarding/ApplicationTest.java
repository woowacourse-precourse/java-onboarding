package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest {

	@Nested
	class Problem1Test {
		@Test
		@DisplayName("무승부")
		void case1() {
			List<Integer> pobi = List.of(97, 98);
			List<Integer> crong = List.of(197, 198);
			int result = 0;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}

		@Test
		@DisplayName("포비의 승리")
		void case2() {
			List<Integer> pobi = List.of(131, 132);
			List<Integer> crong = List.of(211, 212);
			int result = 1;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}

		@Test
		@DisplayName("연속되지 않는 페이지로 비교 불가")
		void case3() {
			List<Integer> pobi = List.of(99, 102);
			List<Integer> crong = List.of(211, 212);
			int result = -1;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}

		@Test
		@DisplayName("페이지 범위 초과로 비교 불가")
		void case4() {
			List<Integer> pobi = List.of(399, 400);
			List<Integer> crong = List.of(401, 402);
			int result = -1;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}

		@Test
		@DisplayName("페이지 범위 미만으로 비교 불가")
		void case5() {
			List<Integer> pobi = List.of(0, 1);
			List<Integer> crong = List.of(1, 2);
			int result = -1;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}

		@Test
		@DisplayName("크롱의 승리")
		void case6() {
			List<Integer> pobi = List.of(1, 2);
			List<Integer> crong = List.of(3, 4);
			int result = 2;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}

		@Test
		@DisplayName("홀수로 시작하지 않는 페이지로 비교 불가")
		void case7() {
			List<Integer> pobi = List.of(2, 3);
			List<Integer> crong = List.of(1, 2);
			int result = -1;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}
	}

	@Nested
	class Problem2Test {
		@Test
		@DisplayName("정상 동작1")
		void case1() {
			String cryptogram = "browoanoommnaon";
			String result = "brown";
			assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
		}

		@Test
		@DisplayName("정상 동작2")
		void case2() {
			String cryptogram = "zyelleyz";
			String result = "";
			assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
		}

		@Test
		@DisplayName("대문자가 포함되어 예외 발생")
		void case3() {
			String cryptogram = "helloWorld";
			RuntimeException exception = assertThrows(RuntimeException.class,
					() -> Problem2.solution(cryptogram));
			System.out.println(exception.getMessage());
		}

		@Test
		@DisplayName("허용되지 않는 문자열 길이(1001)로 예외 발생")
		void case4() {
			String cryptogram = "a".repeat(1001);
			RuntimeException exception = assertThrows(RuntimeException.class,
					() -> Problem2.solution(cryptogram));
			System.out.println(exception.getMessage());
		}

		@Test
		@DisplayName("허용되지 않는 문자열 길이(0)로 예외 발생")
		void case5() {
			String cryptogram = "";
			RuntimeException exception = assertThrows(RuntimeException.class,
					() -> Problem2.solution(cryptogram));
			System.out.println(exception.getMessage());
		}
	}

	@Nested
	class Problem3Test {
		@Test
		void case1() {
			int number = 13;
			int result = 4;
			assertThat(Problem3.solution(number)).isEqualTo(result);
		}

		@Test
		void case2() {
			int number = 33;
			int result = 14;
			assertThat(Problem3.solution(number)).isEqualTo(result);
		}

		@Test
		@DisplayName("허용되지 않는 입력값 크기(0)로 예외 발생")
		void case3() {
			int number = 0;
			RuntimeException exception = assertThrows(RuntimeException.class, () -> Problem3.solution(number));
			System.out.println(exception.getMessage());
		}

		@Test
		@DisplayName("허용되지 않는 입력값 크기(10001)로 예외 발생")
		void case4() {
			int number = 10001;
			RuntimeException exception = assertThrows(RuntimeException.class, () -> Problem3.solution(number));
			System.out.println(exception.getMessage());
		}
	}

	@Nested
	class Problem4Test {
		@Test
		void case1() {
			String word = "I love you";
			String result = "R olev blf";
			assertThat(Problem4.solution(word)).isEqualTo(result);
		}

		@Test
		@DisplayName("소문자는 역순으로 변환")
		void case2() {
			String word = "abcdefghijklmnopqrstuvwxyz";
			String result = "zyxwvutsrqponmlkjihgfedcba";
			assertThat(Problem4.solution(word)).isEqualTo(result);
		}

		@Test
		@DisplayName("대문자는 역순으로 변환")
		void case3() {
			String word = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
			String result = "zyxwvutsrqponmlkjihgfedcba".toUpperCase();
			assertThat(Problem4.solution(word)).isEqualTo(result);
		}

		@Test
		@DisplayName("숫자, 한글, 특수문자는 그대로 반환")
		void case4() {
			String word = "!@#$%^&*()1234567890안녕";
			String result = "!@#$%^&*()1234567890안녕";
			assertThat(Problem4.solution(word)).isEqualTo(result);
		}
	}

	@Nested
	class Problem5Test {
		@Test
		void case1() {
			int money = 50_237;
			List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
			assertThat(Problem5.solution(money)).isEqualTo(result);
		}

		@Test
		void case2() {
			int money = 15_000;
			List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
			assertThat(Problem5.solution(money)).isEqualTo(result);
		}
	}

	@Nested
	class Problem6Test {
		@Test
		void case1() {
			List<List<String>> forms = List.of(
					List.of("jm@email.com", "제이엠"),
					List.of("jason@email.com", "제이슨"),
					List.of("woniee@email.com", "워니"),
					List.of("mj@email.com", "엠제이"),
					List.of("nowm@email.com", "이제엠")
			);
			List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}

		@Test
		@DisplayName("한글자 닉네임 처리")
		void case2() {
			List<List<String>> forms = List.of(
					List.of("jm@email.com", "제"),
					List.of("jason@email.com", "제이슨"),
					List.of("woniee@email.com", "워니"),
					List.of("mj@email.com", "엠제이"),
					List.of("nowm@email.com", "이제엠")
			);
			List<String> result = List.of("jason@email.com", "mj@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}

		@Test
		@DisplayName("한글자 닉네임의 중복 처리")
		void case3() {
			List<List<String>> forms = List.of(
					List.of("jm@email.com", "제"),
					List.of("jason@email.com", "제"),
					List.of("woniee@email.com", "워니"),
					List.of("mj@email.com", "엠제이"),
					List.of("nowm@email.com", "이제엠")
			);
			List<String> result = List.of("jason@email.com", "jm@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}

		@Test
		@DisplayName("한 글자 닉네임과 반복 닉네임 처리")
		void case4() {
			List<List<String>> forms = List.of(
					List.of("jm@email.com", "제"),
					List.of("jason@email.com", "제제"),
					List.of("woniee@email.com", "제제제"),
					List.of("mj@email.com", "엠제이"),
					List.of("nowm@email.com", "이제엠")
			);
			List<String> result = List.of("jason@email.com", "woniee@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}

		@Test
		@DisplayName("중복되는 닉네임이 존재하지 않음")
		void case5() {
			List<List<String>> forms = List.of(
					List.of("jm@email.com", "안"),
					List.of("jason@email.com", "녕"),
					List.of("woniee@email.com", "하"),
					List.of("mj@email.com", "세"),
					List.of("nowm@email.com", "요")
			);
			List<String> result = List.of();
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}

		@Test
		@DisplayName("허용되지 않는 이메일 형식으로 예외 발생")
		void case6() {
			List<List<String>> forms = List.of(
					List.of("jm@gmail.com", "제"),
					List.of("jason@email.com", "제제"),
					List.of("woniee@email.com", "제제제"),
					List.of("mj@email.com", "엠제이"),
					List.of("nowm@email.com", "이제엠")
			);
			RuntimeException exception = assertThrows(RuntimeException.class, () -> Problem6.solution(forms));
			System.out.println(exception.getMessage());
		}

		@Test
		@DisplayName("허용되지 않는 닉네임 형식으로 예외 발생")
		void case7() {
			List<List<String>> forms = List.of(
					List.of("jm@gmail.com", "아a아")
			);
			RuntimeException exception = assertThrows(RuntimeException.class, () -> Problem6.solution(forms));
			System.out.println(exception.getMessage());
		}

		@Test
		@DisplayName("모음 또는 자음 닉네임 정상 처리")
		void case8() {
			List<List<String>> forms = List.of(
					List.of("qwe@email.com", "ㅈㅌㅎ"),
					List.of("asd@email.com", "ㅏㅐㅘ"),
					List.of("zxc@email.com", "ㅡㅣ")
			);
			List<String> result = List.of();
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}

		@Test
		@DisplayName("모음 또는 자음 닉네임의 중복으로 예외 발생")
		void case9() {
			List<List<String>> forms = List.of(
					List.of("qwe@email.com", "ㅋ"),
					List.of("asd@email.com", "ㅋㅋ"),
					List.of("zxc@email.com", "ㅋㅋㅋ")
			);
			List<String> result = List.of("asd@email.com", "zxc@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}

		@Test
		@DisplayName("중복된 이메일 사용으로 예외 발생")
		void case10() {
			List<List<String>> forms = List.of(
					List.of("qwe@email.com", "ㅋ"),
					List.of("qwe@email.com", "ㅋㅋ")
			);
			RuntimeException exception = assertThrows(RuntimeException.class, () -> Problem6.solution(forms));
			System.out.println(exception.getMessage());
		}
	}

	@Nested
	class Problem7Test {
		/**
		 * test case 2 ~ 5 는 slack 테스트-케이스 채널에서 공유받았습니다.
		 */
		@Test
		void case1() {
			String user = "mrko";
			List<List<String>> friends = List.of(
					List.of("donut", "andole"),
					List.of("donut", "jun"),
					List.of("donut", "mrko"),
					List.of("shakevan", "andole"),
					List.of("shakevan", "jun"),
					List.of("shakevan", "mrko")
			);
			List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
			List<String> result = List.of("andole", "jun", "bedi");
			System.out.println(Problem7.solution(user, friends, visitors));
			System.out.println(result);
			assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
		}

		@Test
		void case2() {
			String user = "mrko";
			List<List<String>> friends = List.of(
					List.of("mrko", "jun"),
					List.of("donut", "jun"),
					List.of("donut", "mrko"),
					List.of("shakevan", "andole"),
					List.of("shakevan", "jun"),
					List.of("shakevan", "mrko")
			);
			List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
			List<String> result = List.of("andole", "bedi");
			assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
		}

		@Test
		void case3() {
			String user = "mrko";
			List<List<String>> friends = List.of(
					List.of("mrko", "jun"),
					List.of("donut", "jun"),
					List.of("donut", "mrko"),
					List.of("shakevan", "andole"),
					List.of("jun", "andole"),
					List.of("shakevan", "jun"),
					List.of("shakevan", "mrko")
			);
			List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
			List<String> result = List.of("andole", "bedi");
			assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
		}

		@Test
		void case4() {
			String user = "mrko";
			List<List<String>> friends = List.of(
					List.of("mrko", "jun"),
					List.of("bedi", "jun"),
					List.of("bedi", "donut"),
					List.of("donut", "jun"),
					List.of("donut", "mrko"),
					List.of("shakevan", "andole"),
					List.of("jun", "andole"),
					List.of("shakevan", "jun"),
					List.of("shakevan", "mrko")
			);
			List<String> visitors = List.of("donut", "shakevan");
			List<String> result = List.of("andole", "bedi");
			assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
		}
	}

	@Test
	void case5() {
		String user = "hello";
		List<List<String>> friends = List.of(
				List.of("andole", "jun"),
				List.of("andole", "bedi"),
				List.of("jun", "shakevan"),
				List.of("jun", "kane"),
				List.of("jun", "sam"),
				List.of("bedi", "shakevan"),
				List.of("bedi", "anne"),
				List.of("bedi", "sam"),
				List.of("anne", "mrko")
		);
		List<String> visitors = List.of("donut", "anne", "mrko", "mrko", "sam");
		List<String> result = List.of("mrko", "anne", "donut", "sam");
		assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
	}

	@Test
	@DisplayName("친구 추천이 존재하지 않는 유저")
	void case6() {
		String user = "hello";
		List<List<String>> friends = List.of(
				List.of("andole", "jun"),
				List.of("andole", "bedi"),
				List.of("jun", "shakevan"),
				List.of("jun", "kane"),
				List.of("jun", "sam"),
				List.of("bedi", "shakevan"),
				List.of("bedi", "anne"),
				List.of("bedi", "sam"),
				List.of("anne", "mrko")
		);
		List<String> visitors = List.of();
		List<String> result = List.of();
		assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
	}
}
