package onboarding;

import java.util.*;

public class Problem7 {

    static String nowUser; // 유저본인
    static HashSet<String> directFriends = new HashSet<>(); // 직접 친구(아는 친구X) 리스트
    static Map<String, Integer> friendsScoreList = new HashMap<>(); // 친구/점수 리스트

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        nowUser = user;
        // 1. 직접 친구(아는 친구X) 리스트 초기화
        directFriends = getDirectFriends(friends);

        // 2. 모든 친구/ 점수 리스트 초기화 (모든 친구 = 직접 친구 + 아는 친구)
        friendsScoreList = getFriendsScoreList(friends, visitors);

        // 3. 아는 친구 점수 반영
        friendsScoreList = scoreByKnownFriends(friends);

        // 4. 방문 기록 점수 반영
        friendsScoreList = scoreByVisitRecord(visitors);

        // 5. 추천 친구 정렬
        friendsScoreList = sortByScore(friendsScoreList);

        // 6. 추천 친구 결과 리스트로 만들기
        List<String> friendRecommendation = findFriendRecommendation(friendsScoreList);

        return friendRecommendation;
    }

    // 1. 직접 친구(아는 친구X) 리스트 초기화
    static HashSet<String> getDirectFriends(List<List<String>> friends){
        HashSet<String> directFriends = new HashSet<>();
        for (List<String> friendRelation : friends) {
            String friend1 = friendRelation.get(0);
            String friend2 = friendRelation.get(1);
            if (friend1.equals(nowUser))  directFriends.add(friend2);
            if (friend2.equals(nowUser))  directFriends.add(friend1);
        }

        return directFriends;
    }

    // 2. 모든 친구/ 점수 리스트 초기화 (모든 친구 = 직접 친구 + 아는 친구)
    static Map<String, Integer> getFriendsScoreList(List<List<String>> friends, List<String> visitors){
        for (List<String> friend : friends) {
            if (friend.contains(nowUser)) continue;

            for (String node : friend) {
                friendsScoreList.put(node, 0);
            }
        }

        for (String visitor : visitors) {
            if (!friendsScoreList.containsKey(visitors))friendsScoreList.put(visitor, 0);
        }
        return friendsScoreList;
    }

    // 3. 아는 친구 점수 반영
    static Map<String, Integer> scoreByKnownFriends(List<List<String>> friends){

        HashMap<String, Integer> knownFriends = new HashMap<>();

        // 아는 친구들
        for (List<String> friendRelation : friends) {
            if (friendRelation.contains(nowUser)) continue;
            String friend1 = friendRelation.get(0);
            String friend2 = friendRelation.get(1);
            if (directFriends.contains(friend1)) knownFriends.put(friend2, 1);
            if (directFriends.contains(friend2)) knownFriends.put(friend1, 1);
        }

        // 아는 친구면 10점 추가
        knownFriends.forEach((key, value)->{
            friendsScoreList.put(key, 10);
        });
        return friendsScoreList;
    }

    // 4. 방문 기록 점수 반영
    static Map<String, Integer> scoreByVisitRecord(List<String> visitorRecord){
        for(String visitor : visitorRecord) {
            if (directFriends.contains(visitor)) continue; // 직접 친구는 제외
            friendsScoreList.put(visitor,friendsScoreList.get(visitor) +1);
        }
        return friendsScoreList;
    }

    // 5. 추천 친구 정렬
    static Map<String, Integer> sortByScore(Map<String, Integer> friendsScoreList){
        // 이름순 정렬
        List<String> keySet = new ArrayList<>(friendsScoreList.keySet());
        Collections.sort(keySet);

        // 점수순 정렬
        List<String> keySetList = new ArrayList<>(friendsScoreList.keySet());
        Collections.sort(keySetList, (x, y) -> (friendsScoreList.get(y).compareTo(friendsScoreList.get(x))));

        return friendsScoreList;
    }

    // 6. 추천 친구 결과 리스트로 만들기
    static List<String> findFriendRecommendation(Map<String, Integer> friendsScoreList){
        List<String> friendRecommendation = new ArrayList<>();

        friendsScoreList.forEach((key, value)->{
            if (!directFriends.contains(key)) friendRecommendation.add(key);
        });

        return friendRecommendation;
    }
}
