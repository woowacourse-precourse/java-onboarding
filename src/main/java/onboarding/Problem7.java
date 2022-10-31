package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> dict = new HashMap<>(); // K : user_id, V : point
        List<String> already_friend = new ArrayList<>();

        // 이미 친구는 제외
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            if (user1.equals(user)) {
                already_friend.add(user2);
            }
            if (user2.equals(user)) {
                already_friend.add(user1);
            }
        }

        // 함께 아는 친구 포인트
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            if((!user1.equals(user)) && (!user2.equals(user))) {
                if (already_friend.contains(user1)) { // user1이(가) 주어진 user와 친구 관계인 경우, user2 포인트 상승
                    if (dict.containsKey(user1)) { // HashMap에 이미 등록된 경우
                        int prev_point = dict.get(user2);
                        dict.replace(user2, prev_point + 10);
                    } else { // 미등록 상태의 경우
                        dict.put(user2, 10);
                    }
                }
                if (already_friend.contains(user2)) { // user2이(가) 주어진 user와 친구 관계인 경우, user1 포인트 상승
                    if (dict.containsKey(user2)) {
                        int prev_point = dict.get(user1);
                        dict.replace(user1, prev_point + 10);
                    } else {
                        dict.put(user1, 10);
                    }
                }
            }
        }

        // 방문 기록 포인트
        for (String visitor : visitors) {
            if (!already_friend.contains(visitor)) {
                if (dict.containsKey(visitor)) {
                    int prev_point = dict.get(visitor);
                    dict.replace(visitor, prev_point+1);
                } else {
                    dict.put(visitor, 1);
                }
            }
        }

        // 다중 조건 정렬
        Set<Map.Entry<String, Integer>> entrySet = dict.entrySet();
        List<Map.Entry<String, Integer>> not_sorted_set = new ArrayList<>(entrySet);
        Collections.sort(not_sorted_set, (o1, o2) -> {
            if (o1.getValue() - o2.getValue() != 0) {
                return o2.getValue().compareTo(o1.getValue());
            }
            return o1.getKey().compareTo(o2.getKey());
        });

        
        List<String> sorted_set = new ArrayList<>();
        for (Map.Entry<String, Integer> key : not_sorted_set) {
            sorted_set.add(key.getKey());
        }

        // 상위 5명 선택
        for (int i=0; i<5; i++) {
            if (sorted_set.size() <= i) {
                break;
            } else {
                answer.add(sorted_set.get(i));
            }
        }

        return answer;
    }
}
