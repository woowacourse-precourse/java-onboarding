package onboarding;

import java.util.*;

/**
 * 기능 목록
 * 1. 사용자의 친구 목록 생성
 * 2. 사용자와 친구가 아닌 목록 생성
 * 3. 점수 규칙에 따라 점수 계산
 * 3-1. 현재 친구가 아닌 친구들을 추가
 * 3-2. 방문자들에 대한 점수 계산
 * 3-3. 현재 서로 아는 친구들에 대한 점수 계산
 * 3-4. 0점인 Entry 제거
 * 3-5. 점수 계산 공통 메소드
 * 4. 주어진 규칙에 따라 정렬 후 결과 반환
 */
public class Problem7 {
    static final int FRIEND_SCORE = 10;
    static final int VISITOR_SCORE = 1;
    static final int MAX_RECOMMEND_COUNT = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = initFriendsList(user, friends);
        List<String> notFriends = getNotFriendsList(user, userFriends, friends, visitors);
        HashMap<String, Integer> scoreMap = countScore(notFriends, friends, visitors);
        return sortScore(scoreMap);
    }

    static List<String> initFriendsList(String user, List<List<String>> friends) {
        HashSet<String> userFriendSet = new HashSet<>();

        for (List<String> friend : friends) {
            if (!friend.contains(user)) continue;

            int userIdx = friend.indexOf(user);
            int friendIdx = (userIdx + 1) % 2;
            userFriendSet.add(friend.get(friendIdx));
        }

        return new ArrayList<>(userFriendSet);
    }

    static List<String> getNotFriendsList(String user, List<String> userFriends, List<List<String>> friends, List<String> visitors) {
        HashSet<String> notFriendSet = new HashSet<>();

        for (List<String> friend : friends) {
            if (!friend.contains(user)) {
                notFriendSet.add(friend.get(0));
                notFriendSet.add(friend.get(1));
            }
        }
        notFriendSet.addAll(visitors); // 중복은 알아서 제거
        userFriends.forEach(notFriendSet::remove);
        return new ArrayList<>(notFriendSet);
    }

    /* 점수 규칙에 따라 점수를 계산 */
    static HashMap<String, Integer> countScore(List<String> notFriends, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoreMap = addAllNotFriends(notFriends);
        countVisitorScore(scoreMap, visitors);
        countFriendsScore(scoreMap, friends);
        removeZeroScore(scoreMap);
        return scoreMap;
    }

    static HashMap<String, Integer> addAllNotFriends(List<String> notFriends) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String notFriend : notFriends) {
            result.put(notFriend, 0);
        }
        return result;
    }

    static void countVisitorScore(HashMap<String, Integer> scoreMap, List<String> visitors) {
        for (String visitor : visitors) {
            if (scoreMap.containsKey(visitor)) addPointScore(scoreMap, visitor, VISITOR_SCORE);
        }
    }

    static void countFriendsScore(HashMap<String, Integer> scoreMap, List<List<String>> friends) {
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            if (scoreMap.containsKey(friendA)) addPointScore(scoreMap, friendA, FRIEND_SCORE);
            if (scoreMap.containsKey(friendB)) addPointScore(scoreMap, friendB, FRIEND_SCORE);
        }
    }

    static void addPointScore(HashMap<String, Integer> scoreMap, String key, int score) {
        int currentScore = scoreMap.get(key);
        scoreMap.put(key, currentScore + score);
    }

    static void removeZeroScore(HashMap<String, Integer> scoreMap) {
        Iterator<String> it = scoreMap.keySet().iterator();
        ArrayList<String> zeroScores = new ArrayList<>();
        while (it.hasNext()) {
            String key = it.next();
            if (scoreMap.get(key) == 0) {
                zeroScores.add(key);
            }
        }
        for (String s : zeroScores) {
            scoreMap.remove(s);
        }
    }

    static List<String> sortScore(HashMap<String, Integer> scoreMap) {
        List<String> keySetList = new ArrayList<>(scoreMap.keySet());
        List<String> result = new ArrayList<>();
        keySetList.sort((o1, o2) -> Integer.compare(scoreMap.get(o2), scoreMap.get(o1)));
        int cnt = 0;
        for (String str : keySetList) {
            if (cnt == MAX_RECOMMEND_COUNT) {
                break;
            }
            result.add(str);
            cnt++;
        }

        return result;
    }
}
