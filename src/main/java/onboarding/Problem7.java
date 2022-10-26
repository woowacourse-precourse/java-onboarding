package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * 기능 1
     * user의 친구 리스트 생성
     */
    public static List<String> makeFriendList(String user, List<List<String>> friends) {
        List<String> friendsOfUser = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++)
        {
            if (friends.get(i).get(0).equals(user)) {
                friendsOfUser.add(friends.get(i).get(1));
            }
            if (friends.get(i).get(1).equals(user)) {
                friendsOfUser.add(friends.get(i).get(0));
            }
        }

        return friendsOfUser;
    }

    /**
     * 기능 2
     * 사용자와 함께 아는 친구를 가진 사람과 점수 리스트 생성
     */

    /**
     * 기능 2에 만든 리스트에 방문자 리스트 및 점수 추가
     */

    /**
     * 기능 4
     * 점수가 높은 순서대로 정렬
     */
}
