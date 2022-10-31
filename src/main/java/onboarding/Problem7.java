package onboarding;

import java.util.*;
import java.util.Collection;

public class Problem7 {
    // 1. 친구 목록 만들기
    // 2. 친구의 친구 목록만들기 -> 추천친구에 무조건추가 +10
    // 3. 방문자 확인하기 -> 친구만아니면 추천친구에 추가하기 +1


    // 추천 친구목록에는 친구의친구만 추가되어있음
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;

        }

    public static Set friendsList(String user, List<List<String>> friends){
        // 친구목록만들기
        //  1번 값이 mrko면 0번값을 친구목록에 저장
        Set friendsSet = new HashSet();
        for (int i =0; i<friends.size();i++){
            String left = friends.get(i).get(0);
            String right = friends.get(i).get(1);
            if(right.equals(user))friendsSet.add(left);
        }
        return friendsSet;

    }

}