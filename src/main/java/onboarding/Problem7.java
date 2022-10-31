package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    /** 기능 명세
     * 1. user의 친구 찾기
     * 2. 추천 점수 계산하기
     * 3. 가장 높은 점수를 받은 친구 5명 추천하기
     */
    public static List<String> listOfRecommend(List<String> listOfUserFriends) {
        return listOfUserFriends;
    }

    public static List<String> findUserFriend(String user, List<List<String>> friends) {
        ArrayList<String> listOfUserFriends = new ArrayList<>();
        for (List<String> relationship : friends) {
            if (relationship.contains(user) && relationship.get(0) == user)      { listOfUserFriends.add(relationship.get(1)); }
            else if (relationship.contains(user) && relationship.get(0) != user) { listOfUserFriends.add(relationship.get(0)); }
        }
        return listOfUserFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
