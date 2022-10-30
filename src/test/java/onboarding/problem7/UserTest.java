package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

	User userMike;
	User userJack;
	@BeforeEach
	void setUser(){
		userMike = new User("mike");
		userJack = new User("jack");
	}

	@Test
	void add_friend_and_is_Friend() {

		userMike.addFriend(userJack);
		assertThat(userMike.isFriends(userJack)).isTrue();
	}

	@Test
	void second_friend(){
		User userJerry = new User("jerry");
		userMike.addFriend(userJerry);
		userJerry.addFriend(userMike);
		userJack.addFriend(userJerry);
		userJerry.addFriend(userJack);
		assertThat(userMike.isSecondFriend(userJack)).isTrue();
	}
}
