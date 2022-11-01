package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem7 {

	public static List<String> solution(String user, List<List<String>> friends,
		List<String> visitors) {
		try {
			validateData(user, friends, visitors);
			User userOfSns = new User(user);
			Others others = new Others(userOfSns);
			recordRelationshipLlist(friends, userOfSns, others);
			recordVisitorList(visitors, userOfSns, others);
			List<String> answer = others.getTopFiveNameOfOtherList();
			return answer;
		} catch (Exception e) {
			System.out.println(e);
			return Collections.emptyList();
		}
	}

	static void recordRelationshipLlist(List<List<String>> relationshipList, User user,
		Others others) {
		List<List<String>> otherRelationships = new ArrayList<>();
		relationshipList.stream().forEach(relationship -> {
			String isFriendOrOther = recordRelationship(relationship, user);
			boolean isOther = checkIsOther(isFriendOrOther);
			if (isOther) {
				otherRelationships.add(relationship);
			}
		});
		otherRelationships.stream().forEach(relationship -> {
			others.addRelationship(relationship);
		});
	}

	static String recordRelationship(List<String> relationship, User user) {
		boolean isRelationshipOfUserOfUser = user.checkIsRelationshipOfUser(relationship);
		if (isRelationshipOfUserOfUser) {
			user.addRelationship(relationship);
			return "friend";
		}
		return "other";
	}

	static boolean checkIsOther(String isFriendOrOther) {
		if (isFriendOrOther.equals("other")) {
			return true;
		}
		return false;
	}

	static void recordVisitorList(List<String> visitors, User user, Others others) {
		visitors.stream().forEach(visitor -> {
			recordVisitor(visitor, user, others);
		});
	}

	static void recordVisitor(String visitor, User user, Others others) {
		boolean isFriendOfUser = user.checkIsFriendOfUser(visitor);
		if (isFriendOfUser) {
			return;
		}
		others.recordVisitor(visitor);
	}

	static void validateData(String user, List<List<String>> friends, List<String> visitors)
		throws Exception {
		validateName(user);
		validateFriends(friends);
		validateVisitors(visitors);
	}

	static void validateName(String id) throws Exception {
		String pattern = "^[a-z]{1,30}$";
		boolean isMatch = Pattern.matches(pattern, id);
		if (!isMatch) {
			throw new Exception("사용자 아이디는 길이가 1 이상 30 이하이며, 알파벳 소문자로 이루어져야 합니다");
		}
	}

	static void validateFriends(List<List<String>> friends) throws Exception {
		validateFriendsLength(friends);
		for (List<String> relationship : friends) {
			validateStringList(relationship);
		}
	}

	static void validateVisitors(List<String> visitors) throws Exception {
		validateVisitorsLength(visitors);
		validateStringList(visitors);
	}

	static void validateStringList(List<String> stringList) throws Exception {
		for (String name : stringList) {
			validateName(name);
		}
	}

	static void validateFriendsLength(List<List<String>> friends) throws Exception {
		int length = friends.size();
		if (length < 1 || length > 10000) {
			throw new Exception("friends의 길이는 1 이상 10000 이하여야 합니다");
		}
	}

	static void validateVisitorsLength(List<String> visitors) throws Exception {
		int length = visitors.size();
		if (length < 0 || length > 10000) {
			throw new Exception("visitors의 길이는 0 이상 10000 이하여야 합니다");
		}
	}
}

class User {

	private String user;
	private List<String> friends = new ArrayList<>();

	User(String user) {
		this.user = user;
	}

	String getUser() {
		return this.user;
	}

	List<String> getFriendList() {
		List<String> friendList = this.friends;
		return friendList;
	}

	boolean checkIsRelationshipOfUser(List<String> relationship) {
		String user = this.getUser();
		boolean isContainUser = relationship.contains(user);
		return isContainUser;
	}

	void addRelationship(List<String> relationship) {
		String friend = this.getFriendFromRelationship(relationship);
		this.friends.add(friend);
	}

	String getFriendFromRelationship(List<String> relationship) {
		String user = this.getUser();
		int indexOfUser = relationship.indexOf(user);
		int indexOfFriend = 1 - indexOfUser;
		String friend = relationship.get(indexOfFriend);
		return friend;
	}

	boolean checkIsFriendOfUser(String other) {
		List<String> friendList = this.getFriendList();
		boolean isFriendOfUser = friendList.contains(other);
		return isFriendOfUser;
	}
}

class Others {

	Others(User user) {
		this.user = user;
		this.othersList = new ArrayList<>();
	}

	private List<Other> othersList;
	;
	private User user;

	User getUser() {
		return this.user;
	}

	List<Other> getOthersList() {
		return this.othersList;
	}

	void setOthersList(List<Other> othersList) {
		this.othersList = othersList;
	}

	void addRelationship(List<String> relationship) {
		String other1 = relationship.get(0);
		String other2 = relationship.get(1);
		this.addOther(other1);
		this.addOther(other2);
		this.addPointIfHaveMutual(other1, other2);
		this.addPointIfHaveMutual(other2, other1);
	}

	void addOther(String otherName) {
		boolean isRegisteredOther = this.checkIsRegisteredOther(otherName);
		if (isRegisteredOther) {
			return;
		}

		Other other = new Other(otherName, 0);
		this.othersList.add(other);
	}

	void recordVisitor(String visitor) {
		this.addOther(visitor);
		int pointForVisitor = Point.Visitor.getPoint();
		this.addPoint(visitor, pointForVisitor);
	}

	void sortOthersList() {
		List<Other> othersList = this.getOthersList();
		List<Other> othersListSorted = othersList.stream()
			.sorted(Comparator.comparing(Other::getPoint).reversed())
			.collect(Collectors.toList());
		this.setOthersList(othersListSorted);
	}

	List<String> getTopFiveNameOfOtherList() {
		this.sortOthersList();
		List<Other> topFiveList = getTopFiveOfOtherList();
		List<String> topFiveListOfName = getNameListByOtherList(topFiveList);
		return topFiveListOfName;
	}

	List<Other> getTopFiveOfOtherList() {
		List<Other> othersList = this.getOthersList();
		List<Other> topFiveList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Other other = othersList.get(i);
			int otherPoint = other.getPoint();
			boolean isPointZero = this.checkIsPointZero(otherPoint);
			if (isPointZero) {
				break;
			}
			topFiveList.add(other);
		}
		return topFiveList;
	}

	boolean checkIsPointZero(int point) {
		if (point == 0) {
			return true;
		}
		return false;
	}

	boolean checkIsRegisteredOther(String otherName) {
		List<String> othersNameList = this.getOthersNameList();
		boolean isRegisteredOther = othersNameList.contains(otherName);
		return isRegisteredOther;
	}

	List<String> getOthersNameList() {
		List<Other> othersList = this.getOthersList();
		List<String> othersNameList = new ArrayList<>();
		othersList.stream().forEach(other -> {
			String name = other.getName();
			othersNameList.add(name);
		});
		return othersNameList;
	}

	List<String> getNameListByOtherList(List<Other> otherList) {
		List<String> nameList = new ArrayList<>();
		otherList.stream()
			.sorted(Comparator.comparing(Other::getName))
			.sorted(Comparator.comparing(Other::getPoint).reversed())
			.forEach(other -> nameList.add(other.getName()));
		return nameList;
	}

	void addPointIfHaveMutual(String other, String target) {
		User user = this.getUser();
		boolean isFriendOfUser = user.checkIsFriendOfUser(target);
		if (isFriendOfUser) {
			int pointOfMutualFriend = Point.MutualFriend.getPoint();
			addPoint(other, pointOfMutualFriend);
		}
	}

	void addPoint(String otherName, int point) {
		User user = this.getUser();
		boolean isFriendOfUser = user.checkIsFriendOfUser(otherName);
		if (isFriendOfUser) {
			return;
		}
		List<Other> otherList = this.getOthersList();
		otherList.stream().filter(other -> other.getName().equals(otherName)).forEach(other -> {
			other.addPoint(point);
		});
	}
}

class Other {

	Other(String name, int point) {
		this.name = name;
		this.point = point;
	}

	private String name;
	private int point;

	String getName() {
		return this.name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getPoint() {
		return this.point;
	}

	void setPoint(int point) {
		this.point = point;
	}

	void addPoint(int point) {
		this.point += point;
	}
}

enum Point {
	MutualFriend(10),
	Visitor(1);

	private final int point;

	Point(int point) {
		this.point = point;
	}

	int getPoint() {
		return point;
	}
}