package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

//        compareFriend(user,friendMap(friends));
        HashMap<String, Integer> addCountIns = addCount(compareFriend(user, friendMap(friends)), friendMap(friends), visitors,user);
        friendResult(addCountIns);
        List<String> answer = friendResult(addCountIns);
        return answer;
    }

    //  1. HashMap으로 친구 당 가지는 모든 친구관계를 구성
    public static HashMap<String, List<String>> friendMap(List<List<String>> friends) {
        HashMap<String, List<String>> friendRelation = new HashMap<>();
        for (List<String> friend : friends) {
            if (friendRelation.containsKey(friend.get(0))) {
                List<String> friednVal = friendRelation.get(friend.get(0));
                friednVal.add(friend.get(1));
                friendRelation.remove(friend.get(0));
                friendRelation.put(friend.get(0), friednVal);
            }if (friendRelation.containsKey(friend.get(1))) {
                List<String> friednVal = friendRelation.get(friend.get(1));
                friednVal.add(friend.get(0));
                friendRelation.remove(friend.get(1));
                friendRelation.put(friend.get(1), friednVal);
            }if (!(friendRelation.containsKey(friend.get(1)))) {
                List<String> friednVal = new ArrayList<>();
                friednVal.add(friend.get(0));
                friendRelation.put(friend.get(1), friednVal);
            }if (!(friendRelation.containsKey(friend.get(0)))) {
                List<String> friednVal = new ArrayList<>();
                friednVal.add(friend.get(1));
                friendRelation.put(friend.get(0), friednVal);
            }
        }
        return friendRelation;
    }

    //  2. 사용자가 가지는 친구 관계와 같은 친구를 뽑음.
    public static List<String> compareFriend(String user, HashMap<String, List<String>> friendRelation) {
        /*사용자와 겹치는 친구를 리스트에 넣음.*/
        List<String> findFriend = new ArrayList<>();
        if (friendRelation.containsKey(user)) {
            findFriend.addAll(friendRelation.get(user));
        }
        return findFriend;
    }

}





