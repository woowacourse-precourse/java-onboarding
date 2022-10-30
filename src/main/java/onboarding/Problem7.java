package onboarding;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Tuple<HashMap<String, List<String>>, HashMap<String, Integer>> friendsInfos = createFriendsInfos(friends, visitors);
        HashMap<String, List<String>> friendsRelationshipHashMap = friendsInfos.first;
        HashMap<String, Integer> friendsScoreHashMap = friendsInfos.second;

        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Tuple<HashMap<String, List<String>>, HashMap<String, Integer>> createFriendsInfos(List<List<String>> friends, List<String> visitors){
        // 친구 관계를 표현하는 friendsRelationshipHashMap 생성
        HashMap<String, List<String>> friendsRelationshipHashMap = new HashMap<>();
        // 추천 점수를 나타내는 friendsScoreHashMap 생성
        HashMap<String, Integer> friendsScoreHashMap = new HashMap<>();

        // 친구관계 정보를 통한 업데이트
        for(List<String> friend: friends){
            friendsRelationshipHashMap.computeIfAbsent(friend.get(0), k-> new ArrayList<>()).add(friend.get(1));
            friendsRelationshipHashMap.computeIfAbsent(friend.get(1), k-> new ArrayList<>()).add(friend.get(0));

            friendsScoreHashMap.putIfAbsent(friend.get(0), 0);
            friendsScoreHashMap.putIfAbsent(friend.get(1), 0);
        }

        // 타임라인 방문 기록을 통한 업데이트
        for (String visitor: visitors){
            friendsScoreHashMap.putIfAbsent(visitor, 0);
        }

        return new Tuple<>(friendsRelationshipHashMap, friendsScoreHashMap);
    }

    public static class Tuple<T1, T2> {
        private T1 first;
        private T2 second;

        public Tuple(T1 first, T2 second){
            this.first = first;
            this.second = second;
        }
    }
}
