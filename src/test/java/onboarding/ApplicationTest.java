package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
	@Nested
	class Problem1Test {
		@Test
		void case1() {
			List<Integer> pobi = List.of(97, 98);
			List<Integer> crong = List.of(197, 198);
			int result = 0;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}
		
		@Test
		void case2() {
			List<Integer> pobi = List.of(131, 132);
			List<Integer> crong = List.of(211, 212);
			int result = 1;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}
		
		@Test
		void case3() {
			List<Integer> pobi = List.of(99, 102);
			List<Integer> crong = List.of(211, 212);
			int result = -1;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}
		
		@Test
		void case4() {
			List<Integer> pobi = List.of(412, 413);
			List<Integer> crong = List.of(200, 201);
			int result = -1;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}
		
		@Test
		void case5() {
			List<Integer> pobi = List.of(99, 103);
			List<Integer> crong = List.of(211, 212);
			int result = -1;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}
		
		@Test
		void case6() {
			List<Integer> pobi = List.of(399, 400);
			List<Integer> crong = List.of(211, 212);
			int result = 1;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}
		
		@Test
		void case7() {
			List<Integer> pobi = List.of(211, 212);
			List<Integer> crong = List.of(400, 401);
			int result = -1;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}
		
		@Test
		void case8() {
			List<Integer> pobi = List.of(99, 100);
			List<Integer> crong = List.of(-1, 0);
			int result = -1;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("왼쪽은 홀수, 오른쪽은 짝수")
		public void cas9() throws Exception {
			List<Integer> pobi = List.of(100, 101);
			List<Integer> crong = List.of(1, 2);
			int result = -1;
			assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
		}
		
		
	}
	
	@Nested
	class Problem2Test {
		@Test
		void case1() {
			String cryptogram = "browoanoommnaon";
			String result = "brown";
			assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
		}
		
		@Test
		void case2() {
			String cryptogram = "zyelleyz";
			String result = "";
			assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("공백입력시")
		void case3() {
			String cryptogram = "";
			String result = "";
			assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("공백이되는 입력시")
		void case4() {
			String cryptogram = "zyellleyz";
			String result = "";
			assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("3개 없애기")
		void case5() {
			String cryptogram = "zyalllelyz";
			String result = "zyaelyz";
			assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("한번에 다없애기")
		void case6() {
			String cryptogram = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
			String result = "";
			assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("두번에 다없애기")
		void case7() {
			String cryptogram = "aaaabb";
			String result = "";
			assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("abababa무한루프")
		void case8() {
			String cryptogram = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
			String result = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
			assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("애매한 케이스")
		void case9() {
			String cryptogram = "abbaa";
			String result = "a";
			assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
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
		@DisplayName("3자릿수")
		void case3() {
			int number = 333;
			int result = 228;
			assertThat(Problem3.solution(number)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("1 입력")
		void case4() {
			int number = 1;
			int result = 0;
			assertThat(Problem3.solution(number)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("2 입력")
		void case5() {
			int number = 2;
			int result = 0;
			assertThat(Problem3.solution(number)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("3 입력")
		void case6() {
			int number = 3;
			int result = 1;
			assertThat(Problem3.solution(number)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("10000 입력")
		void case7() {
			int number = 10000;
			int result = 12000;
			assertThat(Problem3.solution(number)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("9999 입력")
		void case8() {
			int number = 9999;
			int result = 12000;
			assertThat(Problem3.solution(number)).isEqualTo(result);
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
		void case2() {
			String word = "ABCDEFGHIJKLMNOP@  #qrstuvwxyz";
			String result = "ZYXWVUTSRQPONMLK@  #jihgfedcba";
			assertThat(Problem4.solution(word)).isEqualTo(result);
		}
		
		@Test
		void case3() {
			String word = "";
			String result = "";
			assertThat(Problem4.solution(word)).isEqualTo(result);
		}
		
		@Test
		void case4() {
			String word = "123123123";
			String result = "123123123";
			assertThat(Problem4.solution(word)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("[a-z]")
		void case5() {
			String word = "abcdefghijklmnopqrstuvwxyz";
			String result = "zyxwvutsrqponmlkjihgfedcba";
			assertThat(Problem4.solution(word)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("기호사용")
		void case6() {
			String word = "abcdefghijklmnopqrstuvwxyz !@#!#  ";
			String result = "zyxwvutsrqponmlkjihgfedcba !@#!#  ";
			assertThat(Problem4.solution(word)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("헬로월드 반대")
		void case7() {
			String word = "Svool, Dliow! 123";
			String result = "Hello, World! 123";
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
		
		@Test
		void case3() {
			int money = 0;
			List<Integer> result = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0);
			assertThat(Problem5.solution(money)).isEqualTo(result);
		}
		
		@Test
		void case4() {
			int money = 66_661;
			List<Integer> result = List.of(1, 1, 1, 1, 1, 1, 1, 1, 1);
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
					List.of("nowm@email.com", "이제엠"),
					List.of("jason1@email.com", "제이슨1")
			);
			List<String> result = List.of("jason1@email.com", "jason@email.com", "jm@email.com", "mj@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}
		
		@Test
		void case2() {
			List<List<String>> forms = List.of(
					List.of("a@email.com", "제이엠"),
					List.of("abaaaa@email.com", "제이슨"),
					List.of("abbb@email.com", "워니이슨"),
					List.of("bcbb@email.com", "엠제이슨"),
					List.of("bbb@email.com", "이제엠이")
			);
			List<String> result = List.of("a@email.com", "abaaaa@email.com", "abbb@email.com", "bcbb@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}
		
		@Test
		void case3() {
			List<List<String>> forms = List.of(
					List.of("aaa@email.com", "한글이름"),
					List.of("잘못된이메일@emai.com", "한글이름"),
					List.of("bbb@email.com", "wrongName"),
					List.of("ccc@email.com", "맞는이름")
			);
			
			List<String> result = List.of("aaa@email.com", "ccc@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}
		
		@Test
		void case4() {
			List<List<String>> forms = List.of(
					List.of("onepiece@email.com", "원피수"),
					List.of("onepisu@email.com", "원피수"),
					List.of("onepisu@email.com", "원피수2"),
					List.of("suonepi@email.com", "수원")
			);
			
			List<String> result = List.of("onepiece@email.com", "onepisu@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}
		
		@Test
		void case5() {
			List<List<String>> forms = List.of(
					List.of("kim@email.com", "김ㅡ이"),
					List.of("nam@email.com", "ㅡ이야"),
					List.of("choi@email.com", "최강"),
					List.of("lee@email.com", "강합니다"),
					List.of("jun@email.com", "왜ㅇㅡ이야")
			);
			List<String> result = List.of("jun@email.com", "kim@email.com", "nam@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}
	}
	
	@Nested
	class Problem7Test {
		@Test
		@DisplayName("기본")
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
			assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("jun이 더 높을 경우")
		void case2() {
			String user = "mrko";
			List<List<String>> friends = List.of(
					List.of("donut", "andole"),
					List.of("donut", "jun"),
					List.of("donut", "mrko"),
					List.of("shakevan", "andole"),
					List.of("shakevan", "jun"),
					List.of("shakevan", "mrko")
			);
			List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "jun");
			List<String> result = List.of("jun", "andole", "bedi");
			assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("이름 정렬 확인")
		void case3() {
			String user = "mrko";
			List<List<String>> friends = List.of(
					List.of("donut", "andole"),
					List.of("donut", "jun"),
					List.of("donut", "mrko"),
					List.of("donut", "abc"),
					List.of("donut", "aaa"),
					List.of("donut", "aaaaa"),
					List.of("shakevan", "andole"),
					List.of("shakevan", "jun"),
					List.of("shakevan", "mrko"),
					List.of("shakevan", "abc"),
					List.of("shakevan", "aaa")
			);
			List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
			List<String> result = List.of("aaa", "abc", "andole", "jun", "aaaaa");
			assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
		}
		
		@Test
		@DisplayName("친구의 친구가 내 친구일 경우")
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
		void case6() {
			String user = "andole";
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
			List<String> result = List.of("sam", "shakevan", "anne", "kane", "mrko");
			assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
		}
	}
}
