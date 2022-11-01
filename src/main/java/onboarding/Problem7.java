package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, Integer> scoreMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = makeFriendsList(user, friends); // 사용자의 친구 목록
        List<List<String>> recommendFriends = makeRecoFriends(userFriends, friends); // 사용자의 친구의 친구 목록

        getFriendsScore(user, recommendFriends);
        getVisitScore(visitors);
        removeAlreadyFriends(userFriends);
        System.out.println(scoreMap);

        List<String> answer = Collections.emptyList();
        answer = sorting(scoreMap);
        return answer;
    }

    private static List<String> sorting(Map<String, Integer> scoreMap) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scoreMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        System.out.println(entryList);
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList){
//            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
            list.add(entry.getKey());
        }

        return list;
    }

    private static List<String> makeFriendsList(String user, List<List<String>> friends) {
        // userFriends의 친구와 recommendFriends의 추천 친구 인덱스를 똑같이하기 위해서 LinkedHashSet를 사용함
        Set<String> userFriends = new LinkedHashSet<>();

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

    private static void getFriendsScore(String user, List<List<String>> recommendFriends) {
        for(List<String> friend : recommendFriends){
            if(friend.contains(user)){ // 친구 관계라면
                int userIndex = friend.indexOf(user);
                getScore(userIndex, friend);
            }
        }
    }

    private static void getScore(int userIndex, List<String> friend) {
        for (int i = 0; i < friend.size(); i++) {
            String friendsName = friend.get(i);

            if(i != userIndex){
                if(!scoreMap.containsKey(friendsName)){ // 추천 친구가 없으면 등록하고, 10점 부여
                    scoreMap.put(friendsName, 10);
                }
                else { // 추천 친구로 있으면 10점 더해주기
                    scoreMap.put(friendsName, scoreMap.get(friendsName) + 10);
                }
            }
        }
    }

    private static void getVisitScore(List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            String friendsName = visitors.get(i);

            if(!scoreMap.containsKey(friendsName)){ // 추천 친구가 없으면 등록하고, 1점 부여
                scoreMap.put(friendsName, 1);
            }
            else { // 추천 친구로 있으면 1점 더해주기
                scoreMap.put(friendsName, scoreMap.get(friendsName) + 1);
            }
        }
    }

    private static void removeAlreadyFriends(List<String> userFriends) {
        for(String friendName : userFriends){
            if(scoreMap.containsKey(friendName))
                scoreMap.remove(friendName);
        }
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
