package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();

		try {
			isValidUser(user);
			isValidFriends(friends);
			isValidVisitors(visitors);
		} catch (IllegalStateException exception) {
			exception.printStackTrace();
		}

		return answer;
	}

	public static void isValidUser(String user) throws IllegalStateException {
		if (!isValidIdLength(user))
			throw new IllegalStateException("user의 길이가 올바르지 않습니다.");
		if (!isContainUpperClass(user))
			throw new IllegalStateException("user의 아이디에 대문자가 있습니다.");
	}

	public static void isValidFriends(List<List<String>> friends) throws IllegalStateException {
		if (friends.size() < 1 || friends.size() > 10000)
			throw new IllegalStateException("friends의 길이가 올바르지 않습니다.");
		if (friends.stream().anyMatch(friend -> friend.size() != 2))
			throw new IllegalStateException("friends의 원소 갯수가 올바르지 않습니다.");
		if (!friends.stream().allMatch(friend -> friend.stream().allMatch(Problem7::isValidIdLength)))
			throw new IllegalStateException("friends의 아이디 중 길이가 올바르지 않은 아이디가 있습니다.");
		if (!friends.stream().allMatch(friend -> friend.stream().anyMatch(Problem7::isContainUpperClass)))
			throw new IllegalStateException("friends의 아이디 중 대문자가 있는 아이디가 있습니다.");
	}

	public static void isValidVisitors(List<String> visitors) throws IllegalStateException {
		if (visitors.size() < 1 || visitors.size() > 10000)
			throw new IllegalStateException("visitors의 길이가 올바르지 않습니다");
		if (!visitors.stream().allMatch(Problem7::isValidIdLength))
			throw new IllegalStateException("visitors의 아이디 중 길이가 맞지않는 아이디가 있습니다.");
		if (visitors.stream().anyMatch(Problem7::isContainUpperClass)) {
			throw new IllegalStateException("visiotrs의 원소중 대문자가있는 아이디가 있습니다.");
		}
	}

	public static boolean isValidIdLength(String id) {
		if (id.length() >= 1 && id.length() <= 30)
			return true;
		return false;
	}

	public static boolean isContainUpperClass(String id) {
		if (id.chars().anyMatch(Character::isUpperCase))
			return true;
		return false;
	}
}
