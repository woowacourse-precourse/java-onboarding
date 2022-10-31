package onboarding.validatechecker;

import java.util.List;

public class Problem7ValidateChecker {
	private final static int FRIEND_RELATION_SIZE = 2;
	private final static String LOWER_CASE = "^[a-z]*$";
	public static void areArgumentsValidate(String user, List<List<String>> friends, List<String> visitors){
		isUserNotNull(user);
		isFriendsNotNull(friends);
		isVisitorsNotNull(visitors);
		isFriendRelationNotNull(friends);
		isIdNotNull(friends);
		isFriendsInRange(friends);
		isFriendRelationInRange(friends);
		isIdInRange(user,friends,visitors);
		isVisitorsInRange(visitors);
		isIdContainOnlyLowerCase(user,friends,visitors);
	}

	private static void isIdContainOnlyLowerCase(String user, List<List<String>> friends, List<String> visitors) {
		if(!user.matches(LOWER_CASE))
			throw new IllegalArgumentException("아이디에 소문자 외의 문자가 포함되어 있습니다.");
		for(String visitor : visitors)
			if (!visitor.matches(LOWER_CASE))
				throw new IllegalArgumentException("아이디에 소문자 외의 문자가 포함되어 있습니다.");
		for(List<String> friendRelation : friends){
			if(!friendRelation.get(0).matches(LOWER_CASE) || !friendRelation.get(1).matches(LOWER_CASE))
				throw new IllegalArgumentException("아이디에 소문자 외의 문자가 포함되어 있습니다.");
		}
	}

	private static void isVisitorsInRange(List<String> visitors) {
		if(visitors.size() > 10000)
			throw new IllegalArgumentException("visitors의 크기가 10000초과입니다.");
	}

	private static void isIdInRange(String user, List<List<String>> friends, List<String> visitors) {
		if(user.length() == 0 || user.length() > 30)
			throw new IllegalArgumentException("아이디의 길이가 0이거나, 30초과입니다.");
		for (String visitor : visitors)
			if(visitor.length() == 0 || visitor.length() > 30)
				throw new IllegalArgumentException("아이디의 길이가 0이거나, 30초과입니다.");
		for (List<String> friendRelation : friends)
			if(friendRelation.get(0).length() == 0 || friendRelation.get(0).length() > 30
			|| friendRelation.get(1).length() == 0 || friendRelation.get(1).length() > 30)
				throw new IllegalArgumentException("아이디의 길이가 0이거나, 30초과입니다.");
	}

	private static void isFriendRelationInRange(List<List<String>> friends) {
		for (List<String> friendRelation : friends)
			if(friendRelation.size() != FRIEND_RELATION_SIZE)
				throw new IllegalArgumentException("friendRelation의 크기가 2가 아닙니다.");
	}

	private static void isFriendsInRange(List<List<String>> friends) {
		if(friends.size() == 0 || friends.size() > 10000)
			throw new IllegalArgumentException("friends의 길이가 0이거나, 10,000초과입니다.");
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

	private static void isVisitorsNotNull(List<String> visitors) {
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
