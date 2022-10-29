package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        /* ArrayList를 이용하여 user의 친구 아이디를 추가 */
        List<String> ar = new ArrayList<>();

        /* friends 리스트에서 user의 친구 아이디를 찾아 ar 리스트에 추가하는 기능 */
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                int n = friends.get(i).indexOf(user);
                ar.add(friends.get(i).get(1 - n));
            }
        }

        /*
         * 전체 아이디 정리 기능
         *
         * key : 아이디
         * value : 추천 점수
         */
        Map<String, Integer> m = new HashMap<>();

        /* friends 리스트에 주어진 모든 아이디를 찾는 기능 구현  */
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (!m.containsKey(friends.get(i).get(j))) {
                    m.put(friends.get(i).get(j), 0);
                }
            }
        }

        /* 친구 관계정보에는 없지만 현재 사용자 아이디의 타임라인에 방문한 아이디를 찾는 기능 구현 */
        for (int i = 0; i < visitors.size(); i++) {
            if (!m.containsKey(visitors.get(i))) {
                m.put(visitors.get(i), 0);
            }
        }

        return answer;
    }
}
