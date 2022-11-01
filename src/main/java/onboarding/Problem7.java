package onboarding;

import static onboarding.Problem6.HandlingList.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
	private static class ScoreConstant {
		static final int friendsFriendScore = 10;
		static final int visitorScore = 1;
		static final int limit = 5;
	}

	private static class UsersInformation extends ScoreConstant {
		private static String user;
		private static List<List<String>> friends;
		private static List<String> visitors;

		public static void setUser(String name) {
			user = name;
		}

		public static void setFriends(List<List<String>> list) {
			friends = list;
		}

		public static void setVisitors(List<String> list) {
			visitors = list;
		}

		public static String getUser() {
			return user;
		}

		public static List<List<String>> getFriends() {
			return friends;
		}

		public static List<String> getVisitors() {
			return visitors;
		}

		public static void setUsersInformation(String user, List<List<String>> friends, List<String> visitors) {
			setUser(user);
			setFriends(friends);
			setVisitors(visitors);
		}
	}

	private static class HandlingFriendsInformation extends UsersInformation {
		private static List<String> usersFriends;
		private static List<String> friendsFriend;

		public static void setUsersFriends(List<String> list) {
			usersFriends = list;
		}

		public static void setFriendsFriend(List<String> list) {
			friendsFriend = list;
		}

		public static List<String> getFriendsFriend() {
			return friendsFriend;
		}

		public static boolean isIncludeUserOrFriends(String name) {
			return (usersFriends.contains(name) || getUser().equals(name)) ? true : false;
		}

		public static int findFriendsIndex(String user, List<String> friends) {
			return friends.get(0).equals(user) ? 1 : 0;
		}

		public static void findUsersFriend() {
			List<String> usersFriends = getFriends().stream()
				.filter(i -> i.contains(getUser()))
				.map(i -> i.get(findFriendsIndex(getUser(), i)))
				.collect(Collectors.toList());
			setUsersFriends(usersFriends);
		}

		public static void findFriendsFriend() {
			List<String> friendsFriendList = new ArrayList<String>();
			Iterator<String> iterator = usersFriends.iterator();
			while (iterator.hasNext()) {
				String friend = iterator.next();
				List<String> list = getFriends().stream()
					.filter(i -> i.contains(friend))
					.map(i -> i.get(findFriendsIndex(friend, i)))
					.distinct()
					.collect(Collectors.toList());
				copyList(friendsFriendList, list);
			}
			setFriendsFriend(friendsFriendList);
		}
	}

	private static class Score extends HandlingFriendsInformation {
		static Map<String, Integer> recommendedFriends = new HashMap<String, Integer>();

		public static List<String> limitList(List<String> recommendedList) {
			List<String> list = recommendedList.stream().limit(limit).collect(Collectors.toList());
			return list;
		}

		public static List<String> orderRecommendedList() {
			List<Map.Entry<String, Integer>> entries = recommendedFriends.entrySet()
				.stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toList());
			List<String> orderedRecommendedList = entries.stream().map(i -> i.getKey()).collect(Collectors.toList());
			System.out.println(entries);
			return orderedRecommendedList;
		}

		public static void forCaseFriendsFriend() {
			Iterator<String> iterator = getFriendsFriend().iterator();
			while (iterator.hasNext()) {
				String recommendedFriend = iterator.next();
				if (isIncludeUserOrFriends(recommendedFriend)) {
					continue;
				}
				if (recommendedFriends.containsKey(recommendedFriend)) {
					recommendedFriends.put(recommendedFriend,
						recommendedFriends.get(recommendedFriend) + friendsFriendScore);
					continue;
				}
				recommendedFriends.put(recommendedFriend, friendsFriendScore);
			}
		}

		public static void forCaseVisitors() {
			//removeFriends(visitors);
			Iterator<String> iterator = getVisitors().iterator();
			while (iterator.hasNext()) {
				String recommendedFriend = iterator.next();
				if (isIncludeUserOrFriends(recommendedFriend)) {
					continue;
				}
				if (recommendedFriends.containsKey(recommendedFriend)) {
					recommendedFriends.put(recommendedFriend, recommendedFriends.get(recommendedFriend) + visitorScore);
					continue;
				}
				recommendedFriends.put(recommendedFriend, visitorScore);
			}
		}
	}

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();
		UsersInformation.setUsersInformation(user, friends, visitors);
		HandlingFriendsInformation.findUsersFriend();
		HandlingFriendsInformation.findFriendsFriend();
		Score.forCaseFriendsFriend();
		Score.forCaseVisitors();
		answer = Score.orderRecommendedList();
		answer = Score.limitList(answer);
		return answer;
	}
}
