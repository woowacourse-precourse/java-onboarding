package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NetworkTest {

	@Test
	@DisplayName("친구를 점수순으로 최대 5명 추천한다")
	void recommend_friends_maximum_five_score_ordered() {
		String user = "mrko";
		List<List<String>> relationships = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		List<String> result = List.of("andole", "jun", "bedi");
		Network network = new Network(relationships, visitors);

		assertThat(network.recommendFriendsFor(user)).isEqualTo(result);
	}

	@Test
	@DisplayName("이미 친구라면 추천받지 않는다")
	void dont_recommend_friends_with_relationships() {
		List<List<String>> relationships = List.of(
			List.of("a", "b"),
			List.of("a", "c"),
			List.of("b", "c"),
			List.of("a", "d")
		);
		Network network = new Network(relationships, Collections.emptyList());

		assertThat(network.recommendFriendsFor("d")).doesNotContain("a");
	}
}
