package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // user 의 friend 를 반환하는 userFriendList
        List<String> userFriendList = userFriendList(user, friends);

        // user 의 friend 를 이용하여 user friend 의 friend (친구의 친구) 를 반환하는 friendsFriend
        List<String> friendsFriendList = friendsFriend(userFriendList, friends, user);

        // friendsFriendList, userFriendList, visitors 를 이용하여 recommendFriend 와 점수를 반환하는 recommendMap
        HashMap<String, Integer> recommendMap = recommendMap(friendsFriendList, userFriendList, visitors);

        // sortRecommendMap 을 사용하여
        // 1. 추천 점수순으로 정렬
        // 2. 점수가 같다면 이름순으로 정렬
        // 3. 최대 5개의 result 를 리턴
        return sortRecommendMap(recommendMap);
    }


    // user 의 friend 를 반환.
    static List<String> userFriendList(String user, List<List<String>> friends) {
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
    static List<String> friendsFriend(List<String> userFriendList, List<List<String>> friends, String user) {
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
            // Fix !!
            // 유저의 친구가 아니고
            if (!userFriendList.contains(friendsFriend)) {
                // map 에 이미 포함된 key 일경우 value += 10
                if (map.containsKey(friendsFriend)) {
                    map.put(friendsFriend, map.get(friendsFriend) + 10);
                }
                // map 에 포함된 key 가 아닐경우 value = 10;
                if (!map.containsKey(friendsFriend)) {
                    map.put(friendsFriend, 10);
                }

            }
        }

        for (String visitor : visitors) {
            // map 에 이미 추가된 값이고 user 의 친구가 아닐경우
            // map 의 value++;
            if (map.containsKey(visitor) && !userFriendList.contains(visitor)) {
                map.put(visitor, map.get(visitor) + 1);
            }
            // map 에 없는 key 값이고 user 의 친구가 아닐경우
            // map 에 (visitor, 1) 추가.
            if (!map.containsKey(visitor) && !userFriendList.contains(visitor)) {
                map.put(visitor, 1);
            }
        }

        return map;
    }

    // key 추천친구 value 추천점수 로 이루어진 map 을 점수순으로 점수가 같다면 이름순으로 정렬하는 메서드.
    static List<String> sortRecommendMap(HashMap<String, Integer> map) {
        List<String> answer = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> {
            if (o1.getValue() != o2.getValue()) {
                return o2.getValue() - o1.getValue();
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        int cnt = 0;

        for (Map.Entry<String, Integer> e : entryList) {
            if (cnt == 5) {
                break;
            }
            answer.add(e.getKey());
            cnt++;
        }

        return answer;
    }
}
