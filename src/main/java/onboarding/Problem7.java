package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    /*
    기능 목록
    1. 친구 관계 설정 기능
    2. 함께 아는 친구 분석 기능
    3. 타임라인 방문 기록 분석 기능
    4. 추천 점수와 이름순으로 정렬해서 최대 5명 추천하는 기능
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private class FriendRecommender {
        private Map<String, Map<String, Boolean>> friendsRelation;
        public List<String> recommend(String user, List<List<String>> friends, List<String> visitors) {

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
}
