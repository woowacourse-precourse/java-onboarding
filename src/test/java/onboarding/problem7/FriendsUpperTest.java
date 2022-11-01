package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FriendsUpperTest {

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
		FriendsUpper friends = new FriendsUpper(relationships, visitors);

		assertThat(friends.getKnownUsers()).contains("donut", "mrko", "bedi", "shakevan", "jun", "andole");
	}
}
