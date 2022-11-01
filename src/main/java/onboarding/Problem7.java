package onboarding;

import java.util.*;

public class Problem7 {
    /*
        기능 요구 사항 목록
        1. 사용자의 친구 리스트 반환 함수
        2. 친구의 친구 점수 해시맵 반환 함수
        3. 방문자 점수 해시맵 반환 함수
        4. 해시맵 정렬 함수
        5. solution 함수
    */

    static int ACQ_SCORE = 10;
    static int VISIT_SCORE = 1;

    // 사용자의 친구 반환 함수
    private static String userInRelation(String user, List<String> relationship) {
        if (relationship.contains(user)) {
            int userIndex = relationship.indexOf(user); // 사용자의 인덱스
            int friendIndex = 1 - userIndex;            // 사용자 친구의 인덱스
            return relationship.get(friendIndex);
        }
        return null;
    }

    // 해시맵에 값 추가
    private static HashMap<String, Integer> addKeyToMap(
            HashMap<String, Integer> recommend,
            String person,
            Integer score
    ) {
        if (!recommend.containsKey(person))
            recommend.put(person, score);
        else
            recommend.put(person, recommend.get(person) + score);
        return recommend;
    }

    // 사용자의 친구 리스트 반환 함수
    private static List<String> userFriends(String user, List<List<String>> friendDb) {
        List<String> friends = new ArrayList<>(List.of());

        for (List<String> relationship : friendDb) {
            String userFriend = userInRelation(user, relationship);
            if (userFriend != null) friends.add(userFriend);
        }
        return friends;
    }

    // 한 관계에 친구의 친구가 있는지 확인
    private static HashMap<String, Integer> friendOfFriend(
            List<String> userFriends,
            List<String> relationship,
            HashMap<String, Integer> recommend
    ) {
        for (String friend : userFriends) {
            String acquaintance = userInRelation(friend, relationship);
            if (acquaintance == null) continue;

            // 친구의 친구를 알아내면 해시맵에 점수와 함께 추가
            addKeyToMap(recommend, acquaintance, ACQ_SCORE);
        }
        return recommend;
    }

    // 친구의 친구 점수
    private static HashMap<String, Integer> acqScore(
            String user,
            List<List<String>> db,
            List<String> userFriends
    ) {
        HashMap<String, Integer> recommend = new HashMap<>();

        for (List<String> relationship : db) {
            if (relationship.contains(user)) continue;
            friendOfFriend(userFriends, relationship, recommend);
        }
        return recommend;
    }

    // (친구의 친구 점수 +) 방문자 점수
    private static HashMap<String, Integer> visitorScore(
            HashMap<String, Integer> recommend,
            List<String> visitors,
            List<String> userFriends
    ) {
        for (String visitor : visitors) {
            if (userFriends.contains(visitor)) continue;
            addKeyToMap(recommend, visitor, VISIT_SCORE);
        }
        return recommend;
    }

    // 해시맵 정렬
    private static HashMap<String, Integer> sortRecommend(HashMap<String, Integer> recommend) {
        // 사전순 정렬
        recommend.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey());
        // 점수순 정렬
        recommend.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey());

        return recommend;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = userFriends(user, friends);
        HashMap<String, Integer> acq = acqScore(user, friends, userFriends);
        HashMap<String, Integer> recommend = visitorScore(acq, visitors, userFriends);
        HashMap<String, Integer> sorted = sortRecommend(recommend);
        List<String> answer = new ArrayList<>(sorted.keySet());
        return answer;
    }
}
