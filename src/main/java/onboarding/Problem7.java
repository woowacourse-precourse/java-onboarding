package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {

  private static final String ID_REGEX = "^[a-z]*$";
  private static final int MAX_ID_LENGTH = 30;
  private static final int MAX_FRIENDS_SIZE = 10000;
  private static final int MAX_VISITORS_SIZE = 10000;
  private static final String[] EXCEPTION_LIST = {"-99999"};

  private static Map<String, Integer> recommendFriendsPoint = new HashMap<>();

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    if (isAllowedId(user) && isAllowedFriendsInfoSize(friends.size()) &&
        isAllowedVisitorsSize(visitors.size())) {
      return resultOfRecommendFriends(user, friends, visitors);
    }
    ArrayList<String> returnList = new ArrayList<>(Arrays.asList(EXCEPTION_LIST));
    return returnList;
  }


  public static List<String> resultOfRecommendFriends(String user, List<List<String>> friends,
      List<String> visitors) {
    List<String> userFriendsList = makeUserFriendsList(user, friends);
    List<String> togetherKnowFriendsList = makeTogetherKnowFriendsList(user, userFriendsList,
        friends);
    add10Point(togetherKnowFriendsList);

    List<String> trueVisitorsList = makeTrueVisitorsList(userFriendsList, visitors);
    add1Point(trueVisitorsList);

    ArrayList<String> recommendFriendsList = sortResultOfRecommendFriends();
    return recommendFriendsList;
  }

  private static ArrayList<String> sortResultOfRecommendFriends() {
    ArrayList<String> returnList = new ArrayList<>();

    ArrayList<String> list = new ArrayList<>(recommendFriendsPoint.keySet());
    list.sort(Comparator.naturalOrder());

    ArrayList<Integer> pointList = new ArrayList<>(recommendFriendsPoint.values());
    pointList.sort(Comparator.reverseOrder());

    for (Integer point : pointList) {
      list.stream()
          .filter(name -> recommendFriendsPoint.get(name) == point &&
              !returnList.contains(name) && returnList.size() < 5)
          .forEach(returnList::add);
    }

    return returnList;
  }


  /**
   * user의 친구 리스트업 후 반환
   */
  private static List<String> makeUserFriendsList(String user,
      List<List<String>> friends) {
    List<String> userFriendsList = new ArrayList<>();
    friends.stream()
        .filter(friend -> friend.get(1).equals(user))
        .forEach(userFriend -> userFriendsList.add(userFriend.get(0)));

    return userFriendsList;
  }

  /**
   * 함께아는 친구 리스트업 후 반환
   */
  private static List<String> makeTogetherKnowFriendsList(String user, List<String> userFriendsList,
      List<List<String>> friends) {
    ArrayList<String> togetherKnowFriendsList = new ArrayList<>();
    for (String userFriend : userFriendsList) {
      friends.stream()
          .filter(
              friendInfo -> friendInfo.get(0).equals(userFriend) && !friendInfo.get(1).equals(user))
          .forEach(togetherKnowFriend -> togetherKnowFriendsList.add(togetherKnowFriend.get(1)));
    }
    return togetherKnowFriendsList;
  }

  private static void add10Point(List<String> togetherKnowFriendsList) {
    for (String togetherKnowFriend : togetherKnowFriendsList) {
      if (isAlreadyExist(togetherKnowFriend)) {
        recommendFriendsPoint.replace(togetherKnowFriend,
            recommendFriendsPoint.get(togetherKnowFriend) + 10);
      } else {
        recommendFriendsPoint.put(togetherKnowFriend, 10);
      }
    }
  }

  /**
   * 방문자중 원래 친구를 제외한 방문자를 리스트업 후 반환
   */
  private static List<String> makeTrueVisitorsList(List<String> userFriendsList,
      List<String> visitors) {
    ArrayList<String> trueVisitorsList = new ArrayList<>(visitors);
    for (String userFriend : userFriendsList) {
      visitors.stream()
          .filter(visitor -> visitor.equals(userFriend))
          .forEach(trueVisitorsList::remove);
    }
    return trueVisitorsList;
  }

  private static void add1Point(List<String> trueVisitorsList) {
    for (String trueVisitor : trueVisitorsList) {
      if (isAlreadyExist(trueVisitor)) {
        recommendFriendsPoint.replace(trueVisitor, recommendFriendsPoint.get(trueVisitor) + 1);
      } else {
        recommendFriendsPoint.put(trueVisitor, 1);
      }
    }
  }

  /**
   * 추천친구목록에 이미 존재하는 사람인지 확인
   */
  private static boolean isAlreadyExist(String recommendFriend) {
    Set<String> recommendFriendSet = recommendFriendsPoint.keySet();
    if (recommendFriendSet.contains(recommendFriend)) {
      return true;
    }
    return false;
  }

  public static boolean isAllowedId(String id) throws IllegalStateException {
    if (id.length() < 1 || id.length() > MAX_ID_LENGTH) {
      throw new IllegalStateException("아이디가 1~30자가 아닙니다.");
    }
    if (!id.matches(ID_REGEX)) {
      throw new IllegalStateException("아이디는 소문자 알파벳만 가능합니다.");
    }
    return true;
  }

  public static boolean isAllowedFriendsInfoSize(int friendsSize) throws IllegalStateException {
    if (friendsSize < 1 || friendsSize > MAX_FRIENDS_SIZE) {
      throw new IllegalStateException("친구관계의 숫자는 1~10,000개 이내여야 합니다.");
    }
    return true;
  }

  public static boolean isAllowedVisitorsSize(int visitorsSize) throws IllegalStateException {
    if (visitorsSize < 1 || visitorsSize > MAX_VISITORS_SIZE) {
      throw new IllegalStateException("방문자의 숫자는 1~10,000 이내여야 합니다.");
    }
    return true;
  }

}
