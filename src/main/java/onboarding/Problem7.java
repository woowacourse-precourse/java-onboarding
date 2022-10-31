package onboarding;

import java.util.*;

/*
* 기능 목록
* 1. 친구 관계 저장
* 2. 함께 아는 친구 점수 계산
* 3. 타임라인에 방문한 횟수 점수 계산
* 4. 점수가 높은 인원 최대 5명까지 구하기
* */
public class Problem7 {

    public static Map<String, List<String>> friendMap;
    public static Map<String, Integer> scoreMap;

    // 친구 관계 저장
    public static void addFriend(String friend1, String friend2) {
        if (friendMap.containsKey(friend1)) {
            friendMap.get(friend1).add(friend2);
        } else {
            friendMap.put(friend1, new ArrayList<>(List.of(friend2)));
        }
        if (friendMap.containsKey(friend2)) {
            friendMap.get(friend2).add(friend1);
        } else {
            friendMap.put(friend2, new ArrayList<>(List.of(friend1)));
        }
    }

    // 함께 아는 친구 점수 계산
    public static void getScoreFromSameFriend(String user) {
        List<String> myFriends = new ArrayList<>();
        if (friendMap.containsKey(user)) {
            myFriends = friendMap.get(user);
        }
        for (String friend : friendMap.keySet()) {
            // 이미 친구인 경우 추천하지 않음
            if (myFriends.contains(friend)) continue;
            // 자신인 경우
            if (user.equals(friend)) continue;

            int score = 0;
            for (String person : friendMap.get(friend)) {
                if (myFriends.contains(person)) {
                    score += 10;
                }
            }
            scoreMap.put(friend, score);
        }
    }
    // 타임라인에 방문한 횟수 점수 계산
    public static void getScoreFromTimeline(String user, List<String> visitors) {
        List<String> myFriends = new ArrayList<>();
        if (friendMap.containsKey(user)) {
            myFriends = friendMap.get(user);
        }
        for (String visitor : visitors) {
            // 이미 친구인 경우 추천하지 않음
            if (myFriends.contains(visitor)) continue;

            if (scoreMap.containsKey(visitor)) {
                scoreMap.put(visitor, scoreMap.get(visitor)+1);
            } else {
                scoreMap.put(visitor, 1);
            }
        }
    }
    // 점수가 높은 인원 최대 5명까지 구하기
    private static List<String> getRecommendedFriendList() {
        List<String> answer = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scoreMap.entrySet());
        // 점수순 내림차순, 이름 오름차순으로 정렬
        entryList.sort((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                return e1.getKey().compareTo(e2.getKey());
            } else {
                return e1.getValue().compareTo(e2.getValue())*(-1);
            }
        });

        // 최대 5명
        for (int i = 0; i < 5 && i < entryList.size(); i++) {
            Map.Entry<String, Integer> entry = entryList.get(i);
            // 최종 점수가 0이 아니면 추가
            if (entry.getValue() != 0) {
                answer.add(entry.getKey());
            }
        }
        return answer;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendMap = new HashMap<>();
        scoreMap = new HashMap<>();

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            addFriend(friend1, friend2);
        }

        getScoreFromSameFriend(user);
        getScoreFromTimeline(user, visitors);

        return getRecommendedFriendList();
    }
}
