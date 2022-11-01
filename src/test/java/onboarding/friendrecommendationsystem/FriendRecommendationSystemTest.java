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

	static FriendRecommendationSystem system
		= new FriendRecommendationSystem(user, friends, visitors);

	@DisplayName("사용자와 함께 아는 친구의 수 반환 테스트")
	@Test
	void 함계_아는_친구_수() {
		assertThat(
			system.getNumberOfFriendsKnowWith("andole")
		).isEqualTo(2);
		assertThat(
			system.getNumberOfFriendsKnowWith("shakevan")
		).isEqualTo(0);
		assertThat(
			system.getNumberOfFriendsKnowWith("mrko")
		).isEqualTo(0);
	}

	@DisplayName("추천 친구 목록 반환 테스트")
	@Test
	void 추천_친구_목록() {
		List<String> result = system.getRecommendedUsers();
		assertThat(result).isEqualTo(List.of("andole", "jun", "bedi"));
	}
}
