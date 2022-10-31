// package onboarding.problem7;
//
// import java.util.Objects;
//
// public class User {
// 	private final Friends friends;
// 	private final UserID userID;
//
// 	public User(String userID) {
// 		this.userID = new UserID(userID);
// 		this.friends = new Friends();
// 	}
//
// 	public User(UserID userID) {
// 		this.userID = userID;
// 		this.friends = new Friends();
// 	}
//
// 	public void addFriend(UserID userID) {
// 		this.friends.add(userID);
// 	}
//
// 	public boolean isFriends(UserID otherUser) {
// 		return this.friends.isFriend(otherUser);
// 	}
//
//
// 	public boolean isSecondFriend(User otherUser) {
// 		return this != otherUser && friends.isSecondFriend(otherUser);
// 	}
//
// 	@Override
// 	public String toString() {
// 		return userID.toString();
// 	}
//
// 	@Override
// 	public boolean equals(Object o) {
// 		if (this == o)
// 			return true;
// 		if (!(o instanceof User))
// 			return false;
// 		User user = (User)o;
// 		return Objects.equals(friends, user.friends) && Objects.equals(userID, user.userID);
// 	}
//
// 	@Override
// 	public int hashCode() {
// 		return Objects.hash(friends, userID);
// 	}
//
// 	public boolean isSameID(UserID otherUserID) {
// 		return userID.equals(otherUserID);
// 	}
// }
