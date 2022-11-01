package onboarding.problem7;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class UserTest {
@Test
public void 유저_유효성_테스트() {
    //given
	String correctUserId = "mrko";
	String wrongUserId1 = "mrKo";
	String wrongUserId2 = "mrko1";
	String wrongUserId3 = "";
	String wrongUserId4 = "mrkomrkomrkomrkomrkomrkomrkomrm";

	User user = new User(correctUserId);
	assertThatThrownBy(() -> new User(wrongUserId1))
		.isInstanceOf(IllegalArgumentException.class);
	assertThatThrownBy(() -> new User(wrongUserId2))
		.isInstanceOf(IllegalArgumentException.class);
	assertThatThrownBy(() -> new User(wrongUserId3))
		.isInstanceOf(IllegalArgumentException.class);
	assertThatThrownBy(() -> new User(wrongUserId4))
		.isInstanceOf(IllegalArgumentException.class);
}
}
