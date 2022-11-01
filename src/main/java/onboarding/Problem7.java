package onboarding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.Map.Entry;
import static java.util.stream.Collectors.toList;

public class Problem7 {

	public static final int MAX_LIMIT_SIZE = 5;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, Set<String>> relations = new HashMap<>();
		Map<String, Integer> recommends = new HashMap<>();

		for (List<String> friend : friends) {
			addFriend(relations, friend);
			addRecommend(recommends, friend);
		}

		findMutualFriends(relations, recommends, user);
		findVisitedFriends(user, visitors, relations, recommends);

		return findRecommendFriendLimitFive(recommends);
	}

	private static List<String> findRecommendFriendLimitFive(Map<String, Integer> recommends) {
		return recommends.entrySet().stream()
				.filter(havePoint())
				.sorted(pointDescAndNameAsc())
				.limit(MAX_LIMIT_SIZE)
				.map(Entry::getKey)
				.collect(toList());
	}

	private static Predicate<Entry<String, Integer>> havePoint() {
		return recommend -> recommend.getValue() != 0;
	}

	private static Comparator<Entry<String, Integer>> pointDescAndNameAsc() {
		return (o1, o2) -> {
			if (o1.getValue().equals(o2.getValue())) {
				return o1.getKey().compareTo(o2.getKey());
			}

			return o2.getValue().compareTo(o1.getValue());
		};
	}

	private static void findVisitedFriends(String user, List<String> visitors, Map<String, Set<String>> relations, Map<String, Integer> recommends) {
		Set<String> mutualFriends = relations.get(user);
		for (String visitor : visitors) {
			addPointIfForeign(recommends, mutualFriends, visitor);
		}
	}

	private static void addPointIfForeign(Map<String, Integer> recommends, Set<String> mutualFriends, String visitor) {
		if (isAlreadyFriend(mutualFriends, visitor)) {
			return;
		}
		addOnePoint(recommends, visitor);
	}

	private static boolean isAlreadyFriend(Set<String> mutualFriends, String visitor) {
		return mutualFriends.contains(visitor);
	}

	private static void addOnePoint(Map<String, Integer> recommends, String visitor) {
		recommends.merge(visitor, 1, Integer::sum);
	}

	private static void findMutualFriends(Map<String, Set<String>> relations, Map<String, Integer> recommends, String user) {
		for (String name : relations.keySet()) {
			addTenPointIfMutual(relations, recommends, user, name);
		}
	}

	private static void addTenPointIfMutual(Map<String, Set<String>> relations, Map<String, Integer> recommends, String user, String name) {
		Set<String> userFriends = relations.get(user);
		if (isStrangerOrMe(userFriends, user, name)) {
			return;
		}
		addIfMutual(relations, recommends, userFriends, name);
	}

	private static boolean isStrangerOrMe(Set<String> userFriends, String user, String name) {
		return name.equals(user) || userFriends.contains(name);
	}

	private static void addIfMutual(Map<String, Set<String>> relations, Map<String, Integer> recommends, Set<String> userFriends, String name) {
		Set<String> relation = relations.get(name);
		for (String friend : userFriends) {
			addTenPoint(recommends, name, relation, friend);
		}
	}

	private static void addTenPoint(Map<String, Integer> recommends, String name, Set<String> relation, String friend) {
		if (isMutual(relation, friend)) {
			recommends.merge(name, 10, Integer::sum);
		}
	}

	private static boolean isMutual(Set<String> relation, String friend) {
		return relation.contains(friend);
	}

	private static void addFriend(Map<String, Set<String>> relation, List<String> friend) {
		String one = friend.get(0);
		String another = friend.get(1);

		addFriendShipAndRelation(relation, one, another);
		addFriendShipAndRelation(relation, another, one);
	}

	private static void addFriendShipAndRelation(Map<String, Set<String>> relation, String one, String another) {
		if (isAlreadyRelate(relation, one)) {
			relation.get(one).add(another);
			return;
		}

		relation.put(one, addNewFriendship(another));
	}

	private static boolean isAlreadyRelate(Map<String, Set<String>> relation, String name) {
		return relation.containsKey(name);
	}

	private static HashSet<String> addNewFriendship(String name) {
		HashSet<String> friendship = new HashSet<>();
		friendship.add(name);
		return friendship;
	}

	private static void addRecommend(Map<String, Integer> recommend, List<String> friend) {
		String one = friend.get(0);
		String another = friend.get(1);

		addRecommend(recommend, one);
		addRecommend(recommend, another);
	}

	private static void addRecommend(Map<String, Integer> recommend, String name) {
		recommend.merge(name, 0, (saved, toSave) -> toSave);
	}
}
