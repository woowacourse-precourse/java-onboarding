package onboarding.problem7;

import static java.util.stream.Collectors.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersList {
	private final Map<UserID, Friends> usersList = new HashMap<>();

	public UsersList() {

	}

	public void add(List<UserID> userIDs) {
		UserID firstUserID = userIDs.get(0);
		UserID secondUserID = userIDs.get(1);
		Friends firstUserFriends = usersList.computeIfAbsent(firstUserID, key -> new Friends());
		Friends secondUserFriends = usersList.computeIfAbsent(secondUserID, key -> new Friends());
		firstUserFriends.add(secondUserID);
		secondUserFriends.add(firstUserID);
	}

	public boolean contains(UserID userID) {
		return usersList.containsKey(userID);
	}

	public List<String> getFriendOfFriend(UserID targetUserID) {
		Friends targetUserFriends = usersList.get(targetUserID);
		return usersList.entrySet().stream()
			.filter(friendsEntry -> !friendsEntry.getValue().isFriend(targetUserID))
			.filter(friendsEntry -> friendsEntry.getValue().haveSameFriend(targetUserFriends))
			.map(Map.Entry::getKey)
			.filter(userID -> !userID.equals(targetUserID))
			.map(UserID::toString)
			.collect(toList());
	}

	public List<String> removeFriend(UserID userID, List<String> visitors) {
		return visitors.stream()
			.filter(visitor -> !usersList.get(userID).isFriend(new UserID(visitor)))
			.collect(toList());
	}
}
