package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
	static final int MAXIMUM_COUNT_OF_RECOMMENDATION = 5;

	static final int FRIEND_SCORE = 10;
	static final int VISITOR_SCORE = 1;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		return getRecommendedFriendCandidates(user, friends, visitors);
	}

	private static List<String> getRecommendedFriendCandidates(String user, List<List<String>> friends,
		List<String> visitors) {
		Map<String, Integer> friendCandidatesAndScores = initFriendCandidateAndScoreMap(
			getFriendCandidates(user, friends, visitors));
		computeFriendScore(user, friends, friendCandidatesAndScores);
		computeVisitorScore(visitors, friendCandidatesAndScores);
		return getHighScorers(friendCandidatesAndScores);
	}

	private static List<String> getHighScorers(Map<String, Integer> friendCandidatesAndScores) {
		List<String> highScorers = new ArrayList<>();
		List<Map.Entry<String, Integer>> friendCandidatesAndScoresList = new ArrayList<>(
			friendCandidatesAndScores.entrySet());
		preprocessEntryList(friendCandidatesAndScoresList);
		if (friendCandidatesAndScoresList.size() > MAXIMUM_COUNT_OF_RECOMMENDATION) {
			friendCandidatesAndScoresList = friendCandidatesAndScoresList.subList(0, MAXIMUM_COUNT_OF_RECOMMENDATION);
		}
		friendCandidatesAndScoresList.forEach(
			friendCandidateAndScore -> highScorers.add(friendCandidateAndScore.getKey()));
		return highScorers;
	}

	private static void preprocessEntryList(List<Map.Entry<String, Integer>> entries) {
		entries.sort(Map.Entry.comparingByKey());
		entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		removeEntriesWithZeroValue(entries);
	}

	private static void removeEntriesWithZeroValue(List<Map.Entry<String, Integer>> entries) {
		entries.removeIf(entry -> entry.getValue() == 0);
	}

	private static void computeVisitorScore(List<String> visitors, Map<String, Integer> friendCandidatesAndScores) {
		visitors.forEach(visitor -> friendCandidatesAndScores.computeIfPresent(visitor,
			(friendCandidate, score) -> score + VISITOR_SCORE));
	}

	private static void computeFriendScore(String user, List<List<String>> friends,
		Map<String, Integer> friendCandidatesAndScores) {
		friendCandidatesAndScores.forEach(
			(friendCandidate, score) -> friendCandidatesAndScores.replace(friendCandidate, score,
				score + getCommonFriendsCount(user, friendCandidate, friends) * FRIEND_SCORE));
	}

	private static int getCommonFriendsCount(String user, String friendCandidate, List<List<String>> friends) {
		Set<String> userFriends = getIndividualFriendsSet(user, friends);
		Set<String> friendCandidateFriends = getIndividualFriendsSet(friendCandidate, friends);
		Set<String> commonFriends = userFriends;
		commonFriends.retainAll(friendCandidateFriends);
		return commonFriends.size();
	}

	private static Set<String> getIndividualFriendsSet(String individual, List<List<String>> friends) {
		Set<String> friendsSet = new HashSet<>();
		friends.stream()
			.filter(friend -> friend.contains(individual))
			.forEach(friend -> friendsSet.add(
				friend.stream().filter(someone -> !someone.equals(individual)).collect(Collectors.joining())));
		return friendsSet;
	}

	private static Map<String, Integer> initFriendCandidateAndScoreMap(List<String> friendCandidates) {
		return friendCandidates.stream().collect(Collectors.toMap(friendCandidate -> friendCandidate, score -> 0));
	}

	private static List<String> getFriendCandidates(String user, List<List<String>> friends, List<String> visitors) {
		List<String> friendCandidates = new ArrayList<>();
		for (List<String> friend : friends) {
			friendCandidates = mergeLists(friendCandidates, friend);
		}
		friendCandidates = mergeLists(friendCandidates, visitors);
		List<String> alreadyFriends = new ArrayList<>(getIndividualFriendsSet(user, friends));
		friendCandidates.remove(user);
		friendCandidates.removeAll(alreadyFriends);
		return friendCandidates;
	}

	private static List<String> mergeLists(List<String> list1, List<String> list2) {
		Set<String> set1 = Set.copyOf(list1);
		Set<String> set2 = Set.copyOf(list2);
		Set<String> result = new HashSet<>(set1);
		result.addAll(set2);
		return new ArrayList<>(result);
	}
}
