package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map
class Main{
    public static void main(String[] args){
        Problem7 prob = new Problem7();
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        System.out.println(prob.solution(user, friends, visitors));
    }
}
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 1촌 친구 리스트
        List<String> directFriends = new ArrayList<>();

        Map<String, Integer> rank = new HashMap<>();

        // 1. 1촌 친구 리스트 업
        for ( int i = 0 ; i < friends.size() ; i ++ ){
            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);
            if( friendA.equals(user) ) directFriends.add(friendB);
            if( friendB.equals(user) ) directFriends.add(friendA);
        }

        // 2. friends를 돌며 1촌 친구들의 자신이 아닌 다른 친구들을 체크 -> HashMap
        for ( int i = 0 ; i < friends.size() ; i ++ ) {
            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);
            for ( int j = 0 ; j < directFriends.size() ; j ++ ){
                if ( directFriends.get(j).equals(friendA) ) rank.put(friendA, rank.getOrDefault(friendA, 0) + 10 );
                if ( directFriends.get(j).equals(friendB) ) rank.put(friendB, rank.getOrDefault(friendB, 0) + 10 );
            }
        }

        // 3. visitor를 순회하며 +1 씩
        for ( int i = 0 ; i < visitors.size() ; i ++ )
            rank.put(visitors.get(i), visitors.getOrDefault(visitors.get(i), 0) + 1);
            
        /*
        4. Comparator 사용하여 HashMap 정렬
        5. 정렬된 HashMap의 key 값 5개 추출
        */
        return answer;
    }
}
