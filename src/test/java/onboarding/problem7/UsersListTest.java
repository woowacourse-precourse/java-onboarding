package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsersListTest {

	User userMike;
	User userJack;

	@BeforeEach
	void setUser() {
		userMike = new User("mike");
		userJack = new User("jack");
	}

	@Test
	void user_add_friend() {
		UsersList usersList = new UsersList();
		UserID userIDMike = new UserID("mike");
		usersList.add(List.of("mike", "jack"));
		assertThat(usersList.contains(userIDMike)).isTrue();
	}

	@Test
	void get_second_list() {
		UsersList usersList = new UsersList();
		usersList.add(List.of("mike", "jack"));
		usersList.add(List.of("kim", "jack"));
		assertThat(usersList.getSecondFriends("mike")).isEqualTo(List.of("kim"));
	}
}
