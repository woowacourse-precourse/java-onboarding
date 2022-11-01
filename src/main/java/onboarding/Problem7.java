package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		validateUser(user);
		validateFriends(friends);
		validateVisitors(visitors);
		
		// user와 친구인 리스트
		List<String> usersFriends = getUsersFriends(user, friends);

		// key : 이름 / value : 포인트 로 구성되는 HashMap
		Map<String, Integer> pointMap = new HashMap<>();

		// 친구 리스트 중 추천에 해당하는 사용자에게 포인트 10점을 부여
		for(String name : getRecommendedFriends(user, usersFriends, friends)) {
			addPoint(pointMap, name, 10);
		}

		// 방문객 리스트 중 추천에 해당하는 사용자에게 1점을 부여
		for(String visitor : getRecommendedVisitors(visitors, usersFriends)) {
			addPoint(pointMap, visitor, Collections.frequency(visitors, visitor));
		}

		return getSortedList(pointMap);
	}

	public static void validateUser(String user) {
		if(user.length() > 30 || user.length() < 1) throw new IllegalArgumentException();
	}

	public static void validateFriends(List<List<String>> friends) {
		if(friends.size() > 10000 || friends.size() < 1) throw new IllegalArgumentException();
	}

	public static void validateVisitors(List<String> visitors) {
		if(visitors.size() > 10000 || visitors.size() < 0) throw new IllegalArgumentException();
	}

	/**
	 * 주어진 사용자의 친구 리스트를 반환한다.
	 * @param user
	 * @param friends
	 * @return
	 */
	public static List<String> getUsersFriends(String user, List<List<String>> friends) {
		return friends.stream()
				.filter(x->x.contains(user))
				.flatMap(Collection::stream)
				.filter(x->!x.equals(user))
				.collect(Collectors.toList());
	}

	/**
	 * 친구리스트 중 추천 친구에 해당하는 리스트를 반환한다.
	 * @param user
	 * @param usersFriends
	 * @param friends
	 * @return
	 */
	public static List<String> getRecommendedFriends(String user, List<String> usersFriends, List<List<String>> friends) {
		List<String> recommenedFriends = new ArrayList<>();

		for(String userFriend : usersFriends){
			List<String> friendOfFriends = getUsersFriends(userFriend, friends);
			friendOfFriends.remove(user);   // user는 제외
			recommenedFriends.addAll(friendOfFriends);
		}

		return recommenedFriends;
	}

	/**
	 * 방문리스트 중 추천 친구에 해당하는 리스트를 반환한다.
	 * @param visitors
	 * @param userFriends
	 * @return
	 */
	public static List<String> getRecommendedVisitors(List<String> visitors, List<String> userFriends) {
		return visitors.stream()
				.distinct()
				.filter(x-> !userFriends.contains(x)) // 방문리스트는 모두 추천 친구에 해당하지만, user와 먼저 친구일 경우 추천 리스트에서 뺀다.
				.collect(Collectors.toList());
	}

	/**
	 * 주어진 포인트만큼 name에 해당하는 사용자에게 포인트를 더한다.
	 * @param pointMap
	 * @param name
	 * @param point
	 */
	public static void addPoint(Map<String, Integer> pointMap, String name, int point) {
		pointMap.put(name, pointMap.getOrDefault(name, 0) + point);
	}

	/**
	 * 주어진 포인트 map을 정렬 후, 최대 5명을 담은 list를 반환한다.
	 * @param pointMap
	 * @return
	 */
	public static List<String> getSortedList(Map<String, Integer> pointMap) {
		List<String> keySet = new ArrayList<>(pointMap.keySet());

		keySet.sort(Comparator.comparing(pointMap::get).reversed().thenComparing(String::valueOf));
		
		return keySet.size() > 5 ? keySet.subList(0, 5) : keySet.subList(0, keySet.size());
	}
}
