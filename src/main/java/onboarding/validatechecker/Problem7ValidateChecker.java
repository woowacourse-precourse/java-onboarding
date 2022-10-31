package onboarding.validatechecker;

import java.util.List;

public class Problem7ValidateChecker {
	public static void areArgumentsValidate(String user, List<List<String>> friends, List<String> visitors){
		isUserNotNull(user);
		isFriendsNotNull(friends);
		isVisitorNotNull(visitors);
		isFriendRelationNotNull(friends);
		isIdNotNull(friends);

	}

	private static void isFriendRelationNotNull(List<List<String>> friends) {
		for (List<String> friendRelation : friends)
			if(friendRelation == null)
				throw new IllegalArgumentException("friends의 멤버가 null입니다.");
	}

	private static void isIdNotNull(List<List<String>> friends) {
		for (List<String> friendRelation : friends)
			if(friendRelation.get(0)==null || friendRelation.get(1)==null)
				throw new IllegalArgumentException("friends의 ID가 null입니다.");
	}

	private static void isVisitorNotNull(List<String> visitors) {
		if(visitors == null)
			throw new IllegalArgumentException("visitor가 null입니다.");
	}

	private static void isFriendsNotNull(List<List<String>> friends) {
		if(friends ==null)
			throw new IllegalArgumentException("friends가 null입니다.");
	}

	private static void isUserNotNull(String user) {
		if(user == null)
			throw new IllegalArgumentException("user가 null입니다.");
	}
}
