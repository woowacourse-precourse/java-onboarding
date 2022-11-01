package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Problem7Test {
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

}