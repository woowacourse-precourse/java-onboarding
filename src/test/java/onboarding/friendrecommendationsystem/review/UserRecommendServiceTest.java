package onboarding.friendrecommendationsystem.review;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserRecommendServiceTest {

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

	static Users users;

	@BeforeAll
	static void setUp() {
		users = new Users();

		for (List<String> friend : friends) {
			String userAId = friend.get(0);
			String userBId = friend.get(1);

			users.addUser(new User(userAId));
			users.addUser(new User(userBId));

			User userA = users.getUserById(userAId);
			User userB = users.getUserById(userBId);

			userA.addFriend(userB);
			userB.addFriend(userA);
		}
	}


	@DisplayName("친구 추천 규칙에 따른 추천 친구 목록 반환")
	@Test
	void 추천_친구() {
		UserRecommendService recommendService
			= new UserRecommendService(users);

		List<String> friends = recommendService.recommendFriends(user, visitors);
		List<String> result = List.of("andole", "jun", "bedi");

		assertThat(friends).isEqualTo(result);
	}
}
