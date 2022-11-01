package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //친구 리스트
        List<String> friendList = new ArrayList<>();
        friendList.add(user);
        //모든 사람 리스트
        Set<String> peopleList = new HashSet<>();

        collectAllPeopleAndUserFriends(user, friends, visitors, friendList, peopleList);
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void collectAllPeopleAndUserFriends(String user, List<List<String>> friends, List<String> visitors, List<String> friendList, Set<String> peopleList) {
        //친구 및 사람 확인
        for (List<String> friend : friends) {
            if(friend.get(0).equals(user) ){
                friendList.add(friend.get(1));
                peopleList.add(friend.get(1));
            }else if(friend.get(1).equals(user)){
                friendList.add(friend.get(0));
                peopleList.add(friend.get(0));
            }else{
                peopleList.add(friend.get(0));
                peopleList.add(friend.get(1));
            }
        }

        //방문자로 사람 확인
        for (String visitor : visitors) {
            peopleList.add(visitor);
        }
    }

}

