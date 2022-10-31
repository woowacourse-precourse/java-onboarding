package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		return getTop5(user, friends, visitors);
	}

	// 최종 추천 친구 리스트에서 TOP5만 반환하는 메소드
	private static List<String> getTop5(String user, List<List<String>> friends, List<String> visitors) {
		List<String> sortedList = descendingSort(user, friends, visitors);
		List<String> top5 = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			if (sortedList.size() <= i) {
				break;
			}

			top5.add(sortedList.get(i));

		}

		return top5;
	}

	// 최종 추천 친구 리스트에서 점수 기준으로 내림차순 정렬하고, 점수가 같을 경우 이름순으로 정렬하는 메소드
	// 예외 처리: 점수가 0일 경우 반환하지 않음
	private static List<String> descendingSort(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, Integer> recommendedFriendsList = getRecommendedFriendsList(user, friends, visitors);

		Set<Integer> uniqueScores = new TreeSet<>(recommendedFriendsList.values()).descendingSet();

		List<String> sortedList = new ArrayList<>();

		for (Integer score : uniqueScores) {
			List<String> friendsOfSameScore = new ArrayList<>();

			if (score == 0) {
				continue;
			}

			for (String friend : recommendedFriendsList.keySet()) {
				Integer friendScore = recommendedFriendsList.get(friend);
				if (Objects.equals(friendScore, score)) {
					friendsOfSameScore.add(friend);
				}
			}

			Collections.sort(friendsOfSameScore);
			sortedList.addAll(friendsOfSameScore);
		}

		return sortedList;
	}

	// friends 점수와 visitors 점수를 합하여 반환하는 메소드
	private static Map<String, Integer> getRecommendedFriendsList(String user, List<List<String>> friends,
		List<String> visitors) {
		List<String> recommendedFriends = recommendedFriendsOf(user, friends, visitors);

		Map<String, Integer> friendsScore = getFriendsScore(user, friends);
		Map<String, Integer> visitorsScore = getVisitorsScore(visitors);
		Map<String, Integer> recommendedFriendsScore = new HashMap<>(recommendedFriends.size());

		int scoreSum;
		int friendScore;
		int visitorScore;

		for (String recommendedFriend : recommendedFriends) {

			if (friendsScore.get(recommendedFriend) == null) {
				friendScore = 0;
			} else {
				friendScore = friendsScore.get(recommendedFriend);
			}

			if (visitorsScore.get(recommendedFriend) == null) {
				visitorScore = 0;
			} else {
				visitorScore = visitorsScore.get(recommendedFriend);
			}

			scoreSum = friendScore + visitorScore;
			recommendedFriendsScore.put(recommendedFriend, scoreSum);
		}

		return recommendedFriendsScore;
	}

	// 추천 친구 리스트를 반환하는 메소드
	private static List<String> recommendedFriendsOf(String user, List<List<String>> friends, List<String> visitors) {
		List<String> uniqueFriendsOfFriends = uniqueFriendsOfFriends(user, friends);
		List<String> uniqueVisitors = uniqueVisitorsOf(visitors);
		List<String> friendsOfUser = friendsOfUser(friends);

		Set<String> recommendedFriends = new HashSet<>();
		recommendedFriends.addAll(uniqueFriendsOfFriends);
		recommendedFriends.addAll(uniqueVisitors);

		recommendedFriends.removeIf(friendsOfUser::contains);

		return new ArrayList<>(recommendedFriends);
	}

	// friends of firends의 점수를 반환하는 메소드
	private static Map<String, Integer> getFriendsScore(String user, List<List<String>> friends) {
		List<String> friendsOfFriends = friendsOfFriends(friends);
		List<String> uniqueFriendsOfFriends = uniqueFriendsOfFriends(user, friends);

		Map<String, Integer> friendsScore = new HashMap<>();

		int count;
		int score;

		for (String uniqueFriendOfFriends : uniqueFriendsOfFriends) {
			count = 0;

			for (String friendOfFriends : friendsOfFriends) {
				if (uniqueFriendOfFriends.equals(friendOfFriends)) {
					count++;
				}
			}

			score = count * 10;
			friendsScore.put(uniqueFriendOfFriends, score);
		}

		return friendsScore;
	}

	// friends of user 리스트를 반환하는 메소드
	private static List<String> friendsOfUser(List<List<String>> friends) {
		Set<String> friendsOfUser = new HashSet<>();

		for (List<String> friend : friends) {
			friendsOfUser.add(friend.get(0));
		}

		return new ArrayList<>(friendsOfUser);
	}

	// unique friends of friends 리스트를 반환하는 메소드
	private static List<String> uniqueFriendsOfFriends(String user, List<List<String>> friends) {
		List<String> friendsOfFriends = friendsOfFriends(friends);

		Set<String> set = new HashSet<>(friendsOfFriends);
		set.remove(user);

		return new ArrayList<>(set);
	}

	// fiends of friends 리스트를 반환하는 메소드
	private static List<String> friendsOfFriends(List<List<String>> friends) {
		List<String> friendsOfFriends = new ArrayList<>();

		for (List<String> friend : friends) {
			friendsOfFriends.add(friend.get(1));
		}

		return friendsOfFriends;
	}

	// visitor의 방문 횟수를 반환하는 메소드
	private static Map<String, Integer> getVisitorsScore(List<String> visitors) {
		List<String> uniqueVisitors = uniqueVisitorsOf(visitors);
		Map<String, Integer> visitCount = new HashMap<>();

		for (String uniqueVisitor : uniqueVisitors) {
			int count = 0;

			for (String visitor : visitors) {
				if (uniqueVisitor.equals(visitor)) {
					count++;
				}
			}

			visitCount.put(uniqueVisitor, count);
		}

		return visitCount;
	}

	// unique visitor 리스트를 반환하는 메소드
	private static List<String> uniqueVisitorsOf(List<String> visitors) {
		Set<String> set = new HashSet<>(visitors);
		return new ArrayList<>(set);
	}
}