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

        /* user의 친구를 아는 아이디에 10점을 주는 기능 구현 */
        for (String s : m.keySet()) {
            /*  user와 user의 친구인 아이디가 아닐 경우
             * 이유? user의 친구가 아닌 사람을 추천하는 문제이기때문이다
             */
            if (!ar.contains(s) && !s.equals(user)) {
                for (int j = 0; j < friends.size(); j++) {
                    /* 원소에 자기 아이디가 있다면 */
                    if (friends.get(j).contains(s)) {
                        /* 자기 아이디 인덱스 위치 추출 */
                        int n = friends.get(j).indexOf(s);
                        /* 자기의 친구가 user의 친구와 같다면 */
                        if (ar.contains(friends.get(j).get(1 - n))) {
                            m.put(s, m.get(s) + 10);
                        }
                    }
                }
            }
        }

        /* user의 타임라인에 방문한 사람에게 1점을 주는 기능 구현 */
        for (int i = 0; i < visitors.size(); i++) {
            /* user와 친구인 아이디가 아닐때 */
            if (!ar.contains(visitors.get(i))) {
                m.put(visitors.get(i), m.get(visitors.get(i)) + 1);
            }
        }

        return answer;
    }
}
