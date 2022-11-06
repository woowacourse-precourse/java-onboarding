package onboarding.friendrecommendationsystem.review;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class UsersTest {

	static List<List<String>> friends = List.of(
		List.of("donut", "andole"),
		List.of("donut", "jun"),
		List.of("donut", "mrko"),
		List.of("shakevan", "andole"),
		List.of("shakevan", "jun"),
		List.of("shakevan", "mrko")
	);

	@DisplayName("유저 친구 목록 생성 테스트")
	@Test
	void 친구_목록_생성() {
		Users users = new Users();

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

		for (User user : users) {
			List<String> friends = user.getFriends()
				.stream()
				.map(User::getId)
				.collect(Collectors.toList());
			System.out.print(user.getId() + ":");
			System.out.println(String.join(",", friends));
		}
	}
}
