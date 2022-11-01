package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Set<String> getUserFriends(String user, List<List<String>> friends){
        Set<String> userFriends = new HashSet<>();

        for (List<String> friendList : friends){
            if(friendList.contains(user)){
                for (String friend : friendList){
                    if(!friend.equals(user)){
                        userFriends.add(friend);
                    }
                }
            }
        }

        return userFriends;
    }

    // 모든 사용자를 가진 맵 반환 (키: 사용자, 밸류: 점수(초기값 0))
    public Map<String, Integer> getPeopleMap(List<List<String>> friends, List<String> visitors){
        Map<String, Integer> allPeople = new HashMap<>();

        for (List<String> friendsList : friends){
            for (String friend : friendsList){
                if(!allPeople.containsKey(friend)){
                    allPeople.put(friend, 0);
                }
            }
        }

        for (String visitor : visitors){
            if(!allPeople.containsKey(visitor)){
                allPeople.put(visitor, 0);
            }
        }

        return allPeople;
    }


}
