package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * 추천 친구 목록을 구하기 위한 기능들을 구현한 클래스
     */
    public static class Problem7_Functions {
        /**
         * 사용자의 모든 친구목록을 반환한다.
         * 
         * @param user    친구를 추천받을 사용자 아이디
         * @param friends 친구관계정보
         * @return {@code List<String>}사용자의 친구목록
         */
        public List<String> getUsersFriendsList(String user, List<List<String>> friends) {

            HashSet<String> res = new HashSet<>();

            for (List<String> relation : friends) {
                String friend = relation.get(0);
                res.add(friend);
            }

            res.remove(user);

            return List.copyOf(res);
        }
    }
}
