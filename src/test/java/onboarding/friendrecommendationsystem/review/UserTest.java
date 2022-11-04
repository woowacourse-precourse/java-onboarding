package onboarding.friendrecommendationsystem.review;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class UserTest {

	@DisplayName("아이디 길이 검증")
	@Test
	void 아이디_길이_검증() {
		assertThatThrownBy(
			() -> new User("")
		).isInstanceOf(IllegalArgumentException.class);

		assertThat(new User("mrko")).isNotNull();
	}

	@DisplayName("아이디 형식 검증")
	@Test
	void 아이디_형식_검증() {
		for (String id : List.of("MRKO", "Mrko")) {
			assertThatThrownBy(
				() -> new User(id)
			).isInstanceOf(IllegalArgumentException.class);
		}
		assertThat(new User("mrko")).isNotNull();
	}

	@DisplayName("다른 유저의 아이디를 통해 특정 유저의 친구인지 판단할 수 있다.")
	@Test
	void 특정_유저_친구_판단() {
		User user = new User("mrko");
		user.add("shakevan");
		user.add("donut");

		List<String> userIds = List.of("shakevan", "donut");

		for (String userId : userIds) {
			assertThat(user.isFriendWith(userId)).isTrue();
		}
	}

	@DisplayName("특정 유저의 친구 목록을 구할 수 있다.")
	@Test
	void 특정_유저_친구_목록() {
		User user = new User("mrko");
		user.add("shakevan");
		user.add("donut");

		Set<User> friends = user.getFriends();
		List<User> expected = List.of(
			new User("shakevan"),
			new User("donut")
		);
		assertThat(friends).containsAll(expected);
	}
}
