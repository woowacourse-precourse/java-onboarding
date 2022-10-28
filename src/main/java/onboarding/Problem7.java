package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();

        // user 의 friend 를 반환하는 userFriendList
        List<String> userFriendList = userFriendList(user, friends);

        // user 의 friend 를 이용하여 user friend 의 friend (친구의 친구) 를 반환하는 friendsFriend
        List<String> friendsFriendList = friendsFriend(userFriendList, friends,user);

        // friendsFriendList, userFriendList, visitors 를 이용하여 recommendFriend 와 점수를 반환하는 recommendMap
        // sortByValue 를 사용하여 map 의 value 값을 기준으로 정렬한다.
        HashMap<String, Integer> recommendMap = sortByValue(recommendMap(friendsFriendList, userFriendList, visitors));

        // 정렬한 recommentMap 의 키값을 answer List 로 return;
        answer.addAll(recommendMap.keySet());

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
            // Fix !!
            if (!userFriendList.contains(friendsFriend)) {

                if (map.containsKey(friendsFriend)) {
                    map.put(friendsFriend,map.get(friendsFriend)+10);
                }
                if (!map.containsKey(friendsFriend)) {
                    map.put(friendsFriend, 10);
                }

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

    // key 추천친구 value 추천점수 로 이루어진 map 을 점수순으로 점수가 같다면 이름순으로 정렬하는 메서드.
    static HashMap<String, Integer> sortByValue(HashMap<String, Integer> map) {

    // value 를 기준으로 map 을 정렬.
        HashMap<String, Integer> recomandMap
                = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        return recomandMap;
    }
}
