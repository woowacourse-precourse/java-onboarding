package onboarding;

import java.util.*;

public class Problem7 {

    /**
     * 추천할 친구 제한 수
     */
    static final int FRIEND_RECOMMEND_LIMIT = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 친구 추천 점수 Map<이름, 점수>
        Map<String, Integer> scores = new HashMap<>();
        // 친구 관계 Map<이름, 친구 리스트>
        Map<String, List<String>> relations = new HashMap<>();
        // 내 친구 Set
        Set<String> myFriends = new HashSet<>();
        // Map의 Key로 정렬하기 위한 List
        List<Map.Entry<String, Integer>> entryList = null;
        // 결과 List
        List<String> result = new ArrayList<>();

        myFriends.add(user);
        initVisitors(visitors, scores);

        for (List<String> friend : friends) {
            String name1 = friend.get(0);
            String name2 = friend.get(1);

            isMyFriend(user, myFriends, name1, name2);

            addFriendList(relations, name1, name2);
            addFriendList(relations, name2, name1);
        }
        
        for (String myFriend : myFriends) {
            calcFriendScore(scores, relations, myFriend);
        }

        entryList = new ArrayList<>(scores.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

        for (Map.Entry<String, Integer> entry : entryList) {
            if (isFriendLimit(myFriends, result, entry)) break;
        }

        return result;
    }

    /**
     * 친구 추천 결과 List 도출 메소드
     */
    private static boolean isFriendLimit(Set<String> myFriends, List<String> result, Map.Entry<String, Integer> entry) {
        if (!myFriends.contains(entry.getKey())) {
            result.add(entry.getKey());

            if (result.size() >= FRIEND_RECOMMEND_LIMIT) {
                return true;
            }
        }
        return false;
    }

    /**
     * 친구 추천 점수 계산 메소드
     */
    private static void calcFriendScore(Map<String, Integer> scores, Map<String, List<String>> relations, String myFriend) {
        List<String> subFriends = relations.get(myFriend);

        for (String subFriend : subFriends) {
            if (!scores.containsKey(subFriend)) {
                scores.put(subFriend, 0);
            }
            scores.put(subFriend, scores.get(subFriend) + 10);
        }
    }

    /**
     * 친구 관계 추가 메소드
     */
    private static void addFriendList(Map<String, List<String>> relations, String name1, String name2) {
        if (!relations.containsKey(name1)) {
            relations.put(name1, new ArrayList<>());
        }
        List<String> friendList = relations.get(name1);
        friendList.add(name2);
        relations.put(name1, friendList);
    }

    /**
     * 내 친구 확인 메소드
     */
    private static void isMyFriend(String user, Set<String> myFriends, String name1, String name2) {
        isNameMatching(user, myFriends, name1, name2);
        isNameMatching(user, myFriends, name2, name1);
    }

    /**
     * 내 이름 확인 메소드
     */
    private static void isNameMatching(String user, Set<String> myFriends, String name1, String name2) {
        if (user.equals(name1)) {
            myFriends.add(name2);
        }
    }

    /**
     * 방문자 점수 계산 메소드
     */
    private static void initVisitors(List<String> visitors, Map<String, Integer> scores) {
        for (String visitor : visitors) {
            if (!scores.containsKey(visitor)) {
                scores.put(visitor, 0);
            }
            scores.put(visitor, scores.get(visitor) + 1);
        }
    }
}
