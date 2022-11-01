package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 이미 user 와 친구인 사람을 저장할 리스트
        List<String> user_friend_list = new ArrayList<>();

        // 이름과 점수를 함께 저장
        Map<String, Integer> map = new TreeMap<>();

        // user 와 친구인 사람들 확인
        for (int i = 0; i < friends.size(); i++) {

            List<String> temp = friends.get(i);

            String A = temp.get(0);
            String B = temp.get(1);

            if (A.equals(user)) {
                user_friend_list.add(B);
            } else if (B.equals(user)) {
                user_friend_list.add(A);
            }
        }

        // user 와 친구인 사람들 중에서,
        // 사용자와 함께 아는 친구 수 점수 계산
        for (int i = 0; i < user_friend_list.size(); i++) {

            String name = user_friend_list.get(i);
            // System.out.println(name);

            // 추천해 줄 친구가 있는 지 확인
            for (int j = 0; j < friends.size(); j++) {
                List<String> temp = friends.get(j);

                String A = temp.get(0);
                String B = temp.get(1);

                // 단, user 및 이미 친구사이는 포함해서는 안된다.
                if (A.equals(name) && !B.equals(user) && !user_friend_list.contains(B)) {

                    // 이미 map 에 있다면, 기존 점수에 + 10
                    if (map.containsKey(B)) {
                        map.put(B, map.get(B) + 10);
                    } else {
                        map.put(B, 10);
                    }

                } else if (B.equals(name) && !A.equals(user) && !user_friend_list.contains(A)) {

                    if (map.containsKey(A)) {
                        map.put(A, map.get(A) + 10);
                    } else {
                        map.put(A, 10);
                    }
                }
            }

        }

        // 타임 라인 점수 계산
        for (int i = 0; i < visitors.size(); i++) {

            String name = visitors.get(i);

            // 이미 map 에 있다면, 기존 점수에 + 1
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                if (!user_friend_list.contains(name)) {
                    map.put(name, 1);
                }
            }
        }

        // treemap 은 기본으로 키 기준 오름차순 정렬됨
        // value 기준 내림차순 정렬
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        // 인원수
        int cnt = 0;

        // 정답 저장할 리스트
        List<String> result = new ArrayList<>();

        for (String key : keySet) {
            result.add(cnt, key);
            cnt++;

            // 최대 5명까지만 나오도록
            if (cnt == 5) {
                break;
            }
        }

        // 정답
        answer = result;

        return answer;
    }
}
