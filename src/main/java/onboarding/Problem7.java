package onboarding;

import java.util.*;

public class Problem7 {
    /**
     * 기능 구현
     * 1. user와 이미 친구인 사람을 찾기
     * 2. user의 친구와 친구인 사람을 찾기
     * 3. 사용자와 함께 아는 친구 점수
     * 4. 사용자의 타임 라인에 방문한 횟수
     * 5. 결과값 정렬, 5개 제한
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 1.
        List<String> alreadyFriends = findAlreadyFriend(user, friends);

        // 2.
        List<String> newFriends = findNewFriend(user, friends, alreadyFriends);

        // 3.
        Map<String, Integer> scoreMap = giveFriendScore(newFriends);

        // 4.
        giveVisitedScore(visitors, scoreMap, alreadyFriends);

        // 5.
        List<String> answer = new ArrayList<>(scoreMap.keySet());
        answer.sort((o1, o2) -> scoreMap.get(o2).compareTo(scoreMap.get(o1)));

        if (answer.size() > 5) {
            answer = answer.subList(0, 6);
        }

        return answer;
    }

    // 1. user와 이미 친구인 사람을 찾는 메서드
    private static List<String> findAlreadyFriend(String user, List<List<String>> friends) {
        List<String> alreadyFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(1).equals(user)) {
                alreadyFriends.add(friend.get(0));
            }
        }
        return alreadyFriends;
    }

    // 2. user의 친구와 친구인 사람을 찾는 메서드
    private static List<String> findNewFriend(String user, List<List<String>> friends, List<String> alreadyFriends) {
        List<String> newFriends = new ArrayList<>();
        for (String alFriend : alreadyFriends) {
            for (List<String> friend : friends) {
                if (alFriend.equals(friend.get(0)) && !friend.get(1).equals(user)) {
                    newFriends.add(friend.get(1));
                }
            }
        }
        return newFriends;
    }

    // 3. 사용자와 함께 아는 친구 점수 메서드
    private static Map<String, Integer> giveFriendScore(List<String> newFriends) {
        Map<String, Integer> scoreMap = new HashMap<>();
        for (String name : newFriends) {
            if (!scoreMap.containsKey(name)) {
                scoreMap.put(name, 10);
            }else {
                int score = scoreMap.get(name) + 10;
                scoreMap.replace(name, score);
            }
        }
        return scoreMap;
    }

    // 4. 사용자의 타임 라인에 방문한 횟수 메서드
    private static void giveVisitedScore(List<String> visitors, Map<String, Integer> scoreMap, List<String> alreadyFriends) {
        for (String visitor : visitors) {
            if (!scoreMap.containsKey(visitor) && !alreadyFriends.contains(visitor)) {
                scoreMap.put(visitor, 1);
            }else if (scoreMap.containsKey(visitor) && !alreadyFriends.contains(visitor)) {
                int score = scoreMap.get(visitor) + 1;
                scoreMap.replace(visitor, score);
            }
        }
    }
}
