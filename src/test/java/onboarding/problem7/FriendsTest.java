package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FriendsTest {

	@Test
	void add_User() {
		Friends friends = new Friends();
		friends.add(new User("abb"));
		assertThat(friends.contains(new User("abb"))).isTrue();

	}

	@Test
	void is_full() {
		Friends friends = new Friends();
		assertThatThrownBy(() -> friends.isFull(10000)).hasMessage("친구가 10000명입니다. 더 이상 추가할수 없습니다.")
			.isInstanceOf(IllegalArgumentException.class);
		assertThatCode(() -> friends.isFull(9999)).doesNotThrowAnyException();
	}
}
