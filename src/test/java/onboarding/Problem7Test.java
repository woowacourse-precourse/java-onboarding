package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Problem7Test {

	@Test
	void 친구_관계_생성_확인(){
		String user = "mrko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		assertThat(new Problem7.RelationShip(friends)).isEqualTo(new Problem7.RelationShip(friends));

		Map<String, List<String>> relation = Map.of(
			"andole", List.of("donut", "shakevan"),
			"donut", List.of("andole", "jun", "mrko"),
			"shakevan", List.of("andole", "jun", "mrko"),
			"mrko", List.of("donut", "shakevan"),
			"jun", List.of("donut", "shakevan")
		);
		assertThat(new Problem7.RelationShip(friends)).isEqualTo(new Problem7.RelationShip(relation));
	}

	@Test
	void 스코어_생성_확인(){
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

		assertThat(new Problem7.UserScore(user, visitors, new Problem7.RelationShip(friends)))
			.isEqualTo(new Problem7.UserScore(user, visitors, new Problem7.RelationShip(friends)));

		Map<String, Integer> userScore = Map.of(
			"andole", 20,
			"jun", 20,
			"shakevan", 1,
			"bedi", 3,
			"donut", 1,
			"mrko", 20
		);

		assertThat(new Problem7.UserScore(user, visitors, new Problem7.RelationShip(friends)))
			.isEqualTo(new Problem7.UserScore(userScore));
	}

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
	@Test
	void 테스트케이스추가() {
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
	void 테스트케이스추가2() {
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
	void 테스트케이스추가3() {
		String user = "andole";
		List<List<String>> friends = List.of(
			List.of("andole", "jun"),
			List.of("donut", "jun"),
			List.of("donut", "shakevan"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "bedi"),
			List.of("anne", "jun")
		);
		List<String> visitors = List.of("donut", "mrko", "peter", "sam");
		List<String> result = List.of("donut", "anne", "bedi", "mrko", "peter");
		assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
	}
	@Test
	void 테스트케이스추가4() {
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

	@Test
	void 테스트케이스추가5() {
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
	void 테스트케이스추가6() {
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

	@Test
	void 테스트케이스추가7() {
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
		List<String> visitors = List.of("donut", "anne", "mrko", "sam");
		List<String> result = List.of("anne", "donut","mrko", "sam");
		assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
	}

	@Test
	void 테스트케이스추가8() {
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
	void 테스트케이스추가9() {
		String user = "andole";
		List<List<String>> friends = List.of(
			List.of("andole", "jun"),
			List.of("donut", "jun"),
			List.of("donut", "shakevan"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "bedi"),
			List.of("anne", "jun")
			);
		List<String> visitors = List.of("donut", "mrko", "peter", "sam");
		List<String> result = List.of("donut", "anne", "bedi", "mrko", "peter");
		assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
	}

	@Test
	void 테스트케이스추가10() {
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
}