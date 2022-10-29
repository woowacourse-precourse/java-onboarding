package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;

public class Problem7 {
	public static HashMap<String, List<String>> friendRelation;
	public static HashMap<String, Integer> Score;
	
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();
		friendRelation = new HashMap<>();
		Score = new HashMap<>();
		for (List<String> friend : friends) {
			makeFriendRelation(friend);
		}
		plusScoreByFriend(user);
		plusScoreByVisitor(visitors);
		answer = recommend(user);
		return answer;
	}
	public static void makeFriendRelation(List<String> friend) {
		addFriendRelation(friend.get(0), friend.get(1));
		addFriendRelation(friend.get(1), friend.get(0));
	}
	public static void addFriendRelation(String friend1, String friend2) {
		List<String> newFriend = new ArrayList<>();
		if (friendRelation.containsKey(friend1)) {
			newFriend = friendRelation.get(friend1);
		}
		newFriend.add(friend2);
		friendRelation.put(friend1, newFriend);
	}
	public static void plusScoreByFriend(String user) {
		List<String> userFriends = friendRelation.get(user);
		for (String userFriend : userFriends) {
			plusFriendScore(userFriend);
		}
	}
	public static void plusFriendScore(String userFriend) {
		final int friendScore = 10;
		List<String> userFriendOfFriends = friendRelation.get(userFriend);
		for (String userFriendOfFriend : userFriendOfFriends) {
			plusScore(userFriendOfFriend, friendScore);
		}
	}
	public static void plusScoreByVisitor(List<String> visitors) {
		for (String visitor : visitors) {
			plusVisitorScore(visitor);
		}
	}
	public static void plusVisitorScore(String visitor) {
		final int visitorScore = 1;
		plusScore(visitor, visitorScore);
	}
	public static void plusScore(String name, int score) {
		int newScore = score;
		if (Score.containsKey(name)) {
			newScore += Score.get(name);
		}
		Score.put(name, newScore);
	}
	private static List<String> recommend(String user) {
		List<String> recommendList = new ArrayList<>(Score.keySet());
		sortingByScore(recommendList);
		excludeUserFriendAndUser(recommendList, user);
		return cutFiveRecommendList(recommendList);
	}
	private static void sortingByScore(List<String> recommendList) {
		recommendList.sort(new Comparator<String>() {
			@Override
			public int compare(String name1, String name2) {
				return compareScore(name1, name2);
			}
		});
	}
	private static int compareScore(String name1, String name2) {
		if (Score.get(name1) < Score.get(name2)) {
			return 1;
		}
		if (Score.get(name1) > Score.get(name2)) {
			return -1;
		}
		return name1.compareTo(name2);
	}
	private static void excludeUserFriendAndUser(List<String> recommendList, String user) {
		List<String> notRecommendList = friendRelation.get(user);
		notRecommendList.add(user);
		for (String notRecommend : notRecommendList) {
			recommendList.remove(notRecommend);
		}
	}
	private static List<String> cutFiveRecommendList(List<String> recommendList) {
		List<String> fiveRecommends = new ArrayList<>();
		int count = 0;
		for (String recommend : recommendList) {
			fiveRecommends.add(recommend);
			count++;
			if (count > 4) {
				break;
			}
		}
		return fiveRecommends;
	}
}
