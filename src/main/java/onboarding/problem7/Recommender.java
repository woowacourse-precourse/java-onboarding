package onboarding.problem7;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Recommender {
	public static final Integer NUMBER_OF_RECOMMEND_FRIEND = 5;

	private static Map<String, Integer> createScoreBoard(String userName) {
		Map<String, Integer> scores = Sns.registeredUsers.keySet()
			.stream()
			.collect(Collectors.toMap(name -> name, score -> 0));

		Sns.registeredUsers.get(userName).getFriends().stream()
			.forEach(friend -> scores.remove(friend.getName()));

		scores.remove(userName);
		return scores;
	}

	private static void updateScoreByFriend(Map<String, Integer> scoreBoard, String userName) {
		Set<User> userFriends = Sns.registeredUsers.get(userName).getFriends();
		for (User friend : userFriends) {
			for (User friendFriend : friend.getFriends()) {
				scoreBoard.computeIfPresent(friendFriend.getName(), (k, v) -> v + 10);
			}
		}
	}

	private static void updateScoreByVisitor(Map<String, Integer> scoreBoard, List<String> visitors) {
		visitors.stream().forEach(visitor -> scoreBoard.computeIfPresent(visitor, (k, v) -> v + 1));
	}

	/**
	 * step0. 가입된 모든 사용자에서 나의 친구와 나를 뺀, 친구가 될 수 있는 사람과 초기 점수 0점을 Map으로 만들어 반환
	 * step1. 친구의 친구를 +10점 한다
	 * step2. 나의 타임 라인을 방문한 친구의 친구에게 +1점을 한다
	 * step3. Map을 List로 변환하고, 점수가 높으면서 이름이 사전순으로 정렬한 뒤에 5명의 이름을 담은 리스트를 반환한다
	 *
	 * @param userName 추천을 받을 사용자 이름
	 * @param visitors 사용자의 타임 라인을 방문한 사람의 이름
	 * @return 친구 추천 리스트를 만든 후 추천 점수가 높고, 이름이 사전순인 리스트
	 */
	public static List<String> recommendByUserName(String userName, List<String> visitors) {
		// step0
		Map<String, Integer> scoreBoard = createScoreBoard(userName);

		// step1
		updateScoreByFriend(scoreBoard, userName);

		// step2
		updateScoreByVisitor(scoreBoard, visitors);

		// step3
		List<Map.Entry<String, Integer>> scoreList = scoreBoard.entrySet().stream().collect(Collectors.toList());
		return scoreList.stream()
			.sorted(Comparator.comparing((Map.Entry<String, Integer> entry) -> entry.getValue()).reversed()
				.thenComparing((Map.Entry<String, Integer> entry) -> entry.getKey()))
			.map(Map.Entry::getKey)
			.limit(NUMBER_OF_RECOMMEND_FRIEND)
			.collect(Collectors.toList());
	}
}
