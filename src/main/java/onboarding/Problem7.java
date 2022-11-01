package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {

	private static class Score implements Comparable<Score> {
		int score;
		String name;

		public Score(int score, String name) {
			this.score = score;
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

		@Override
		public int compareTo(Score o) {
			if (o.score == this.score)
				return name.compareTo(o.name);
			return Integer.compare(o.score, this.score);
		}
	}

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();

		try {
			isValidUser(user);
			isValidFriends(friends);
			isValidVisitors(visitors);
		} catch (IllegalStateException exception) {
			exception.printStackTrace();
			return answer;
		}

		answer = getTop5Scorer(getRecomScore(user, friends, visitors));

		return answer;
	}

	public static void isValidUser(String user) throws IllegalStateException {
		if (!isValidIdLength(user))
			throw new IllegalStateException("user의 길이가 올바르지 않습니다.");
		if (isContainUpperClass(user))
			throw new IllegalStateException("user의 아이디에 대문자가 있습니다.");
	}

	public static void isValidFriends(List<List<String>> friends) throws IllegalStateException {
		if (friends.size() < 1 || friends.size() > 10000)
			throw new IllegalStateException("friends의 길이가 올바르지 않습니다.");
		if (friends.stream().anyMatch(friend -> friend.size() != 2))
			throw new IllegalStateException("friends의 원소 갯수가 올바르지 않습니다.");
		if (!friends.stream().allMatch(friend -> friend.stream().allMatch(Problem7::isValidIdLength)))
			throw new IllegalStateException("friends의 아이디 중 길이가 올바르지 않은 아이디가 있습니다.");
		if (friends.stream().anyMatch(friend -> friend.stream().anyMatch(Problem7::isContainUpperClass)))
			throw new IllegalStateException("friends의 아이디 중 대문자가 있는 아이디가 있습니다.");
	}

	public static void isValidVisitors(List<String> visitors) throws IllegalStateException {
		if (visitors.size() < 1 || visitors.size() > 10000)
			throw new IllegalStateException("visitors의 길이가 올바르지 않습니다");
		if (!visitors.stream().allMatch(Problem7::isValidIdLength))
			throw new IllegalStateException("visitors의 아이디 중 길이가 맞지않는 아이디가 있습니다.");
		if (visitors.stream().anyMatch(Problem7::isContainUpperClass)) {
			throw new IllegalStateException("visiotrs의 원소중 대문자가 있는 아이디가 있습니다.");
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

	public static List<Score> getRecomScore(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, Integer> recomScoreMap = new HashMap<>();
		List<String> userList = getUserList(user, friends, visitors);
		Map<String, Set<String>> friendSet = getFriendList(friends);

		getFriendRecomScore(user, recomScoreMap, userList, friendSet);
		getVisitorRecomScore(recomScoreMap, visitors);

		return userList.stream()
			.filter(recomScoreMap::containsKey)
			.filter(userName -> !friendSet.get(user).contains(userName))
			.map(userName -> new Score(recomScoreMap.get(userName), userName))
			.collect(Collectors.toList());
	}

	public static List<String> getUserList(String user, List<List<String>> friends, List<String> visitors) {
		Set<String> userSet = new HashSet<>();
		userSet.add(user);
		friends.forEach(friend -> {
			userSet.add(friend.get(0));
			userSet.add(friend.get(1));
		});
		userSet.addAll(visitors);
		return new ArrayList<>(userSet);
	}

	public static Map<String, Set<String>> getFriendList(List<List<String>> friends) {
		Map<String, Set<String>> friendMap = new HashMap<>();
		friends.forEach(friend -> {
			if (!friendMap.containsKey(friend.get(0))) {
				friendMap.put(friend.get(0), new HashSet<>());
			}
			if (!friendMap.containsKey(friend.get(1))) {
				friendMap.put(friend.get(1), new HashSet<>());
			}
			friendMap.get(friend.get(0)).add(friend.get(1));
			friendMap.get(friend.get(1)).add(friend.get(0));
		});
		return friendMap;
	}

	public static int getFriendScore(Set<String> myFriends, Set<String> friendList) {
		long cnt = myFriends.stream().filter(friendList::contains).count();
		return (int)(cnt * 10);
		//return (int)(myFriends.stream().filter(friendList::contains).count() * 10);
	}

	public static void getFriendRecomScore(String user, Map<String, Integer> recomScoreMap, List<String> userList,
		Map<String, Set<String>> friendSet) {
		userList.stream()
			.filter(userName -> !user.equals(userName))
			.filter(friendSet::containsKey)
			.forEach(userName -> recomScoreMap.put(userName,
				recomScoreMap.getOrDefault(userName, 0) + getFriendScore(friendSet.get(user),
					friendSet.get(userName))));
	}

	public static void getVisitorRecomScore(Map<String, Integer> recomScoreMap, List<String> visitors) {
		visitors.forEach(visitor -> {
			if (!recomScoreMap.containsKey(visitor))
				recomScoreMap.put(visitor, 0);
			recomScoreMap.put(visitor, recomScoreMap.get(visitor) + 1);
		});
	}

	public static List<String> getTop5Scorer(List<Score> scoreList) {
		return scoreList.stream()
			.filter(score -> score.score > 0)
			.sorted()
			.limit(5)
			.map(Score::toString)
			.collect(Collectors.toList());
	}

}
