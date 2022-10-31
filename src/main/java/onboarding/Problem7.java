package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Problem7 {

  static HashMap<String, Integer> pointList;
  static List<String> userFriendList;
  static List<HashMap.Entry<String, Integer>> sortedPointList;
  static List<String> result;

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    try{
      init();
      setUserFriendList(user, friends);
      addPointByShareFriend(user, friends);
      addPointByVisit(visitors);
      sortPointList();
      getTopThree();
      return result;
    }catch(Exception e){
      return new ArrayList<>(Collections.emptyList());
    }

  }
  static void init(){
    userFriendList = new ArrayList<>(Collections.emptyList());
    pointList = new HashMap<>();
    result = new ArrayList<>(Collections.emptyList());
  }

  static void setUserFriendList(String user, List<List<String>> friends) {
    for (int i = 0; i < friends.size(); i++) {
      List<String> curRelation = friends.get(i);
      int userIndex;
      if ((userIndex = curRelation.indexOf(user)) != -1) {
        //System.out.println(curRelation.get((1 - userIndex)));
        userFriendList.add(curRelation.get((1 - userIndex)));
      }
    }
  }

  static void addPointByShareFriend(String user, List<List<String>> friends) {
    for (int i = 0; i < friends.size(); i++) {
      for (int j = 0; j < 2; j++) {
        String member = friends.get(i).get(j);
        if (member.equals(user)) {
          continue; //나 자신에 대한 점수는 계산하지 않는다.
        }
        String friend = friends.get(i).get(1 - j);  //member와 친구인 유저
        if (userFriendList.contains(friend) && !userFriendList.contains(member)) {
          //동일한 친구를 가지고 있는 경우+이미 친구인 사람은 제외해야 함
          //System.out.println(pointList);
          pointList.merge(member, 10, Integer::sum);
        }

      }
    }
    //System.out.println(pointList);
  }

  static void addPointByVisit(List<String> visitors) {
    for (int i = 0; i < visitors.size(); i++) {
      String member = visitors.get(i);
      if (!userFriendList.contains(member)) { //이미 친구인 사람은 제외해야 함.
        pointList.merge(member, 1, Integer::sum);
      }
    }
    //System.out.println(pointList);
  }

  static void sortPointList() {
    sortedPointList = new LinkedList<>(pointList.entrySet());
    sortedPointList.sort(HashMap.Entry.comparingByKey()); //이름순으로 오름차순 정렬
    Collections.sort(sortedPointList,
        (o1, o2) -> o2.getValue().compareTo(o1.getValue()));  //점수 순으로 내림차순 정렬
  }

  static void getTopThree() {
    for (int i = 0; i < Math.min(5, sortedPointList.size()); i++) {
      result.add(sortedPointList.get(i).getKey());
    }
  }
}
