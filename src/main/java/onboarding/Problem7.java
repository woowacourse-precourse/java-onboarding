package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.Entry;
import static java.util.stream.Collectors.toList;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, Set<String>> relations = new HashMap<>();
		Map<String, Integer> recommends = new HashMap<>();

		for (List<String> friend : friends) {
			addFriend(relations, friend);
			addRecommend(recommends, friend);
		}

		Set<String> mutualFriends = relations.get(user);
		for (String name : relations.keySet()) {
			if (name.equals(user) || mutualFriends.contains(name)) {
				continue;
			}

			Set<String> relation = relations.get(name);
			for (String mutualFriend : mutualFriends) {
				if (relation.contains(mutualFriend)) {
					recommends.merge(name, 10, Integer::sum);
				}
			}
		}

		for (String visitor : visitors) {
			if (mutualFriends.contains(visitor)) {
				continue;
			}
			recommends.merge(visitor, 1, Integer::sum);
		}

		return recommends.entrySet().stream()
				.filter(recommend -> recommend.getValue() != 0)
				.sorted((o1, o2) -> {
					if (o1.getValue().equals(o2.getValue())) {
						return o1.getKey().compareTo(o2.getKey());
					}

					return o2.getValue().compareTo(o1.getValue());
				})
				.limit(5)
				.map(Entry::getKey)
				.collect(toList());
	}

	private static void addFriend(Map<String, Set<String>> relation, List<String> friend) {
		String from = friend.get(0);
		String to = friend.get(1);

		if (relation.containsKey(from)) {
			relation.get(from).add(to);
		} else {

			HashSet<String> friendship = new HashSet<>();
			friendship.add(to);
			relation.put(from, friendship);
		}

		if (relation.containsKey(to)) {
			relation.get(to).add(from);
		} else {
			HashSet<String> friendship = new HashSet<>();
			friendship.add(from);
			relation.put(to, friendship);
		}
	}

	private static void addRecommend(Map<String, Integer> recommend, List<String> friend) {
		String from = friend.get(0);
		String to = friend.get(1);

		recommend.merge(from, 0, (a, b) -> b);
		recommend.merge(to, 0, (a, b) -> b);
	}
}
