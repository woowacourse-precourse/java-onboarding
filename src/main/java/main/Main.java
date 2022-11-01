package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {

    String user = "mrko";
    List<List<String>> friends = List.of(
        List.of("donut", "andole"),
        List.of("donut", "jun"),
        List.of("donut", "mrko"),
        List.of("shakevan", "andole"),
        List.of("shakevan", "jun"),
        List.of("shakevan", "mrko")
    );
    List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
    List<String> result = List.of("andole", "jun", "bedi");

    List<String> answer = solution(user, friends, visitors);
    System.out.println("answer = " + answer);
  }

  public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    List<String> answer = new ArrayList<>();
    Map<String, Integer> friendsPoint = new HashMap<String, Integer>();

    //1. user의 친구목록을 만든다
    List<String> userFriends = makeUserFriends(user, friends);
    System.out.println("userFriends = " + userFriends);


    //2. 친구목록에서 다시 연결된 사람들 +10 점
    for (int i=0; i<userFriends.size(); i++) {
      List<String> friendFriends = makeUserFriends(userFriends.get(i), friends);
      friendFriends.remove(user);
      for (int j=0; j<friendFriends.size(); j++) {
        String friendFriendsName = friendFriends.get(j);
        int point = 10 + plusPoint(friendFriendsName, friendsPoint);
        friendsPoint.put(friendFriendsName, point);
      }
    }
    System.out.println("friendsPoint = " + friendsPoint);


    //3. visitors에서 이름나올 때마다 +1점
    List<String> newVisitors = new ArrayList<>();

    for (String visitor : visitors) {
      if (!userFriends.contains(visitor)) {
        newVisitors.add(visitor);
      }
    }
    pointByVisitors(newVisitors, friendsPoint);

    //4. 점수 대로 result에 저장. 동일점수시 오름차순
    List<String> keySet = new ArrayList<>(friendsPoint.keySet());
    keySet.sort((o1, o2) -> friendsPoint.get(o1).compareTo(friendsPoint.get(o1)));


    for (String key : keySet) {
      answer.add(key);
    }

    return answer;
  }

  private static void pointByVisitors(List<String> visitors, Map<String, Integer> friendsPoint) {
    for (int i=0; i< visitors.size(); i++) {
      String visitor = visitors.get(i);
      int point = 1 + plusPoint(visitor, friendsPoint);
      friendsPoint.put(visitor, point);
    }
  }

  private static int plusPoint(String name, Map<String, Integer> friendsPoint) {
    int point = 0;
    if (friendsPoint.containsKey(name)) {
      point += friendsPoint.get(name);
    }
    return point;
  }

  private static List<String> makeUserFriends(String user, List<List<String>> friends) {

    List<String> userFriends = new ArrayList<String>();

    for (List<String> pair : friends) {
      if (pair.get(0).equals(user)) {
        userFriends.add(pair.get(1));
      }
      else if (pair.get(1).equals(user)) {
        userFriends.add(pair.get(0));
      }
    }
    return userFriends;
  }

}
