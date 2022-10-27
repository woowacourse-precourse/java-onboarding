package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // user 의 friend 를 반환하는 userFriendList
        List<String> userFriendList = userFriendList(user, friends);

        // user 의 friend 를 이용하여 user friend 의 friend (친구의 친구) 를 반환하는 friendsFriend
        List<String> friendsFriendList = friendsFriend(userFriendList, friends,user);

        // friendsFriendList, userFriendList, visitors 를 이용하여 recommendFriend 와 점수를 반환하는 recommendMap
        HashMap<String, Integer> recommendMap = recommendMap(friendsFriendList, userFriendList, visitors);

        // recommendMap 의 key 값을 정렬하여 answer 에 반환.
        Arrays.sort(recommendMap.keySet().toArray());

        List<String> answer = new ArrayList<>(recommendMap.keySet());

// 테스트는 통과했지만 정렬을 구현하지 못함.

        return answer;
    }


    // user 의 friend 를 반환.
    static List<String> userFriendList(String user,List<List<String>> friends) {
        List<List<String>> userFriendLists = new ArrayList<>();
        List<String> userFriendList = new ArrayList<>();

        // for 반복문을 통해 user 의 친구를 찾는다.
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                userFriendLists.add(friend);
            }
        }

        // user 와 user 친구 로 이루어진 userFriendLists 에서 user 의 친구 값만 저장.
        for (int i = 0; i < userFriendLists.size(); i++) {
            for (int j = 0; j < userFriendLists.get(i).size(); j++) {
                if (userFriendLists.get(i).get(j) != user) {
                    userFriendList.add(userFriendLists.get(i).get(j));
                }
            }
        }

        return userFriendList;
    }


    // user 의 friend 의 friend (친구의 친구) 를 반환.
    static List<String> friendsFriend(List<String> userFriendList,List<List<String>> friends,String user) {
        List<String> friendsFriend = new ArrayList<>();
        List<List<String>> temp = new ArrayList<>();

        // 주어진 friends 에서 유저의 친구가 포함된 리스트를 temp 에 저장.
        for (List<String> friend : friends) {
            for (String userFriend : userFriendList) {
                if (friend.contains(userFriend)) {
                    temp.add(friend);
                }
            }
        }

        // user 의 친구와 user 친구의 친구가 저장된 temp 에서 user 친구의 친구만 friendsFriend 에 저장.
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < temp.get(i).size(); j++) {
                if (!userFriendList.contains(temp.get(i).get(j)) && !temp.get(i).get(j).equals(user)) {
                    friendsFriend.add(temp.get(i).get(j));
                }
            }
        }

        return friendsFriend;
    }

    // 점수계산을 통해 key 추천유저 , value 점수 를 담은 map 을 반환하는 메서드.
    static HashMap<String, Integer> recommendMap(List<String> friendsFriendList, List<String> userFriendList, List<String> visitors) {

        HashMap<String, Integer> map = new HashMap<>();


        for (String friendsFriend : friendsFriendList) {
            // 유저의 친구가 아닐경우 (친구의친구 , 10점) 을 map 에 추가.
            if (!userFriendList.contains(friendsFriend)) {
                map.put(friendsFriend, 10);
            }

        }

        for (String visitor : visitors) {
            // map 에 이미 추가된 값이고 user 의 친구가 아닐경우
            // map 의 value++;
            if (map.containsKey(visitor) && !userFriendList.contains(visitor)) {
                map.put(visitor,map.get(visitor)+1);
            }
            // map 에 없는 key 값이고 user 의 친구가 아닐경우
            // map 에 (visitor, 1) 추가.
            if (!map.containsKey(visitor)&& !userFriendList.contains(visitor)) {
                map.put(visitor, 1);
            }
        }

        return map;
    }
}
