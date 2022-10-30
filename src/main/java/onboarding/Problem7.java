package onboarding;

import java.util.*;

public class Problem7 {

    /**
     * 사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때,
     * 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라.
     * 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.
     *
     * @param user
     * @param friends
     * @param visitors
     * @return
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendsMap<String, Set<String>> totalFriendsMap = new FriendsMap<>(friends);
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

class FriendsMap<K, V> {
    private final Map<K, V> totalFriendsMap = new HashMap<>();

    public FriendsMap(List<List<K>> friends) {

        for (List<K> friend : friends) {
            K friendA = friend.get(0);
            K friendB = friend.get(1);
            this.put(friendA, friendB);
            this.put(friendB, friendA);
        }
    }


}
