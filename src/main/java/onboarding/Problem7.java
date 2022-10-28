package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    /**
     * 기능 목록
     * 1. user의 친구목록
     * 2. friends와 visitors에 있는 친구 정리
     * 3. user와 함께 아는 친구의 수 점수 계산
     * 4. user의 타임 라인에 방문한 친구 점수 계산
     * 5. 추천인 5명 뽑기
     * 6. 이미 친구인 사이 삭제
     */

    // friends와 visitors의 친구 목록 정리
    static HashMap<String, Integer> friendList = new HashMap<>();

    /**
     * 1. user의 친구목록
     * @param user : user 아이디
     * @param friends : 친구 관계
     * @return : user의 친구목록
     */
    static List<String> findUserFriends(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            String id1 = friend.get(0);
            String id2 = friend.get(1);

            // 친구 관계에 user 아이디가 존재하면 user와 친구 관계
            if (id1.equals(user)) userFriends.add(id2);
            if (id2.equals(user)) userFriends.add(id1);
        }

        return userFriends;
    }

    /**
     * 2. friends와 visitors에 있는 친구 정리
     * @param user : user 아이디
     * @param friends : 친구 관계
     * @param visitors : 방문자
     */
    static void makeFriendList(String user, List<List<String>> friends, List<String> visitors){

        for (List<String> friend : friends) {
            String id1 = friend.get(0);
            String id2 = friend.get(1);

            // user 아이디가 아니면서 friendList에 없는 경우 친구 목록에 추가
            if (!id1.equals(user)) friendList.put(id1, 0);
            if (!id2.equals(user)) friendList.put(id2, 0);
        }

        // 방문자 친구 목록에 추가
        for (String visitor : visitors) {
            friendList.put(visitor, 0);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
