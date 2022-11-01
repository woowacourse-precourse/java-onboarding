package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FriendsTest {

	@Test
	@DisplayName("친구관계에 있는지 알 수 있다")
	void check_if_two_are_friends() {
		List<List<String>> relationships = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		Friends friends = new Friends(relationships, visitors);

		assertThat(friends.isTwoFriends("mrko", "shakevan")).isTrue();
	}

	@Test
	@DisplayName("함께 아는 친구의 수를 알 수 있다")
	void count_shared_friends() {
		List<List<String>> relationships = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		Friends friends = new Friends(relationships, visitors);

		assertThat(friends.countSharedFriends("andole", "jun")).isEqualTo(2);
	}

	@Test
	@DisplayName("모든 사용자를 알 수 있다")
	void get_known_users() {
		List<List<String>> relationships = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		Friends friends = new Friends(relationships, visitors);

		assertThat(friends.getKnownUsers()).contains("donut", "mrko", "bedi", "shakevan", "jun", "andole");
	}
}
