package onboarding.problem7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FriendsTest {

	@Test
	void add_User() {
		Friends friends = new Friends();
		friends.add(new User("abb"));
		Assertions.assertThat(friends.contains(new User("abb"))).isTrue();
	}
}
