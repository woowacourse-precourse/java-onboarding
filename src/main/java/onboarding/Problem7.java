package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

class Person implements Comparable<Person> {

    public String name;
    public int point;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public void addOnePoint() {
        this.point += 1;
    }

    public void addTenPoint() {
        this.point += 10;
    }

    public String getNameAsString() {
        return this.name;
    }

    public Integer getPointAsInteger() {
        return this.point;
    }

    @Override
    public int compareTo(Person p) {
        if (getPointAsInteger() < p.getPointAsInteger()) {
            return 1;
        } else if (getPointAsInteger() < p.getPointAsInteger()) {
            return -1;
        } else {
            int compareString = getNameAsString().compareTo(p.getNameAsString());
            if (compareString == 1) {
                return 1;
            } else if (compareString == -1) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "name : " + name + "point : " + point;
    }

    @Override
    public boolean equals(Object a) {
        Person obj = (Person) a;
        return (obj.getNameAsString() == this.getNameAsString());
    }

}
public class Problem7 {
    private static final int VISITORS_MIN_SIZE = 0;
    private static final int VISITORS_MAX_SIZE = 10000;
    private static final int FRIENDS_RELATION_MIN_SIZE = 1;
    private static final int FRIENDS_RELATION_MAX_SIZE = 10000;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        vaildityChecker(user, friends, visitors);

        List<String> userFriends = new ArrayList<>();
        getUserFriends(user, friends, userFriends);
        List<String> answer = Collections.emptyList();
        return answer;
    }
    private static void vaildityChecker(String user, List<List<String>> friends,
        List<String> visitors) {
        userChecker(user);
        friendsChecker(friends);
        visitorsChecker(visitors);
    }
    private static void userChecker(String user) {
        checkLength(user, user.length());
        checkConsistOfLowerCase(user);
    }
    private static void checkLength(String type, int length) {
        if (length < 1 || 30 < length) {
            throw new IllegalArgumentException(type+"는 길이가 1 이상 30 이하인 문자열이어야 합니다.");
        }
    }

    private static void friendsChecker(List<List<String>> friends) {
        checkSize("friendRelation", friends.size(), FRIENDS_RELATION_MIN_SIZE, FRIENDS_RELATION_MAX_SIZE);
        checkFriendRelation(friends);
        for (List<String> friendRelation : friends) {
            checkElements(friendRelation);
            checkOverlapFriendRelation(friendRelation);
        }
    }
    private static void checkOverlapFriendRelation(List<String> friends) {
        String leftUser = friends.get(0);
        String rightUser = friends.get(1);

        if (Pattern.matches(leftUser, rightUser)) {
            throw new IllegalArgumentException("동일한 친구 관계가 중복해서 주어지면 안됩니다.");
        }

    }
    private static void checkSize(String type, int size, int minSize, int maxSize) {
        if (size < minSize || maxSize < size) {
            throw new IllegalArgumentException(type+"는 길이가 1 이상 10,000 이하인 리스트/배열이어야 합니다.");
        }
    }
    private static void checkFriendRelation(List<List<String>> friends) {
        for (List<String> friendRelation : friends) {
            String leftUser = friendRelation.get(0);
            String rightUser = friendRelation.get(1);

            checkLength("friendsElement", leftUser.length());
            checkLength("friendsElement", rightUser.length());
        }
    }
    private static void visitorsChecker(List<String> visitors) {
        checkSize("visitors", visitors.size(), VISITORS_MIN_SIZE, VISITORS_MAX_SIZE);
        checkElements(visitors);
    }
    private static void checkElements(List<String> names) {
        for (String name : names) {
            checkConsistOfLowerCase(name);
        }

    }
    private static void checkConsistOfLowerCase(String name) {
        if (!Pattern.matches("^[a-z]*$", name)) {
            throw new IllegalArgumentException("사용자 아이디는 알파벳 소문자로만 이루어져 있어야 합니다.");
        }
    }
    private static void getUserFriends(String user, List<List<String>> friends,
        List<String> userFriends) {
        for (List<String> names : friends) {
            if (names.contains(user)) {
                userFriends.add(setUserFriends(user, names.get(0), names.get(1)));
            }
        }
    }
    private static String setUserFriends(String user, String leftName, String rightName) {
        if (leftName.contains(user)) {
            return rightName;
        }
        return leftName;
    }

}
