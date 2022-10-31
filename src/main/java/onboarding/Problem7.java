package onboarding;

import java.util.*;


public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friendsOfUser = new ArrayList<>();
        HashMap<String, Integer> recommendFriendsScore = new HashMap<>();

//먼저 HashMap에서 user의 친구를 조사한다.
        for(int i = 0; i < friends.size(); i++) {
            if(friends.get(i).contains(user)){
                for(int j = 0; j < friends.get(i).size(); j++) {
                    if(!friends.get(i).get(j).equals(user)) {
                        friendsOfUser.add(friends.get(i).get(j));
                    }
                }
            }
        }
//먼저 HashMap에서 user의 친구의 친구를 추천 후보로 넣는다.
        for(int k = 0; k < friends.size(); k++) {
            for(int n = 0; n < friendsOfUser.size(); n++) {
                if(friends.get(k).contains(friendsOfUser.get(n)) && !friends.get(k).contains(user)) {
                    for (int l = 0; l < friends.get(k).size(); l++) {
                        if (!friendsOfUser.contains(friends.get(k).get(l))) {
                            recommendFriendsScore.put(friends.get(k).get(l), recommendFriendsScore.containsKey(friends.get(k).get(l)) ? recommendFriendsScore.get(friends.get(k).get(l)) + 10: 10);
                        }
                    }
                }
            }
        }

//visitors의 친구를 추천후보로 넣는다.
        for(int i = 0; i < visitors.size(); i++) {
            if(!visitors.get(i).equals(user) && !friendsOfUser.contains(visitors.get(i))) {
                if(recommendFriendsScore.containsKey(visitors.get(i))) {
                    recommendFriendsScore.put(visitors.get(i), recommendFriendsScore.get(visitors.get(i)) + 1);
                } else {
                    recommendFriendsScore.put(visitors.get(i), 1);
                }
            }
        }

//hashmap을 arraylist로 변경
        List<String> mapkey = new ArrayList<>(recommendFriendsScore.keySet());
//mapkey를 이름에 따라서 정렬
        Collections.sort(mapkey);
//mapkey를 value 값에 따라서 정렬
        mapkey.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return recommendFriendsScore.get(o2).compareTo(recommendFriendsScore.get(o1));
            }
        });

//mapkey의 길이가 5가 넘을 때, 인덱스 0부터 4까지로 변경해줌.
        if(mapkey.size() > 5) {
            answer = mapkey.subList(0, 5);
        } else {
            answer = mapkey;
        }

        return answer;
    }
}
