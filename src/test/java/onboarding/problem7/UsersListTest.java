package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsersListTest {

	UserID userMike;
	UserID userJack;
	UsersList usersList;

	@BeforeEach
	void setUser() {
		userMike = new UserID("mike");
		userJack = new UserID("jack");
		usersList = new UsersList();
		usersList.add(List.of("mike", "jack"));
		usersList.add(List.of("jerry", "jack"));
	}

	@Test
	void user_add_friend() {
		assertThat(usersList.contains(userMike)).isTrue();
	}

	@Test
	void get_friend_of_friend(){
		assertThat(usersList.getFriendOfFriend("mike")).isEqualTo(List.of("jerry"));
	}

	@Test
	void remove_fiend(){
		assertThat(usersList.removeFriend("mike", List.of("jack", "java"))).isEqualTo(List.of("java"));
	}

}
