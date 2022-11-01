package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NetworkTest {

	@Test
	@DisplayName("친구를 점수 순으로 최대 5명 추천한다")
	void recommend_friends() {
		List<List<String>> relationships = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("donut", "aaa"),
			List.of("donut", "bbb"),
			List.of("donut", "ccc"),
			List.of("shakevan", "ccc"),
			List.of("shakevan", "bbb"),
			List.of("shakevan", "aaa"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		Network network = new Network(relationships, visitors);

		assertThat(network.recommendFriendsFor("mrko")).containsExactly("andole", "jun", "bedi");
	}
}
