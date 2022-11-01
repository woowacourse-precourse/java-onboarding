package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    // user의 친구 찾기
    public static List<String> findUserFriend(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                for (String name : friends.get(i)) {
                    if (!name.equals(user)) friendList.add(name);
                }
            }
        }
        return friendList;
    }
    // user의 친구의 친구찾기
    public static List<String> findLinkedFriends(String user, List<List<String>> friends, List<String> friendList) {
        List<String> linkedFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friendList.contains(friends.get(i).get(0)) || friendList.contains(friends.get(i).get(1))) {
                for (String name : friends.get(i)) {
                    if (!name.equals(user) && !friendList.contains(name)) {
                        linkedFriends.add(name);
                    }
                }
            }
        }
        return linkedFriends;
    }
    // 중복제거
    public static List<String> removeDuplication(List<String> friendList, List<String> visitors) {
        List<String> editVisitor = new ArrayList<>(visitors);
        for (String friend : friendList) {
            if (visitors.contains(friend)) {
                editVisitor.remove(friend);
            }
        }
        return editVisitor;

    }
    // 점수
    public static HashMap<String,Integer> calculateScore(HashMap<String,Integer> recommendFriends, List<String> people, int score){
        for(String person: people){
            if(!recommendFriends.containsKey(person)) {
                recommendFriends.put(person,score);
            } else{
                int temp = recommendFriends.get(person) + score;
                recommendFriends.replace(person, temp);
            }
        }
        return recommendFriends;
    }
    // 정렬
    public static List<Map.Entry<String, Integer>> sortList(HashMap<String,Integer>recommendFriends){
        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(recommendFriends.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        return entryList;
    }
    // map -> list
    public static List<String> mapToList(List<Map.Entry<String,Integer>> recommendPeople){
        List<String> finalRecommendFriends = new ArrayList<>();
        for(Map.Entry<String, Integer> person: recommendPeople){
            finalRecommendFriends.add(person.getKey());
        }
        return finalRecommendFriends;
    }





}