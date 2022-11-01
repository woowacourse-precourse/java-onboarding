package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, List<String>> relation = new HashMap<>();
        HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
        for (int i = 0; i < friends.size(); i++) {

            List<String> friend = friends.get(i);
            // 친구 관계 정리
            connectFriend(friend, relation);

            // 사람 별로 점수 정리 Map 생성
            makeScoreMap(friend, scoreMap);

        }

        // 함께 아는 친구 수 찾아서 점수 주기(10점)
        List<String> myfriend = relation.get(user);
        knowMyFriend(myfriend, relation, scoreMap);

        // 방문자 목록 확인해서 점수 주기(1점)
        checkVisitors(visitors, scoreMap);

        // 추천해줄 친구목록 생성
        List<String> answer = new ArrayList<>();
        recommendFriend(relation.get(user), user, scoreMap, answer);


        return answer;
    }

    // 친구 관계 정리
    public static void connectFriend(List<String> friend, HashMap<String, List<String>> relation) {
        String friend1 = friend.get(0);
        String friend2 = friend.get(1);

        if (relation.containsKey(friend1)) {
            relation.get(friend1).add(friend2);
        } else {
            relation.put(friend1, new ArrayList<>());
            relation.get(friend1).add(friend2);
        }
        if (relation.containsKey(friend2)) {
            relation.get(friend2).add(friend1);
        } else {
            relation.put(friend2, new ArrayList<>());
            relation.get(friend2).add(friend1);
        }

    }

    // 사람 별로 점수 정리해줄 hashMap 생성
    public static void makeScoreMap(List<String> friend, HashMap<String, Integer> scoreMap) {
        String friend1 = friend.get(0);
        String friend2 = friend.get(1);

        if (!scoreMap.containsKey(friend1)) {
            scoreMap.put(friend1, 0);
        }
        if (!scoreMap.containsKey(friend2)) {
            scoreMap.put(friend2, 0);
        }


    }

    // 함께 아는 친구 찾기
    public static void knowMyFriend(List<String> myfriend, HashMap<String, List<String>> relation, HashMap<String, Integer> scoreMap) {

        for (int i = 0; i < myfriend.size(); i++) {

            // 친구의 친구 리스트
            List<String> ffriend = relation.get(myfriend.get(i));
            for (int j = 0; j < ffriend.size(); j++) {
                String friend = ffriend.get(j);
                int value = scoreMap.get(friend);
                // 친구의 친구에게 10점 부여
                scoreMap.put(friend, value + 10);
            }
        }
    }

    // 방문자 목록 확인
    public static void checkVisitors(List<String> visitors, HashMap<String, Integer> scoreMap) {

        for (int i = 0; i < visitors.size(); i++) {
            String friend = visitors.get(i);

            // 방문자에게 1점 부여
            if (!scoreMap.containsKey(friend)) {
                scoreMap.put(friend, 0);
                scoreMap.put(friend, scoreMap.get(friend) + 1);
            } else {
                scoreMap.put(friend, scoreMap.get(friend) + 1);
            }


        }

    }

    // 추천해줄 친구목록 만들기
    public static void recommendFriend(List<String> myFriends, String user, HashMap<String, Integer> scoreMap, List<String> answer) {

        // 5회 반복해서 최대 5명의 친구추천을 받음
        for (int i = 0; i < 5; i++) {
            String maxName = null;
            Integer maxValue = 0;
            Iterator<String> keys = scoreMap.keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next();

                // key가 나일 때 continue
                if (key == user) {
                    continue;
                }

                // key가 이미 내 친구일 때
                if (myFriends.contains(key)) {
                    continue;
                }

                if (scoreMap.get(key)>maxValue) {
                    maxValue = scoreMap.get(key);
                    maxName = key;
                }

            }
            // 친구목록에 0점 이상이 없는 경우 바로 반환
            if (maxValue == 0) {
                return;
            }

            // 친구추천목록에 추가
            answer.add(maxName);

            // 추가시킨 이름은 다시 나오지 않게 0으로 초기화 시켜줌
            scoreMap.put(maxName, 0);

        }


    }
}
