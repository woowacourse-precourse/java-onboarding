package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    } else if (getPointAsInteger() > p.getPointAsInteger()) {
      return -1;
    } else {
      int compareString = getNameAsString().compareTo(p.getNameAsString());
      if (compareString > 0) {
        return 1;
      } else if (compareString < 0) {
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

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    vaildityChecker(user, friends, visitors);

    List<String> userFriends = new ArrayList<>();
    getUserFriends(user, friends, userFriends);
    List<Person> answerList = getTenPointName(user, friends, userFriends);
    getOnePointName(answerList, visitors, userFriends);
    listSort(answerList);
    List<String> answer = new ArrayList<>();
    makeAnswer(answerList, answer);
    return answer;
  }

  private static void vaildityChecker(String user, List<List<String>> friends,
      List<String> visitors) {
    userChecker(user);
    friendsChecker(friends);
    visitorsChecker(visitors, user);
  }

  private static void userChecker(String user) {
    checkLength(user, user.length());
    checkConsistOfLowerCase(user);
  }

  private static void checkLength(String type, int length) {
    if (length < 1 || 30 < length) {
      throw new IllegalArgumentException(type + "는 길이가 1 이상 30 이하인 문자열이어야 합니다");
    }
  }

  private static void friendsChecker(List<List<String>> friends) {
    checkSize("friendRelation", friends.size(), FRIENDS_RELATION_MIN_SIZE,
        FRIENDS_RELATION_MAX_SIZE);
    Set<String> overlapCheck = new HashSet<>();
    checkOverlapFriendRelation(friends, overlapCheck);
    checkFriendRelation(friends);
    for (List<String> friendRelation : friends) {
      checkElements(friendRelation);
    }
  }
  private static void checkOverlapFriendRelation(List<List<String>> friends, Set<String> overlapCheck) {
    for (List<String> friendRelation : friends) {
      String leftUser = friendRelation.get(0);
      String rightUser = friendRelation.get(1);

      String overlapList1 = leftUser + "|" + rightUser;
      String overlapList2 = rightUser + "|" + leftUser;
      if (overlapCheck.contains(overlapList1)) {
        throw new IllegalArgumentException("동일한 친구 관계가 중복해서 주어지면 안됩니다");
      }
      overlapCheck.add(overlapList1);
      overlapCheck.add(overlapList2);
    }
  }

  private static void checkSize(String type, int size, int minSize, int maxSize) {
    if (size < minSize || maxSize < size) {
      throw new IllegalArgumentException(type + "는 길이가 1 이상 10,000 이하인 리스트/배열이어야 합니다");
    }
  }

  private static void checkFriendRelation(List<List<String>> friends) {
    for (List<String> friendRelation : friends) {
      if (friendRelation.size() != 2) {
        throw new IllegalArgumentException("친구 관계가 2명으로 구성되지 않았습니다");
      }
      String leftUser = friendRelation.get(0);
      String rightUser = friendRelation.get(1);

      checkLength("friendsElement", leftUser.length());
      checkLength("friendsElement", rightUser.length());
    }
  }

  private static void visitorsChecker(List<String> visitors, String user) {
    checkSize("visitors", visitors.size(), VISITORS_MIN_SIZE, VISITORS_MAX_SIZE);
    checkElements(visitors, user);
  }

  private static void checkElements(List<String> names) {
    for (String name : names) {
      checkConsistOfLowerCase(name);
    }
  }

  private static void checkElements(List<String> names, String user) {
    for (String name : names) {
      if (user == name) {
        throw new IllegalArgumentException("방문자 목록에 user가 들어있습니다");
      }
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

  private static List<Person> getTenPointName(String user, List<List<String>> friends,
      List<String> userFriends) {
    List<Person> tenPointNames = new ArrayList<>();

    for (List<String> names : friends) {
      if (!names.contains(user)) {
        setTenPointName(names, userFriends, tenPointNames);
      }
    }
    return tenPointNames;
  }

  private static void setTenPointName(List<String> names, List<String> userFriends,
      List<Person> tenPointNames) {
    Person leftFriend = new Person(names.get(0));
    Person rightFriend = new Person(names.get(1));

    if (userFriends.contains(leftFriend.name) && !userFriends.contains(rightFriend.name)) {
      addFriend(tenPointNames, rightFriend);
    } else if (!userFriends.contains(leftFriend.name) && userFriends.contains(rightFriend.name)) {
      addFriend(tenPointNames, leftFriend);
    }
  }

  private static void addFriend(List<Person> tenPointNames, Person friend) {
    if (tenPointNames.isEmpty()) {
      friend.addTenPoint();
      tenPointNames.add(friend);
    } else if (!isContainedFriend(tenPointNames, friend)) {
      friend.addTenPoint();
      tenPointNames.add(friend);
    }
  }

  private static boolean isContainedFriend(List<Person> tenPointNames, Person friend) {
    for (Person list : tenPointNames) {
      if (list.equals(friend)) {
        list.addTenPoint();
        return true;
      }
    }
    return false;
  }

  private static boolean isContainedName(List<Person> members, String name) {
    for (Person member : members) {
      if (name.equals(member.name)) {
        return true;
      }
    }
    return false;
  }

  private static void getOnePointName(List<Person> answerList, List<String> visitors,
      List<String> userFriends) {
    for (String visitor : visitors) {
      if (isContainedName(answerList, visitor) && !isAlreadyFriend(userFriends, visitor)) {
        setOnePointName(answerList, visitor);
      } else if (!isContainedName(answerList, visitor) && !isAlreadyFriend(userFriends, visitor)) {
        answerList.add(new Person(visitor, 1));
      }
    }
  }

  private static boolean isAlreadyFriend(List<String> userFriends, String visitor) {
    for (String userFriend : userFriends) {
      if (userFriend.equals(visitor)) {
        return true;
      }
    }
    return false;
  }

  private static void setOnePointName(List<Person> answerList, String visitor) {
    for (Person member : answerList) {
      if (visitor.equals(member.name)) {
        member.addOnePoint();
        break;
      }
    }
  }

  private static void listSort(List<Person> answerList) {
    Collections.sort(answerList);
  }

  private static void makeAnswer(List<Person> answerList, List<String> answer) {

    int count = 5;
    for (Person friend : answerList) {
      if (count-- != 0) {
        answer.add(friend.name);
      }
    }
  }
}