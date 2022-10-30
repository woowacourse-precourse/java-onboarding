package onboarding.friendrecommendationsystem;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FriendRecommendationSystemTest {

	static String user = "mrko";

	static List<List<String>> friends = List.of(
		List.of("donut", "andole"),
		List.of("donut", "jun"),
		List.of("donut", "mrko"),
		List.of("shakevan", "andole"),
		List.of("shakevan", "jun"),
		List.of("shakevan", "mrko")
	);

	static List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

	@DisplayName("특정 유저의 친구 목록 반환 테스트")
	@Test
	void 친구_목록_반환() {
		FriendRecommendationSystem system
			= new FriendRecommendationSystem(user, friends, visitors);
		List<String> friends = system.getFriendsOf("mrko");
		assertThat(friends).isEqualTo(List.of("donut", "shakevan"));
	}
}
