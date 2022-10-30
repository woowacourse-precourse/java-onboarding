package onboarding;

import java.util.*;

public class Problem7 {
    /*
        기능 요구 사항 목록
        1. 사용자의 친구 리스트 반환 함수
        2. 친구의 친구 점수 해시맵 반환 함수
        3. 방문자 점수 해시맵 반환 함수
        4. 해시맵 정렬 함수
        5. solution (함수 순서대로 실행)
    */

    // 주어진 사용자의 친구 리스트 반환 함수
    private static List<String> userFriend(String user, List<List<String>> friendDb, HashSet<String> users) {
        List<String> friends = new ArrayList<>(List.of());

        for (List<String> relationship : friendDb) {
            if (relationship.contains(user)) {
                int userIndex = relationship.indexOf(user); // 사용자의 인덱스
                int friendIndex = 1 - userIndex;            // 사용자 친구의 인덱스
                String userFriend = relationship.get(friendIndex);
                friends.add(userFriend);
            }
        }
        return friends;
    }

    // 추천 점수 해시맵 반환 함수 (친구의 친구)
    private static HashMap<String, Integer> acquaintance(String user, List<List<String>> db, List<String> userFriends) {
        HashMap<String, Integer> recommend = new HashMap<>();

        for (List<String> relationship : db) {
            if (relationship.contains(user)) continue;

            for (String friend : userFriends) {
                if (relationship.contains(friend)) {
                    int friendIndex = relationship.indexOf(friend); // 사용자 친구의 인덱스
                    int acqIndex = 1 - friendIndex;                 // 친구의 친구 인덱스
                    String acq = relationship.get(acqIndex);
                    if (!recommend.containsKey(acq)) recommend.put(acq, 10);
                    else recommend.put(acq, recommend.get(acq) + 10);
                }
            }
        }
        return recommend;
    }

    // 추천 점수 해시맵 반환 함수 (방문자)
    private static HashMap<String, Integer> looker(HashMap<String, Integer> recommend, List<String> visitors, List<String> userFriends) {
        for (String visitor : visitors) {
            if (userFriends.contains(visitor)) continue;

            if (!recommend.containsKey(visitor)) recommend.put(visitor, 1);
            else recommend.put(visitor, recommend.get(visitor) + 1);
        }
        return recommend;
    }

    // 해시맵 정렬
    private static HashMap<String, Integer> sortRecommend(HashMap<String, Integer> recommend) {
        // 사전순 정렬
        recommend.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey());
        // 점수순 정렬
        recommend.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey());

        return recommend;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
