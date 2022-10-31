package onboarding.problem7;

import java.util.HashMap;
import java.util.List;

public class Sns {
	public static final HashMap<String, User> registeredUsers = new HashMap<>();

	private static void addUserFromRelation(List<List<String>> relations) {
		for (List<String> relation : relations) {
			for (String userName : relation) {
				registeredUsers.putIfAbsent(userName, new User(userName));
			}
		}
	}

	private static void addUserFromVisit(List<String> visitors) {
		visitors.stream().forEach(userName -> registeredUsers.putIfAbsent(userName, new User(userName)));
	}

	private static void addFriend(List<List<String>> friends) {
		for (List<String> friend : friends) {
			User userOne = registeredUsers.get(friend.get(0));
			User userTwo = registeredUsers.get(friend.get(1));
			registeredUsers.get(userOne.getName()).getFriends().add(userTwo);
			registeredUsers.get(userTwo.getName()).getFriends().add(userOne);
		}
	}

	/**
	 * step0. 친구 목록을 통해 SNS에 가입한 사용자 리스트에 추가한다.
	 * step1. 타임 라인 방문 기록을 이용해 SNS에 가입한 사용자 리스트에 추가한다.
	 * step2. SNS에 가입한 사용자들의 친구 목록을 업데이트 해준다.
	 *
	 * @param friends
	 * @param visitors
	 */
	public static void init(List<List<String>> friends, List<String> visitors) {
		// step0
		addUserFromRelation(friends);

		//step1
		addUserFromVisit(visitors);

		//step2
		addFriend(friends);
	}
}
