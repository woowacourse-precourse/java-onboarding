package onboarding.problem7;

import static java.util.stream.Collectors.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersList {
	private final Map<UserID, Friends> usersList = new HashMap<>();

	public UsersList() {

	}

	public void add(List<String> userIDs) {
		UserID firstUserID = new UserID(userIDs.get(0));
		UserID secondUserID = new UserID(userIDs.get(1));
		Friends firstUserFriends = usersList.computeIfAbsent(firstUserID, key -> new Friends());
		Friends secondUserFriends = usersList.computeIfAbsent(secondUserID, key -> new Friends());
		firstUserFriends.add(secondUserID);
		secondUserFriends.add(firstUserID);
	}

	public boolean contains(UserID userID) {
		return usersList.containsKey(userID);
	}

	public boolean isFriends(String user, String visitor) {
		return usersList.get(new UserID(user)).isFriend(new UserID(visitor));
	}

	public List<String> getFriendOfFriend(String targetUserIDName) {
		UserID targetUserID = new UserID(targetUserIDName);
		Friends targetUserFriends = usersList.get(targetUserID);
		return usersList.entrySet().stream()
			.filter(friendsEntry -> !friendsEntry.getValue().isFriend(targetUserID))
			.filter(friendsEntry -> friendsEntry.getValue().haveSameFriend(targetUserFriends))
			.map(Map.Entry::getKey)
			.filter(userID -> !userID.equals(targetUserID))
			.map(UserID::toString)
			.collect(toList());
	}
}
