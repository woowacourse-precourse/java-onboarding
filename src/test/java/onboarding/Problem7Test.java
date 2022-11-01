package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

class Problem7Test {

	@BeforeEach
	void beforeEach() {
		Problem7.userScoreHashMap.clear();
	}

	@Nested
	class IntegrationTest {
		@Test
		@DisplayName("점수와 이름으로 정렬된 상위 다섯 명의 사용자를 추천해야 한다.")
		void integrationTest1() {
			List<List<String>> friends = List.of(
				List.of("a", "b"),
				List.of("a", "c"),
				List.of("a", "d"),
				List.of("b", "h"),
				List.of("b", "f"),
				List.of("c", "f"),
				List.of("c", "g"),
				List.of("d", "g"),
				List.of("d", "i")
			);
			List<String> visitors = new ArrayList<>();
			for (int i=0; i<10; i++) {
				visitors.add("e");
			}
			for (int i=0; i<9; i++) {
				visitors.add("j");
			}
			for (int i=0; i<1; i++) {
				visitors.add("i");
			}
			String user = "a";

			List<String> solution = Problem7.solution(user, friends, visitors);
			List<String> result = List.of("f", "g", "i", "e", "h");
			assertThat(solution).isEqualTo(result);
			assertThat(Problem7.userScoreHashMap.size()).isEqualTo(6);
			assertThat(Problem7.userScoreHashMap.get("f")).isEqualTo(20);
			assertThat(Problem7.userScoreHashMap.get("g")).isEqualTo(20);
			assertThat(Problem7.userScoreHashMap.get("i")).isEqualTo(11);
			assertThat(Problem7.userScoreHashMap.get("e")).isEqualTo(10);
			assertThat(Problem7.userScoreHashMap.get("h")).isEqualTo(10);
			assertThat(Problem7.userScoreHashMap.get("j")).isEqualTo(9);
		}

		@Test
		void integrationTest2() {
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
		void integrationTest3() {
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
		void integrationTest4() {
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
		void integrationTest5() {
			String user = "andole";
			List<List<String>> friends = List.of(
				List.of("andole", "jun"),
				List.of("andole", "bedi"),
				List.of("jun", "bedi"),
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
		void integrationTest6() {
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
		void integrationTest7() {
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

			List<String> solution = Problem7.solution(user, friends, visitors);
			List<String> result = List.of("andole", "bedi");
			assertThat(solution).isEqualTo(result);
			assertThat(Problem7.userScoreHashMap.get("andole")).isEqualTo(10);
			assertThat(Problem7.userScoreHashMap.get("bedi")).isEqualTo(3);
		}
	}




	@Test
	void getFriendsHashMapTest() {
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);

		Map<String, ArrayList<String>> friendsHashMap = Problem7.getFriendsHashMap(friends);
		ArrayList<String> donutFriends = friendsHashMap.get("donut");
		ArrayList<String> andoleFriends = friendsHashMap.get("andole");
		ArrayList<String> junFriends = friendsHashMap.get("jun");
		ArrayList<String> mrkoFriends = friendsHashMap.get("mrko");
		ArrayList<String> shakevanFriends = friendsHashMap.get("shakevan");
		ArrayList<String> bediFriends = friendsHashMap.get("bedi");

		assertThat(donutFriends.size()).isEqualTo(3);
		assertTrue(donutFriends.contains("andole"));
		assertTrue(donutFriends.contains("jun"));
		assertTrue(donutFriends.contains("mrko"));
		assertThat(andoleFriends.size()).isEqualTo(2);
		assertThat(junFriends.size()).isEqualTo(2);
		assertThat(mrkoFriends.size()).isEqualTo(2);
		assertThat(shakevanFriends.size()).isEqualTo(3);
		assertThat(bediFriends).isNull();
	}

	@Test
	void addScoreToTwoHopUsersTest() {
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		String user = "mrko";
		HashMap<String, Integer> userScoreHashMap = Problem7.userScoreHashMap;

		HashMap<String, ArrayList<String>> friendsHashMap = Problem7.getFriendsHashMap(friends);
		ArrayList<String> friendsList = friendsHashMap.get(user);
		HashSet<String> excludeUser = new HashSet<>(friendsList);
		excludeUser.add(user);
		Problem7.addScoreToTwoHopUsers(friendsHashMap, friendsList, excludeUser);

		assertThat(userScoreHashMap.get("andole")).isEqualTo(20);
		assertThat(userScoreHashMap.get("jun")).isEqualTo(20);
		assertThat(userScoreHashMap.get("donut")).isNull();
		assertThat(userScoreHashMap.get("mrko")).isNull();
		assertThat(userScoreHashMap.get("shakevan")).isNull();
		assertThat(userScoreHashMap.get("bedi")).isNull();
	}

	@Test
	void setUserScoreHashMapTest() {
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		String user = "mrko";
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		HashMap<String, Integer> userScoreHashMap = Problem7.userScoreHashMap;

		HashMap<String, ArrayList<String>> friendsHashMap = Problem7.getFriendsHashMap(friends);
		Problem7.setUserScoreHashMap(user, friendsHashMap, visitors);

		assertThat(userScoreHashMap.get("jun")).isEqualTo(20);
		assertThat(userScoreHashMap.get("andole")).isEqualTo(20);
		assertThat(userScoreHashMap.get("donut")).isNull();
		assertThat(userScoreHashMap.get("mrko")).isNull();
		assertThat(userScoreHashMap.get("shakevan")).isNull();
		assertThat(userScoreHashMap.get("bedi")).isEqualTo(3);
	}
}
