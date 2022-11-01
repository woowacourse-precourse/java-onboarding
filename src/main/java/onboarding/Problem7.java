package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        System.out.println(friends);
        List<String> userFriends = makeFriendsList(user, friends);
        System.out.println(userFriends);
        List<List<String>> recommendFriends = makeRecoFriends(userFriends, friends);
        System.out.println(recommendFriends);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> makeFriendsList(String user, List<List<String>> friends) {
        Set<String> userFriends = new HashSet<>();

        for (List<String> friend : friends) {
            if(friend.contains(user)){ // 친구 관계라면
                userFriends.add(friend.get(0));
                userFriends.add(friend.get(1));
            }
        }
        userFriends.remove(user);
        return new ArrayList<>(userFriends);
    }

    private static List<List<String>> makeRecoFriends(List<String> userFriends, List<List<String>> friends) {
        List<List<String>> list = new ArrayList<>();

        for(String friend : userFriends){
            list.add(makeFriendsList(friend, friends));
        }
        return list;
    }


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

        solution(user, friends, visitors);
    }
}
