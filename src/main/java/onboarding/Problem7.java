package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static HashMap<String, Integer> recommendFriend;
    public static List<List<String>> friends;
    public static List<String> userFriends;
    public static List<String> visitors;
    public static String user;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7.recommendFriend = new HashMap<>();
        Problem7.friends = friends;
        Problem7.userFriends = new ArrayList<>();
        Problem7.visitors = visitors;
        Problem7.user = user;
        findUserFriend();
        findAquaintFriend();
        findVisitor();
        deleteUserFriend();
        return sortScore();
    }

    // user의 친구 userFriend에 저장
    public static void findUserFriend() {
        for (List<String> friend : friends) {
            if (user.equals(friend.get(0))) {
                userFriends.add(friend.get(1));
            }
            if (user.equals(friend.get(1))) {
                userFriends.add(friend.get(0));
            }
        }
    }

    // 친구의 친구 찾기 및 score +10 저장
    public static void findAquaintFriend() {
        int recommendScore = 10;
        for (String userFriend : userFriends)
            for (List<String> friend : friends) {
                String idA = friend.get(0);
                String idB = friend.get(1);
                if (idA.contains(userFriend) && !idB.equals(user) && !idB.equals(userFriend)) {
                    if (recommendFriend.containsKey(idB)) {
                        recommendFriend.replace(idB, (recommendFriend.get(idB) + recommendScore));
                    } else {
                        recommendFriend.put(idB, recommendScore);
                    }
                }
                if (idB.contains(userFriend) && !idA.equals(user) && !idA.equals(userFriend)) {
                    if (recommendFriend.containsKey(idA)) {
                        recommendFriend.replace(idA, (recommendFriend.get(idA) + recommendScore));
                    } else {
                        recommendFriend.put(idA, recommendScore);
                    }
                }
            }
    }

    // 방문자 찾기 및 score +1 저장
    public static void findVisitor() {
        int visitorScore = 1;
        for (String visitor : visitors) {
            if (recommendFriend.containsKey(visitor)) {
                recommendFriend.replace(visitor, recommendFriend.get(visitor) + visitorScore);
            } else {
                recommendFriend.put(visitor, visitorScore);
            }
        }
    }

    // 저장된 친구들 중 userFriend 삭제
    public static void deleteUserFriend() {
        for (String s : userFriends) {
            recommendFriend.remove(s);
        }
    }

    // 점수 내림차순, 이름 오름차순 정렬
    public static List<String> sortScore() {
        List<String> answer = new ArrayList<>();
        List<String> listKeySet = new ArrayList<>(recommendFriend.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (recommendFriend.get(value2).compareTo(recommendFriend.get(value1))));
        for (String key : listKeySet) {
            answer.add(key);
            if (answer.size() == 5) break;
            if (recommendFriend.get(key) == 0) break;
        }
        return answer;
    }
}