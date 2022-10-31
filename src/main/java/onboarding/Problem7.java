package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    /*
    기능 목록
    1. 친구 관계 설정 기능
    2. 함께 아는 친구 분석 기능
    3. 타임라인 방문 기록 분석 기능
    4. 추천 점수와 이름순으로 정렬해서 최대 5명 추천하는 기능
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRecommender friendRecommender = new FriendRecommender();

        return friendRecommender.recommend(user, friends, visitors);
    }

    private static class FriendRecommender {
        private Map<String, Map<String, Boolean>> friendsRelation;
        private Map<String, Integer> friendsScore;

        public List<String> recommend(String user, List<List<String>> friends, List<String> visitors) {
            setFriendsRelation(user, friends);
            setFriendScore(user);
            setVisitScore(user, visitors);

            List<Map.Entry<String, Integer>> friendsScoreList = new ArrayList<>(friendsScore.entrySet());

            friendsScoreList.sort(new StringIntPair());

            return friendsScoreList.stream().map(Map.Entry::getKey).collect(Collectors.toList());
        }

        private void setVisitScore(String user, List<String> visitors) {
            Set<String> userFriends = friendsRelation.get(user).keySet();
            for (String visitor : visitors) {
                if (friendsScore.containsKey(visitor)) {
                    friendsScore.put(visitor, friendsScore.get(visitor) + 1);
                } else if (!userFriends.contains(visitor) && !visitor.equals(user)){
                    friendsScore.put(visitor, 1);
                }
            }
        }

        private void setFriendScore(String user) {
            friendsScore = new HashMap<>();
            Set<String> userFriends = friendsRelation.get(user).keySet();
            for (String friend : friendsRelation.keySet()) {
                if (friend.equals(user) || userFriends.contains(friend)) {
                    continue;
                }
                int friendScore = 0;
                for (String other : friendsRelation.get(friend).keySet()) {
                    if (userFriends.contains(other)) {
                        friendScore += 10;
                    }
                }
                if (!friendsScore.containsKey(friend)) {
                    friendsScore.put(friend, friendScore);
                } else {
                    friendsScore.put(friend, friendScore + friendsScore.get(friend));
                }
            }

        }

        private void setFriendsRelation(String user, List<List<String>> friends) {
            friendsRelation = new HashMap<>();
            for (List<String> friendRelation : friends) {
                String friendA = friendRelation.get(0);
                String friendB = friendRelation.get(1);

                boolean isExistA = friendsRelation.containsKey(friendA);
                boolean isExistB = friendsRelation.containsKey(friendB);

                if (!isExistA) {
                    friendsRelation.put(friendA, new HashMap<>());
                }
                Map<String, Boolean> aFriends = friendsRelation.get(friendA);
                aFriends.put(friendB, true);

                if (!isExistB) {
                    friendsRelation.put(friendB, new HashMap<>());
                }
                Map<String, Boolean> bFriends = friendsRelation.get(friendB);
                bFriends.put(friendA, true);
            }
        }
    }

    private static class StringIntPair implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue() - o2.getValue() == 0 ?
                    o1.getKey().compareTo(o2.getKey()) : -(o1.getValue() - o2.getValue());
        }
    }
}
