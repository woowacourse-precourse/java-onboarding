package onboarding;

import org.assertj.core.util.Lists;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, Set<String>> friendsMap = new HashMap<>();
        HashMap<String, Integer> recommendScore = new HashMap<>();

        // 친구 관계 데이터 저장
        for (int i = 0; i < friends.size(); i++) {
            String a = friends.get(i).get(0);
            String b = friends.get(i).get(1);

            Set<String> aFriends = friendsMap.getOrDefault(a, new HashSet<>());
            Set<String> bFriends = friendsMap.getOrDefault(b, new HashSet<>());

            aFriends.add(b);
            bFriends.add(a);

            friendsMap.put(a, aFriends);
            friendsMap.put(b, bFriends);
        }

        // 함께 아는 친구 점수
        Set<String> userFriends = friendsMap.getOrDefault(user, new HashSet<>());
        for (String friend: userFriends) {
            Set<String> recommendFriends = friendsMap.get(friend);
            recommendFriends.remove(user);

            for (String recommendFriend : recommendFriends) {
                recommendScore.put(recommendFriend, recommendScore.getOrDefault(recommendFriend, 0) + 10);
            }
        }

        // 방문 횟수 점수
        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                recommendScore.put(visitor, recommendScore.getOrDefault(visitor, 0) + 1);
            }
        }

        // 리스트에 담아서 정렬
        List<List<String>> recommendList = new ArrayList<>();

        for (String key : recommendScore.keySet()) {
            recommendList.add(Arrays.asList(key, Integer.toString(recommendScore.get(key))));
        }
        Collections.sort(recommendList, (o1, o2) -> {
            if (o1.get(1).equals(o2.get(1))) {
                return o1.get(0).compareTo(o2.get(0));
            } else {
                return Integer.parseInt(o2.get(1)) - Integer.parseInt(o1.get(1));
            }
        });

        // 예외 처리
        if(recommendList.size() > 5) {
            recommendList = Lists.newArrayList(recommendList.subList(0, 5));
        }

        // 이름만 answer에 담기
        for (int i = 0; i < recommendList.size(); i++) {
            answer.add(recommendList.get(i).get(0));
        }

        return answer;
    }
}
