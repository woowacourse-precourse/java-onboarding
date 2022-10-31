package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // HashMap에 아이디 & 점수 초기화
        HashMap<String, Integer> recommendFds = initRecommendFriends(friends, visitors);

        // user와 이미 친구인 사람들 목록
        Set<String> alreadyFds = getAlreadyFriends(user, friends);

        // user의 친구(alreadyFds)와 친구인 사람 찾아서 10점씩 점수 추가
        addFriendsScore(friends, alreadyFds, recommendFds);
        // visitors에 있는 사람들 1점씩 점수 추가
        addVisitorsScore(visitors, recommendFds);

        // user, user의 친구, 점수가 0점인 사람 제거
        removeRecommendFriends(user, alreadyFds, recommendFds);

        // 정렬 (점수 내림차순, 점수 같을 시 이름 오름차순)
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(recommendFds.entrySet());
        sortScore(entryList);

        return getTop5(entryList);
    }

    public static HashMap<String, Integer> initRecommendFriends(List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> recommendFds = new HashMap<>();

        for (List<String> friend : friends) {
            recommendFds.put(friend.get(0), 0);
            recommendFds.put(friend.get(1), 0);
        }
        for (String visitor : visitors) recommendFds.put(visitor, 0);

        return recommendFds;
    }

    public static Set<String> getAlreadyFriends(String user, List<List<String>> friends) {
        Set<String> alreadyFds = new HashSet<>();

        for (List<String> fd : friends) {
            String id1 = fd.get(0);
            String id2 = fd.get(1);

            if (id1.equals(user)) alreadyFds.add(id2);
            else if (id2.equals(user)) alreadyFds.add(id1);
        }

        return alreadyFds;
    }

    public static void addFriendsScore(List<List<String>> friends, Set<String> alreadyFds, HashMap<String, Integer> recommendFds) {
        for (List<String> fd : friends) {
            String id1 = fd.get(0);
            String id2 = fd.get(1);

            for (String alreadyFd : alreadyFds) {
                if (id1.equals(alreadyFd)) recommendFds.put(id2, recommendFds.get(id2) + 10);
                else if (id2.equals(alreadyFd)) recommendFds.put(id1, recommendFds.get(id1) + 10);
            }
        }
    }

    public static void addVisitorsScore(List<String> visitors, HashMap<String, Integer> recommendFds) {
        for (String visitor : visitors) {
            recommendFds.put(visitor, recommendFds.get(visitor) + 1);
        }
    }

    public static void removeRecommendFriends(String user, Set<String> alreadyFds, HashMap<String, Integer> recommendFds) {
        // 사용자 제거
        recommendFds.remove(user);

        // 사용자의 친구 제거
        for (String fd : alreadyFds) recommendFds.remove(fd);

        // 점수가 0점인 사람 제거
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : recommendFds.entrySet()) {
            if (recommendFds.get(entry.getKey()) == 0) keys.add(entry.getKey());
        }
        for (String key : keys) recommendFds.remove(key);
    }

    public static void sortScore(List<Map.Entry<String, Integer>> entryList) {
        entryList.sort((o1, o2) -> {
            if (Objects.equals(o2.getValue(), o1.getValue())) return o1.getKey().compareTo(o2.getKey());
            return o2.getValue() - o1.getValue();
        });
    }

    public static List<String> getTop5(List<Map.Entry<String, Integer>> entryList) {
        List<String> top5 = new ArrayList<>();
        int i = 0;

        for (Map.Entry<String, Integer> entry : entryList) {
            if (i == 5) break;
            top5.add(entry.getKey());
            i++;
        }

        return top5;
    }
}