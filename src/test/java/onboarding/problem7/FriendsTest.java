package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FriendsTest {

	@Test
	void add_UserID() {
		Friends friends = new Friends();
		friends.add(new UserID("abb"));
		assertThat(friends.isFriend(new UserID("abb"))).isTrue();
	}

}
