package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsersListTest {

	UserID userMike;
	UserID userJack;

	@BeforeEach
	void setUser() {
		userMike = new UserID("mike");
		userJack = new UserID("jack");
	}

	@Test
	void user_add_friend() {
		UsersList usersList = new UsersList();
		UserID userIDMike = new UserID("mike");
		usersList.add(List.of("mike", "jack"));
		assertThat(usersList.contains(userIDMike)).isTrue();
	}

	@Test
	void get_friend_of_friend(){
		UsersList usersList = new UsersList();
		usersList.add(List.of("mike", "jack"));
		usersList.add(List.of("jerry", "jack"));
		assertThat(usersList.getFriendOfFriend("mike")).isEqualTo(List.of("jerry"));
	}

}
