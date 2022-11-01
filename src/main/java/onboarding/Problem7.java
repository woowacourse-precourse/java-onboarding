package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Set<String>> friendList = new HashMap<>();

        if (validData(user, friends, visitors)) {
            friendList = organizeFriendList(friends, visitors);
            answer = recommendFriend(user, friendList, visitors);
        }
        /*else {
            //answer.add(0,"데이터가 적합하지 않습니다");
        }*/

        return answer;
    }

    // 데이터 검증 메소드
    private static boolean validData(String user, List<List<String>> friends, List<String> visitors) {
        boolean isValid = true;

        // 사용자 아이디 정규표현식
        String userIdPattern = "^[a-z]+$";

        // 매개변수들의 데이터 길이를 검증
        if (user.length() > 30 || friends.size() > 10000 || visitors.size() > 10000) {
            isValid = false;
        }

        // 2차원 리스트에 있는 아이디들의 길이와 대문자 특문 포함여부 검증
        for (List<String> friendRelation : friends) {
            for (String userId : friendRelation) {
                if (userId.length() > 30) {
                    isValid = false;
                    break;
                }
                if (!(Pattern.matches(userIdPattern, userId))) {
                    isValid = false;
                    break;
                }
            }
        }

        return isValid;
    }

    // 친구 관계 정리 메소드
    private static Map<String, Set<String>> organizeFriendList(List<List<String>> friends, List<String> visitors) {
        // 친구 관계를 저장하기 위한 HashMap 생성
        Map<String, Set<String>> userFriendList = new HashMap<>();

        // 2차원 List의 친구 관계 정보를 순회하며 각 사용자의 친구목록을 생성
        for (List<String> friendRelation : friends) {
            String[] userIdArray = {friendRelation.get(0), friendRelation.get(1)};

            Set<String> temp;

            for (int i = 0; i < 2; i ++) {
                if (userFriendList.containsKey(userIdArray[i])) {
                    temp = userFriendList.get(userIdArray[i]);
                } else {
                    temp = new HashSet<>();
                }

                if (i == 0) {
                    temp.add(userIdArray[1]);
                } else {
                    temp.add(userIdArray[0]);
                }

                userFriendList.put(userIdArray[i], temp);
            }

            for (String visitor: visitors) {
                if (!(userFriendList.containsKey(visitor))) userFriendList.put(visitor, new HashSet<>());
            }
        }

        return userFriendList;
    }

    // 추천 친구 결정 메소드
    private static List<String> recommendFriend(String user, Map<String, Set<String>> friendList,
                                                List<String> visitors) {
        Set<String> usersFriend = friendList.get(user);
        Map<String, Integer> candidateCount = new HashMap<>();
        List<String> tempList = new ArrayList<>();

        for (Map.Entry<String, Set<String>> entry : friendList.entrySet()) {
            String key = entry.getKey();
            Set<String> value = entry.getValue();
            int score = 0;

            if (visitors.contains(key)) score += 1;

            if (!(Objects.equals(key, user))) {
                for (String temp: usersFriend) {
                    for (String temp2: value) {
                        if (Objects.equals(temp, temp2)) score += 10;
                    }
                }
            }

            candidateCount.put(key, score);
        }

        List<Map.Entry<String, Integer>> entries =
                candidateCount.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                        .collect(Collectors.toList());

        for (Map.Entry<String, Integer> entry : entries) {
            if (!(usersFriend.contains(entry.getKey())) && (entry.getValue() > 0)) {
                tempList.add(entry.getKey());
            }
        }

        return tempList;
    }
}
