package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Problem7Test {
	@BeforeEach
	void resetStaticVariables() {
		Problem7.friendRelationGraph.clear();
		Problem7.recommendationScores.clear();
	}

	@DisplayName("친구관계 그래프 생성 테스트")
	@Test
	void makeFriendRelationGraphTest() {
		// given : friends 가 주어진다.
		List<List<String>> friends = List.of(
				List.of("a", "b"),
				List.of("b", "c"),
				List.of("heap", "c"),
				List.of("pork", "fork")
		);

		// when : 위 friends 로 친구관계 그래프를 생성할 때
		Problem7.makeFriendRelationGraph(friends);

		// then : 각각의 관계가 잘 나타나야 한다.
		Map<String, List<String>> result = Problem7.friendRelationGraph;
		final Map<String, List<String>> expected = new HashMap<>() {{
			put("a", List.of("b"));
			put("b", List.of("a", "c"));
			put("c", List.of("b", "heap"));
			put("heap", List.of("c"));
			put("pork", List.of("fork"));
			put("fork", List.of("pork"));
		}};

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("user 의 친구목록을 구하는 테스트")
	@Test
	void findFriendsOfUserTest() {
		// given : 친구관계 그래프와 user 의 이름이 주어졌을 때
		List<List<String>> friends = List.of(
				List.of("a", "b"),
				List.of("b", "c"),
				List.of("heap", "c"),
				List.of("pork", "fork")
		);
		Problem7.makeFriendRelationGraph(friends);
		final String user = "c";

		// when : user 의 직접적인 친구들을 찾는다
		Set<String> friendsOfUser = Problem7.findFriendsOfUser(user);

		// then : user 의 직접적인 친구들은 'b', 'heap' 2명이다.
		final Set<String> expected = new HashSet<>(List.of("b", "heap"));
		assertThat(friendsOfUser).isEqualTo(expected);
	}

	@DisplayName("user 의 친구들의 친구들에게 점수 10점을 부과하는 테스트")
	@Test
	void give10ScoreToFriendsKnowWithUserTest() {
		// given : 친구관계 그래프 생성, user 이름이 주어졌을 때
		List<List<String>> friends = List.of(
				List.of("a", "b"),
				List.of("b", "c"),
				List.of("heap", "c"),
				List.of("heap", "fork"),
				List.of("heap", "a"),
				List.of("f", "fork")
		);
		Problem7.makeFriendRelationGraph(friends); // 친구관계 그래프 생성
		final String user = "c"; // user 이름

		// when : user 친구들의 친구들에게 10점 부과
		Problem7.giveScoresToFriendsKnowWithUser(user);

		// then : 점수가 제대로 부과됐는지 확인
		// 친구관계 그래프 기준으로 user 의 친구들의 친구들에게 10점이 부여된다.
		Map<String, Integer> result = Problem7.recommendationScores;
		final Map<String, Integer> expected = new HashMap<>() {{
			put("a", 20);
			put("c", 20);
			put("fork", 10);
		}};

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("user 의 timeline 에 방문한 모든 사람들에게 1점 부여하는 기능 테스트")
	@Test
	void give1ScoreToVisitingUserTimeline() {
		// given : 친구관계 그래프 생성, 방문한 이름 목록 이 주어졌을 때
		List<List<String>> friends = List.of(
				List.of("a", "b"),
				List.of("b", "c"),
				List.of("heap", "c"),
				List.of("heap", "fork"),
				List.of("heap", "a"),
				List.of("f", "fork")
		);
		Problem7.makeFriendRelationGraph(friends); // 친구관계 그래프 생성
		final List<String> visitors = List.of("new", "spy", "a", "a", "f", "heap", "heap", "c");

		// when : user timeline 에 방문한 친구들에게 1점 부과
		Problem7.giveScoresToFriendsWhoVisitUserTimeline(visitors);

		// then : 방문한 사람들에게 1점 부여된다
		Map<String, Integer> result = Problem7.recommendationScores;
		final Map<String, Integer> expected = new HashMap<>() {{
			put("a", 2);
			put("c", 1); // 일단 1점씩 모두 부여한다.
			put("f", 1);
			put("heap", 2);
			put("new", 1);
			put("spy", 1);
		}};

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("user 의 직접적인 친구 목록 Set 구하는 기능 테스트")
	@Test
	void getDirectFriendsOfUserTest() {
		// given : 친구관계 그래프와 user 이름이 주어졌을 때
		List<List<String>> friends = List.of(
				List.of("a", "b"),
				List.of("b", "c"),
				List.of("heap", "c"),
				List.of("heap", "fork"),
				List.of("heap", "a"),
				List.of("f", "fork")
		);
		Problem7.makeFriendRelationGraph(friends); // 친구관계 그래프 생성
		final String user = "c";

		// when : user 와 친구인 사람들 이름 Set 구한다
		Problem7.getDirectFriendsOfUser(user);

		// then : user 와 직접적인 친구는 'b'와 'heap' 이 존재한다.
		Set<String> result = Problem7.directFriendsOfUserSet;
		final Set<String> expected = new HashSet<>(List.of("b", "heap"));

		assertThat(result).isEqualTo(expected);
	}
}