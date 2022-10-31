package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    /***
     * user의 친구 추출
     * user와 함께 아는 친구 추출
     * 방문자 추출
     * 점수 내림차순 정렬
     * map의 key 값만 추출
     * 이미 친구인 사람 추출
     * 리스트에서 이미 친구인 사람 삭제
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * user의 친구 추출
     */
    static List<String> userFriends(String user, List<List<String>> friends) {
        List<String> myFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                if (friend.get(0).equals(user)) {
                    myFriends.add(friend.get(1));
                }else {
                    myFriends.add(friend.get(0));
                }
            }
        }
        return myFriends;
    }
}
