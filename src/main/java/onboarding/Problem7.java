package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        friendMap(friends);
        return answer;
    }

    //  1. HashMap으로 친구 당 가지는 모든 친구관계를 구성
    public static void friendMap(List<List<String>> friends) {
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
        System.out.println(friendRelation);
    }



}

//  2. 사용자가 가지는 친구 관계와 같은 친구를 뽑음.
//  3.친구 별로 사용자와 같은 친구 하나당 10을 추가하는 hashmap 생성
//  visitors는 1점 추가
//  4.hash 맵에서 밸류값이 높은 순서대로 뽑는데 같은 밸류값 뽑아서
//  일단 이름순으로 list에 삽입 5명되면 break
