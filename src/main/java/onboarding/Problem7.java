package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

	public static Map<String, List<String>> createFriendRelations(List<List<String>> friends) {
		Map<String, List<String>> friendRelations = new HashMap<>();

		for (List<String> friend : friends) {
			createFriendRelation(friend.get(0), friend.get(1), friendRelations);
			createFriendRelation(friend.get(1), friend.get(0), friendRelations);
		}

		return friendRelations;
	}

	public static void createFriendRelation(String friend1, String friend2,
											Map<String, List<String>> friendRelations) {
		List<String> friendList;
		friendList = friendRelations.getOrDefault(friend1, new ArrayList<>());
		friendList.add(friend2);
		friendRelations.put(friend1, friendList);
	}

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
