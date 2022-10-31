package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class Problem7Test {

	@Test
	void 올바른_user_입력() {
		boolean result = true;
		assertThat(Problem7.InputValidator.isRightUserInput("hello")).isEqualTo(result);
		assertThat(Problem7.InputValidator.isRightUserInput("me")).isEqualTo(result);
		assertThat(Problem7.InputValidator.isRightUserInput("this")).isEqualTo(result);
		assertThat(Problem7.InputValidator.isRightUserInput("lalala")).isEqualTo(result);
	}

	@Test
	void 잘못된_user_입력() {
		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightUserInput("한글"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightUserInput("ABCD"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightUserInput("ABAdd"));

		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightUserInput(""));

		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightUserInput("qwertyuiopasdfghjklzxcvbnmqwertyuiop"));
	}

	@Test
	void 올바른_friends_입력() {
		boolean result = true;
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		assertThat(Problem7.InputValidator.isRightFriendsInput(friends)).isEqualTo(result);

		friends = List.of(
			List.of("donut", "andole"),
			List.of("skdkasd", "asd"),
			List.of("asd", "vdsaw")
		);
		assertThat(Problem7.InputValidator.isRightFriendsInput(friends)).isEqualTo(result);
	}

	@Test
	void 잘못된_friends_입력() {
		boolean result = true;
		List<List<String>> friends = List.of(
			List.of("232", "andole")
		);
		List<List<String>> finalFriends = friends;
		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightFriendsInput(finalFriends));

		friends = List.of(
			List.of("한글", "andole"),
			List.of("sdsd", "andole")
		);
		List<List<String>> finalFriends1 = friends;
		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightFriendsInput(finalFriends1));

		friends = List.of();
		List<List<String>> finalFriends2 = friends;
		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightFriendsInput(finalFriends2));

		friends = List.of(
			List.of("det", "andole", "abc")
		);
		List<List<String>> finalFriends3 = friends;
		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isRightFriendsInput(finalFriends3));
	}
}