package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<List<String>> notFriendList = new ArrayList<>();
        HashSet<String> friendList = new HashSet<>();
        HashMap<String, Integer> recommendFriendScore = new HashMap<>();
        Problem7 problem = new Problem7();

        // 주어진 friends 관계도에서 user와 친구인 사람, 친구가 아닌 사람들의 관계끼리 자료 분리
        friends.forEach((relationship) -> {
            String person1 = relationship.get(0);
            String person2 = relationship.get(1);

            if (Objects.equals(person1, user)) {
                friendList.add(person2);
            } else if (Objects.equals(person2, user)) {
                friendList.add(person1);
            } else {
                notFriendList.add(relationship);
            }
        });

        // 친구가 아닌 user인 경우, 관련된 친구 수 만큼 점수 계산
        notFriendList.forEach((connection) -> {
            String person1 = connection.get(0);
            String person2 = connection.get(1);

            if (friendList.contains(person1)) {
                problem.getScoreByConnection(recommendFriendScore, person2);
            }

            if (friendList.contains(person2)) {
                problem.getScoreByConnection(recommendFriendScore, person1);
            }
        });

        // 방문 수 만큼 점수 계산
        List<String> visitConnections = visitors.stream().filter(x -> !friendList.contains(x)).collect(Collectors.toList());
        problem.getScoreByVisits(recommendFriendScore, visitConnections);

        // 점수 별로 정렬한 후 유저 이름대로 해시맵 정렬
        HashMap<String, Integer> sortedFriendsList = problem.sortbyScoreThenName(recommendFriendScore);

        // 맵에서 key값만 가져오기
        Set<String> keySet = sortedFriendsList.keySet();
        ArrayList<String> recommendUserList = new ArrayList<>(keySet);

        return problem.HeadCountLimit(recommendUserList, 5);
    }

    public void getScoreByConnection (HashMap<String, Integer> scoreList, String person) {
        int score = 10;
        if (!scoreList.containsKey(person)) {
            scoreList.put(person, score);
        } else {
            scoreList.put(person, scoreList.get(person) + score);
        }
    }

    public void getScoreByVisits(HashMap<String, Integer> scoreList, List<String> visitList) {
        int score = 1;
        visitList.forEach((visitor) -> {
            if (!scoreList.containsKey(visitor)) {
                scoreList.put(visitor, score);
            } else {
                scoreList.put(visitor, scoreList.get(visitor) + score);
            }
        });
    }

    public HashMap<String, Integer> sortbyScoreThenName(HashMap<String, Integer> unsortedList) {
        HashMap<String, Integer> sortedList = unsortedList
                .entrySet()
                .stream()
                .sorted(Collections
                        .reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (newValue, oldValue) -> oldValue, LinkedHashMap::new));

        return sortedList;
    }

    public List<String> HeadCountLimit(List<String> list, int limit) {
        if (list.size() <= limit) {
            return list;
        } else {
            return list.subList(0, limit);
        }
    }
}
