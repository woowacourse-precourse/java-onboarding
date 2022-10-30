package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FriendsTest {

	@Test
	void add_User() {
		Friends friends = new Friends();
		friends.add(new UserID("abb"));
		assertThat(friends.contains(new UserID("abb"))).isTrue();

	}

}
