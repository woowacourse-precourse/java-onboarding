package onboarding;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Problem7 {
    static final int CONNECTED_SCORE = 10;
    static final int VISITED_SCORE = 1;
    static Set<String> directFriends = new HashSet<>(); // 1촌 친구 리스트
    static Map<String, Integer> rank = new HashMap<>(); // 모르는 친구 : 점수 

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 1. 1촌 친구 리스트 업
        getFriendsList(user, friends);
        // 2. friends를 돌며 1촌 친구들의 자신이 아닌 다른 친구들을 체크 -> HashMap
        giveConnectedFriendScore(user, friends);
        // 3. visitor를 순회하며 +1 씩
        giveVisitedFriendScore(user, friends, visitors);
        // 4, 5. Comparator 사용하여 HashMap 정렬 / 정렬된 HashMap의 key 값 5개 추출
        return getTop5List();
    }
    static void getFriendsList(String user, List<List<String>> friends){
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                if (friend.get(0).equals(user))
                    directFriends.add(friend.get(1));
                else
                    directFriends.add(friend.get(0));
            }
        }
    }
    static void giveConnectedFriendScore(String user, List<List<String>> friends ){
        for ( int i = 0 ; i < friends.size() ; i ++ ) {
            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);
            for ( int j = 0 ; j < directFriends.size() ; j ++ ){
                if ( directFriends.contains(friendA) && ! friendB.equals(user)) 
                    rank.put(friendB, rank.getOrDefault(friendB, 0) + CONNECTED_SCORE );
                if ( directFriends.contains(friendB) && ! friendA.equals(user) ) 
                    rank.put(friendA, rank.getOrDefault(friendA, 0) + CONNECTED_SCORE );
            }
        }
    }
    static void giveVisitedFriendScore(String user, List<List<String>> friends, List<String> visitors){
        for ( int i = 0 ; i < visitors.size() ; i ++ )
            if (! directFriends.contains(visitors.get(i)))
                rank.put(visitors.get(i), rank.getOrDefault(visitors.get(i), 0) + 1);

        // for ( int i = 0 ; i < friends.size() ; i ++ ) {
        //     String friendA = friends.get(i).get(0);
        //     String friendB = friends.get(i).get(1);
        //     for ( int j = 0 ; j < directFriends.size() ; j ++ ){
        //         if ( directFriends.get(j).equals(friendA) && ! friendB.equals(user)) 
        //             rank.put(friendB, rank.getOrDefault(friendB, 0) + CONNECTED_SCORE );
        //         if ( directFriends.get(j).equals(friendB) && ! friendA.equals(user) ) 
        //             rank.put(friendA, rank.getOrDefault(friendA, 0) + CONNECTED_SCORE );
        //     }
        // }
    }
    static List<String> getTop5List() {
        return rank.entrySet().stream()
                .filter(v -> v.getValue() > 0 && !directFriends.contains(v.getKey()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
