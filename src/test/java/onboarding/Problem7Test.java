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

	@DisplayName("모든 친구 이름에 대해 '추천친구 점수' 0으로 초기화")
	@Test
	void initializeRecommendationScoresTest() {
		// given : 친구관계 그래프가 주어졌을 때
		List<List<String>> friends = List.of(
				List.of("a", "b"),
				List.of("b", "c"),
				List.of("heap", "c"),
				List.of("pork", "fork")
		);
		Problem7.makeFriendRelationGraph(friends);

		// when : 모든 친구에 대해 추천점수를 0점으로 초기화
		Problem7.initRecommendationScores();

		// then : 모든 value 값이 0 인지 확인하고 map size 가 친구관계 그래프 size 와 같은지 확인
		Map<String, Integer> result = Problem7.recommendationScores;
		final int expectedSize = Problem7.friendRelationGraph.size();
		final int expectedValue = 0;

		assertThat(result.size()).isEqualTo(expectedSize);
		result.values()
				.forEach(score -> assertThat(score).isEqualTo(expectedValue));
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
}