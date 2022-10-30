package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = new ArrayList<>();
		HashMap<String, List<String>> friendMap = createFriendMap(friends);
		HashMap<String, Integer> oneHopFriend = getOneHopFriend(user, friendMap);
		HashMap<String, Integer> point = new HashMap<>();

		for(Entry<String, Integer> friend: oneHopFriend.entrySet())
			point.put(friend.getKey(), friend.getValue() * 10);

		for(String visitor: visitors) {
			if(friendMap.get(user).contains(visitor))
				continue;
			if(!point.containsKey(visitor))
				point.put(visitor, 1);
			else
				point.put(visitor, point.get(visitor) + 1);
		}

		return answer;
	}

	private static HashMap<String, List<String>> createFriendMap(List<List<String>> friends) {
		HashMap<String, List<String>> friendMap = new HashMap<>();

		for(List<String> friend: friends) {
			for(int i = 0;i < 2;i++) {
				if(!friendMap.containsKey(friend.get(i))) {
					ArrayList<String> list = new ArrayList<>();
					list.add(friend.get((i + 1) % 2));
					friendMap.put(friend.get(i),list);
				}
				else
					friendMap.get(friend.get(i)).add(friend.get((i + 1) % 2));
			}
		}

		return friendMap;
	}

	private static HashMap<String, Integer> getOneHopFriend(String user,
															HashMap<String, List<String>> friendMap) {
		HashMap<String, Integer> result = new HashMap<>();

		for(String friend: friendMap.get(user)) {
			for(String indirectFriend: friendMap.get(friend)) {
				if(user.equals(indirectFriend) || friendMap.get(user).contains(indirectFriend))
					continue;
				if(!result.containsKey(indirectFriend))
					result.put(indirectFriend, 1);
				else
					result.put(indirectFriend, result.get(indirectFriend) + 1);
			}
		}

		return result;
	}
}
