package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 1촌 친구 리스트
        List<String> directFriends = new ArrayList<>();

        // 1. 1촌 친구 리스트 업
        for ( int i = 0 ; i < friends.size() ; i ++ ){
            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);
            if( friendA.isEqualTo(user) ) directFriends.add(friendB);
            if( friendB.isEqualTo(user) ) directFriends.add(friendA);
        }
        /*
        2. friends를 돌며 1촌 친구들의 자신이 아닌 다른 친구들을 체크 -> HashMap
        3. Comparator 사용하여 HashMap 정렬
        4. 정렬된 HashMap의 key 값 5개 추출
        */
        return answer;
    }
}
