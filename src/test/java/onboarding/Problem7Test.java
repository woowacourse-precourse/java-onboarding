package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
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

	@Test
	void 올바른_visitors_입력() {
		boolean result = true;
		List<String> visitors = List.of("donut", "bedi", "jenny", "lily", "mrko");
		assertThat(Problem7.InputValidator.isVisitorsInput(visitors)).isEqualTo(result);

		visitors = List.of("hello", "me", "lala");
		assertThat(Problem7.InputValidator.isVisitorsInput(visitors)).isEqualTo(result);
	}

	@Test
	void 잘못된_visitors_입력() {
		boolean result = true;
		List<String> visitors = List.of("donut", "DKS", "lily", "mrko");
		List<String> finalVisitors1 = visitors;
		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isVisitorsInput(finalVisitors1));

		visitors = List.of("donut", "DKS", "lily", "mrko");
		List<String> finalVisitors2 = visitors;
		assertThrows(IllegalArgumentException.class, () ->
			Problem7.InputValidator.isVisitorsInput(finalVisitors2));
	}

	@Test
	void 함께_아는_친구_점수_구하기() {
		String user = "donut";
		HashMap<String, List<String>> relations = new HashMap<>();
		relations.put("donut", List.of("shakevan", "anna"));
		relations.put("shakevan", List.of("lily", "anna"));
		relations.put("anna", List.of("lily", "tom"));

		HashMap<String, Integer> result = new HashMap<>();
		result.put("lily", 20);
		result.put("anna", 10);
		result.put("tom", 10);
		assertThat(Problem7.getFriendOfFriendScores(relations, user)).isEqualTo(result);
	}

	@Test
	void 타임_라인_방문_점수_구하기() {
		String user = "donut";
		List<String> relations = List.of("lala", "meme", "anna", "lala");

		HashMap<String, Integer> result = new HashMap<>();
		result.put("lala", 2);
		result.put("meme", 1);
		result.put("anna", 1);
		assertThat(Problem7.getVisitorsScores(relations)).isEqualTo(result);
	}

	@Test
	void 올바른_입출력() {
		String user = "tom";
		List<List<String>> friends = List.of(
			List.of("tom", "amy"),
			List.of("jenny", "amy"),
			List.of("donut", "amy"),
			List.of("donut", "shakevan"),
			List.of("shakevan", "tom"),
			List.of("shakevan", "bedi")
		);
		List<String> visitors = List.of("donut", "mrko", "peter", "lily");
		List<String> result = List.of("donut", "bedi", "jenny", "lily", "mrko");
		assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);

		user = "hello";
		friends = List.of(
			List.of("amy", "jun"),
			List.of("amy", "lola"),
			List.of("bedi", "shakevan"),
			List.of("bedi", "anne"),
			List.of("bedi", "sam"),
			List.of("anne", "mrko")
		);
		visitors = List.of("donut", "anne", "mrko", "sam", "sam");
		result = List.of("sam", "anne", "donut", "mrko");
		assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);

		user = "hello";
		friends = List.of(
			List.of("andole", "jun"),
			List.of("andole", "bedi"),
			List.of("tom", "shakevan"),
			List.of("tom", "anne"),
			List.of("anne", "mrko")
		);
		visitors = List.of();
		result = List.of();
		assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);

		user = "hello";
		friends = List.of(
			List.of("amy", "jun"),
			List.of("amy", "bedi"),
			List.of("lily", "shakevan"),
			List.of("lily", "anne"),
			List.of("lily", "sam"),
			List.of("anne", "mrko")
		);
		visitors = List.of("donut", "anne", "mrko", "amy");
		result = List.of("amy", "anne", "donut", "mrko");
		assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);

	}

}
