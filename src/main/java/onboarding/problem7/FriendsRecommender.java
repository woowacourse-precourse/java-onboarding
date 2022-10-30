package onboarding.problem7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FriendsRecommender {
	private String user;
	private Map<String, HashSet<String>> friendsInformation = new HashMap<>();
	private Map<String, Integer> recommendScore = new HashMap<>();
	private Set<String> userFriends = new HashSet<>();

	public FriendsRecommender(String user, List<List<String>> friends, List<String> visitors) {
		this.user = user;

		setFriendsInformation(friends);

		userFriends = friendsInformation.get(user);

		removeUserFriendsInFriendsInformation();

		initializeRecommendScore();

		scoreVisitors(visitors);
	}

	private void setFriendsInformation(List<List<String>> friends) {
		for (List<String> oneFriends : friends) {
			String user1 = oneFriends.get(0);
			String user2 = oneFriends.get(1);

			if (friendsInformation.containsKey(user1) == true) {
				friendsInformation.get(user1).add(user2);
			} else {
				friendsInformation.put(user1, new HashSet<>(Set.of(user2)));
			}

			if (friendsInformation.containsKey(user2) == true) {
				friendsInformation.get(user2).add(user1);
			} else {
				friendsInformation.put(user2, new HashSet<>(Set.of(user1)));
			}
		}
	}

	private void removeUserFriendsInFriendsInformation() {
		for (String oneFriend : userFriends) {
			friendsInformation.remove(oneFriend);
		}
		friendsInformation.remove(user);
	}

	private void initializeRecommendScore() {
		Set<String> friendsInformationKeys = friendsInformation.keySet();

		for (String oneUser : friendsInformationKeys) {
			recommendScore.put(oneUser, 0);
		}
	}

	private void scoreVisitors(List<String> visitors) {
		for (String oneVisitor : visitors) {
			if (userFriends.contains(oneVisitor) == true) {
				continue;
			}

			if (recommendScore.containsKey(oneVisitor) == true) {
				int increasedScore = recommendScore.get(oneVisitor) + 1;
				recommendScore.replace(oneVisitor, increasedScore);
			} else {
				recommendScore.put(oneVisitor, 1);
			}
		}
	}

	public List<String> makeRecommendedFriendsList() {
		scoreFriendsUserKnow();

		List<String> recommendedFriendsList = makeSortedRecommendList();

		return recommendedFriendsList;
	}

	private void scoreFriendsUserKnow() {
		Set<String> otherUsers = friendsInformation.keySet();
		for (String otherUser : otherUsers) {
			scoreOtherEachUsers(otherUser);
		}
	}

	private void scoreOtherEachUsers(String otherUser) {
		int score = countFriendsUserKnow(otherUser) * 10;

		int increasedScore = recommendScore.get(otherUser) + score;

		recommendScore.replace(otherUser, increasedScore);
	}

	private int countFriendsUserKnow(String otherUser) {
		int numberOfFriendsUserKnow = 0;
		Set<String> otherUserFriends = friendsInformation.get(otherUser);

		for (String userFriend : userFriends) {
			if (otherUserFriends.contains(userFriend)) {
				numberOfFriendsUserKnow += 1;
			}
		}

		return numberOfFriendsUserKnow;
	}

	private List<String> makeSortedRecommendList() {
		List<Map.Entry<String, Integer>> sortedRecommendScore = new ArrayList<>(recommendScore.entrySet());

		Collections.sort(sortedRecommendScore, (score1, score2) -> {
			int differenceOfTwoScores = (score1.getValue() - score2.getValue()) * -1;

			if (differenceOfTwoScores == 0) {
				return score1.getKey().compareTo(score2.getKey());
			} else {
				return differenceOfTwoScores;
			}
		});

		List<String> sortedRecommendList = sortedRecommendScore.stream()
			.map(Map.Entry::getKey).collect(Collectors.toList());


		return sortedRecommendList;
	}

}
