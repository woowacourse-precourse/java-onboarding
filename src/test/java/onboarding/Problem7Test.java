package onboarding;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Problem7Test {

	@Test
	@DisplayName("유저 아이디 길이 1보다 작을 때")
	void user_길이체크1(){
		String user = "";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

	@Test
	@DisplayName("유저 아이디 길이 30보다 클 때 ")
	void user_길이체크2(){
		String user = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

	@Test
	@DisplayName("유저 아이디 소문자 아닐 때")
	void user_체크3(){
		String user = "bbaaabbbAAAAAAA";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

	@Test
	@DisplayName("유저 아이디가 영어로 구성되어있지 않을때")
	void user_체크4(){
		String user = "mr..ko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

	@Test
	@DisplayName("친구관계 리스트 길이 0 일 때")
	void friends_체크1(){
		String user = "mrko";
		List<List<String>> friends = List.of(

		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

	@Test
	@DisplayName("친구관계 리스트 내부 관계 길이가 2가 아닐 때 (2보다 작음)")
	void friends_체크2(){
		String user = "mrko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

	@Test
	@DisplayName("친구관계 리스트 내부 관계 길이가 2가 아닐 때 (2보다 큼)")
	void friends_체크3(){
		String user = "mrko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun", "mrko"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}


	@Test
	@DisplayName("친구관계 리스트의 닉네임 길이가 1보다 작을 때")
	void friends_체크4(){
		String user = "mrko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", ""),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

	@Test
	@DisplayName("친구관계 리스트의 닉네임 길이가 30초과 일 때")
	void friends_체크5(){
		String user = "mrko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

	@Test
	@DisplayName("친구관계 리스트의 닉네임 중 대문자가 있을 때")
	void friends_체크6(){
		String user = "mrko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "AABBABA"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

	@Test
	@DisplayName("친구관계 리스트의 닉네임 중 영어가 아닌게 있을 때")
	void friends_체크7(){
		String user = "mrko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shak,/.123evan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

	@Test
	@DisplayName("방문자 닉네임 중 길이가 1 미만이 있을 때")
	void visitors_체크1(){
		String user = "mrko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

	@Test
	@DisplayName("방문자 닉네임 중 길이가 30 초과가 있을 때")
	void visitors_체크2(){
		String user = "mrko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donutasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasfasdfasdf", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

	@Test
	@DisplayName("방문자 닉네임 중 대문자가 있을 때")
	void visitors_체크3(){
		String user = "mrko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "ABAB", "bedi", "shakevan");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

	@Test
	@DisplayName("방문자 닉네임 중 영어가 아닌 것이 있을 때")
	void visitors_체크4(){
		String user = "mrko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "do,./nut", "bedi", "shake123van");
		assertThrows(IllegalArgumentException.class,
			() -> Problem7.solution((user), friends, visitors));
	}

}