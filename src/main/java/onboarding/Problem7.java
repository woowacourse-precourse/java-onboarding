package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        // 친구명과 점수
        HashMap<String, Integer> friendsScore = new HashMap<>();

        // 친구 관계를 표시할 HashMap
        HashMap<String, ArrayList<String>> friendsMap = new HashMap<String, ArrayList<String>>();

        // 친구 관계 friendsMap 만들기
        for(List<String> friendsRelation : friends) {
            makeFriendsMap(friendsRelation, friendsMap);
        }

        // 친구들의 Score 초기화
        for(String friend : friendsMap.keySet()) {
            makeFriendsScore(friend, user, friendsScore);
        }

        // 친구 관계 점수 추가
        for(String friend : friendsScore.keySet()) {
            addFriendScore(friend, friendsScore, getSameFriendsScore(user, friend, friendsMap));
        }

        // 
        return answer;
    }

    public static void makeFriendsMap(List<String> friendsRelation, HashMap<String, ArrayList<String>> friendsMap) {
        String friend1 = friendsRelation.get(0);
        String friend2 = friendsRelation.get(1);

        if(friendsMap.containsKey(friend1)) {
            friendsMap.get(friend1).add(friend2);
        } else {
            friendsMap.put(friend1, new ArrayList<>(Arrays.asList(friend2)));
        }

        if(friendsMap.containsKey(friend2)) {
            friendsMap.get(friend2).add(friend1);
        } else {
            friendsMap.put(friend2, new ArrayList<>(Arrays.asList(friend1)));
        }
    }

    public static void makeFriendsScore(String friend, String user, HashMap<String, Integer> friendsScore) {
        if(!friend.equals(user)) {
            friendsScore.put(friend, 0);
        }
    }

    public static Integer getSameFriendsScore(String user, String friend, HashMap<String, ArrayList<String>> friendsMap) {
        int score = 0;
        for(String userFriend : friendsMap.get(user)) {
            if(friendsMap.get(friend).contains(userFriend)) {
                score += 10;
            }
        }
        return score;
    }

    public static void addFriendScore(String friend, HashMap<String, Integer> friendsScore, Integer value) {
        Integer curScore = friendsScore.get(friend);
        curScore += value;
        friendsScore.put(friend, curScore);
    }

}
