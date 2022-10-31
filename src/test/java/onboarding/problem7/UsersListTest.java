package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsersListTest {

	UserID userMike;
	UserID userJack;
	UserID userJerry;
	UsersList usersList;

	@BeforeEach
	void setUser() {
		userMike = new UserID("mike");
		userJack = new UserID("jack");
		userJerry = new UserID("jerry");
		usersList = new UsersList();
		usersList.add(List.of(userMike, userJack));
		usersList.add(List.of(userJerry, userJack));
	}

	@Test
	void user_add_friend() {
		assertThat(usersList.contains(userMike)).isTrue();
	}

	@Test
	void get_friend_of_friend() {
		assertThat(usersList.getFriendOfFriend(userMike)).isEqualTo(List.of("jerry"));
	}

	@Test
	void remove_fiend() {
		assertThat(usersList.removeFriend(userMike, List.of("jack", "java")))
			.isEqualTo(List.of("java"));
	}
}
