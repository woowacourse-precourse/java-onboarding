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
		user.addFriend(new User("shakevan"));
		user.addFriend(new User("donut"));

		List<User> others = List.of(
			new User("shakevan"),
			new User("donut")
		);

		for (User other : others) {
			assertThat(user.isFriendWith(other)).isTrue();
		}
	}

	@DisplayName("특정 유저의 친구 목록을 구할 수 있다.")
	@Test
	void 특정_유저_친구_목록() {
		User user = new User("mrko");
		user.addFriend(new User("shakevan"));
		user.addFriend(new User("donut"));

		Set<User> friends = user.getFriends();
		List<User> expected = List.of(
			new User("shakevan"),
			new User("donut")
		);
		assertThat(friends).containsAll(expected);
	}

	@DisplayName("함께 아는 친구의 수를 구할 수 있다.")
	@Test
	void 함께_아는_친구_수() {
		User userA = new User("mrko");
		userA.addFriend(new User("shakevan"));
		userA.addFriend(new User("donut"));

		User userB = new User("jun");
		userB.addFriend(new User("shakevan"));
		userB.addFriend(new User("donut"));

		int numberOfFriends
			= userA.getNumberOfFriendsKnowWith(userB);

		assertThat(numberOfFriends).isEqualTo(2);
	}
}
