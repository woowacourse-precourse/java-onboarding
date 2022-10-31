package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 기능목록
 * 1. 친구 목록 생성
 * 2. 친구의 친구 목록 생성
 * 3. 방문자 중 친구들 제거
 * 4. 알고리즘 점수계산
 * 5. 추천친구 목록 생성
 * */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriends = findFriends(user,friends);
        return answer;
    }

    static List<String> findFriends(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();

        addOppositeUserToList(userFriends,user,friends);
        return  userFriends;
    }

    static void addOppositeUserToList(List<String> list, String user , List<List<String>> friends){
        for(List<String> friend : friends){
            if(friend.get(0) == user){
                list.add(friend.get(1));

            } else if (friend.get(1) == user) {
                list.add(friend.get(0));
            }
        }
    }
}
