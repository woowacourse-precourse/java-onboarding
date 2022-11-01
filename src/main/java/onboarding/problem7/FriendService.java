package onboarding.problem7;

import static onboarding.problem7.Problem7Constant.*;

import java.util.List;
import java.util.stream.Collectors;

import onboarding.problem7.dto.FriendRelationDto;

public class FriendService {
	private final UserRepository userRepository = new UserRepository();

	public void addFriend(FriendRelationDto friendRelationDto) {
		String friendA = friendRelationDto.getFriendA();
		String friendB = friendRelationDto.getFriendB();

		User userA = userRepository.getUserByNickname(friendA);
		User userB = userRepository.getUserByNickname(friendB);

		userA.addFriend(userB);
		userB.addFriend(userA);
	}

	public List<String> getRecommendFriendOf(String userNickname, List<String> visitors) {
		List<User> allUser = userRepository.getAllUser();
		User mainUser = userRepository.getUserByNickname(userNickname);

		for (User friend : allUser) {
			addRecommendScoreByRelatedFriend(mainUser, friend);
		}

		addRecommendScoreByVisitors(visitors);

		return applyRecommendFriendListRule(mainUser);
	}

	private void addRecommendScoreByVisitors(List<String> visitors) {
		for (String visitor : visitors) {
			User visitedUser = userRepository.getUserByNickname(visitor);
			visitedUser.addScore(VISITED_SCORE);
		}
	}

	private void addRecommendScoreByRelatedFriend(User mainUser, User friend) {
		if (friend.isFriendOf(mainUser)) {
			return;
		}

		for (User friendOfFriend : friend.getFriends()) {
			if (friendOfFriend.isFriendOf(mainUser)) {
				friend.addScore(CO_FRIEND_SCORE);
			}
		}
	}

	private List<String> applyRecommendFriendListRule(User mainUser) {
		List<User> allUser = userRepository.getAllUser();
		return allUser.stream()
			.filter(u -> !u.isFriendOf(mainUser))
			.filter(u -> !u.getNickname().equals(mainUser.getNickname()))
			.filter(u -> u.getScore() > 0)
			.sorted()
			.map(User::getNickname)
			.limit(FRIEND_RECOMMEND_LIMIT)
			.collect(Collectors.toList());
	}
}
