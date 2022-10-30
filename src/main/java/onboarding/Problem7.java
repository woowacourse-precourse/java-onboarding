package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Problem7 {

	private static final int FRIEND_POINT = 10;
	private static final int VISITOR_POINT = 1;

	static List<String> friendName = new ArrayList<>();
	static HashMap<String, Integer> recommendation = new HashMap<>();

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

		findFriend(user, friends);
		checkRelation(user, friends);
		findVisitor(visitors);
		List<Map.Entry<String, Integer>> sortedRecommendation = sortRecommadation();
		List<String> finalList = makeFinalList(sortedRecommendation);
		return finalList;
	}

	private static void findFriend(String user, List<List<String>> friends) {
		for (List<String> relation : friends) {
			int index = relation.indexOf(user);
			if (index > -1) {
				String friend = relation.get(1 - index);
				friendName.add(friend);
			}
		}
	}

	private static boolean isFriend(String friend) {
		return friendName.contains(friend);
	}

	private static void addPoint(String user, int score) {
		if (recommendation.containsKey(user)) {
			score += recommendation.get(user);
		}
		recommendation.put(user, score);
	}

	private static void checkRelation(String user, List<List<String>> friends) {
		for (List<String> relation : friends) {
			if (relation.contains(user)) {
				continue;
			}

			String friend1 = relation.get(0);
			String friend2 = relation.get(1);

			if (isFriend(friend1) ^ isFriend(friend2)) {
				String target = whoIsNotFriend(friend1, friend2);
				addPoint(target, FRIEND_POINT);
			}
		}
	}

	private static String whoIsNotFriend(String user1, String user2) {
		return isFriend(user1) ? user2 : user1;
	}

	private static void findVisitor(List<String> visitors) {
		for (String visitor : visitors) {
			if (!isFriend(visitor)) {
				addPoint(visitor, VISITOR_POINT);
			}
		}
	}

	private static List<Map.Entry<String, Integer>> sortRecommadation() {
		List<Map.Entry<String, Integer>> entries = new ArrayList<>(recommendation.entrySet());

		entries.sort((o1, o2) -> {
			Integer v1 = o1.getValue();
			Integer v2 = o2.getValue();

			if (Objects.equals(v1, v2)) {
				return o1.getKey().compareTo(o2.getKey());
			}
			return v2.compareTo(v1);
		});

		return entries;
	}

	private static List<String> makeFinalList(List<Map.Entry<String, Integer>> recommendList) {
		List<String> finalList = new LinkedList<>();

		for (int i = 0; i < recommendList.size(); i++) {
			if (i == 5) {
				break;
			}
			Map.Entry<String, Integer> entry = recommendList.get(i);
			finalList.add(entry.getKey());
		}

		return finalList;
	}
}
