package onboarding;

import static onboarding.Problem6.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		// 전체 유저 리스트 생성
		List<String> userList = makeUserList(friends, visitors);
		userList.remove(user);
		System.out.println(userList);
		// 유저 친구 관계 리스트 생성
		List<String> userFriendsList = makeFriendList(friends, user);
		// 유저 친구의 친구 관계 리스트 생성
		List<List<String>> userFriendsFriendsList = new ArrayList<>();
		for (String friend : userFriendsList) {
			List<String> friendList = makeFriendList(friends, friend);
			friendList.remove(user);
			userFriendsFriendsList.add(friendList);
		}
		System.out.println(userFriendsFriendsList);
		// 전체 유저 리스트에서 유저와 친구를 뺀 리스트 생성
		List<String> noFriendList = makeNoFriendList(userList, userFriendsList);
		System.out.println(noFriendList);
		// 유저 및 친구 제외 리스트의 구성원 중 방문객 점수 부여
		// 유저및 친구 제외 리스트의 구성원 중 친구의 친구 점수 부여
		// answer 리스트에 add
		// 추천 점수가 같은 경우는 이름순

		List<String> answer = Collections.emptyList();
		return answer;
	}

	static List<String> makeNoFriendList(List<String> userList, List<String> userFriendsList) {
		List<String> noFriendList = new ArrayList<>(userList);
		for(String friend : userFriendsList) {
			noFriendList.remove(friend);
		}
		return noFriendList;
	}

	static List<String> makeUserList(List<List<String>> friends, List<String> visitors) {
		List<String> userList = new ArrayList<>();
		for (List<String> friend : friends) {
			userList.addAll(friend);
		}
		userList.addAll(visitors);
		return removeListDuplication(userList);
	}

	static List<String> makeFriendList(List<List<String>> friends, String user) {
		List<String> friendList = new ArrayList<>();
		for (List<String> friend : friends) {
			if (friend.get(0).equals(user))
				friendList.add(friend.get(1));
			else if (friend.get(1).equals(user))
				friendList.add(friend.get(0));
		}
		return friendList;
	}

	public static void main(String[] args) {
		String user = "mrko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		List<String> result = List.of("andole", "jun", "bedi");
		solution(user, friends, visitors);
	}
}
