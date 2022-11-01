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
		Friends friends = new Friends(relationships);

		assertThat(friends.isTwoFriends("mrko", "shakevan")).isTrue();
	}
}
