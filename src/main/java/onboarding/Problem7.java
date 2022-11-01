package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 입력 폼을 받아 저장하는 map <사용자, 친구목록 리스트>
        Map<String, Set<String>> map = new LinkedHashMap<>();

        // 사용자 인덱스
        int userNameIndex = 0;
        // 다른 사용자 인덱스
        int differentUserNameIndex = 1;

        // 입력 폼을 순회 -> 사용자 인덱스의 원소를 키로 지정 하는 로직
        for (List<String> friend : friends) {
            String userKey = friend.get(userNameIndex);
            String userFriends = friend.get(differentUserNameIndex);

            // map 에 사용자가 존재하는지
            if (map.containsKey(userKey)) {
                // 사용자의 친구목록 리스트에 추가허여 merge 작업
                Set<String> mapFriend = map.get(userKey);
                mapFriend.add(userFriends);
                map.put(userKey, mapFriend);
                continue;
            }

            // 존재하지 않으면 새로 추가
            map.put(userKey, new LinkedHashSet<>(Set.of(userFriends)));
        }

        return Collections.emptyList();
    }

    public static void main(String[] args) {
        String user = "mrko";

        List<List<String>> friends = new ArrayList<>() {{
            add(new ArrayList<>(List.of("donut", "andole")));
            add(new ArrayList<>(List.of("donut", "jun")));
            add(new ArrayList<>(List.of("donut", "mrko")));
            add(new ArrayList<>(List.of("shakevan", "andole")));
            add(new ArrayList<>(List.of("shakevan", "jun")));
            add(new ArrayList<>(List.of("shakevan", "mrko")));
        }};

        List<String> visitors = new ArrayList<>(){{
            addAll(List.of("bedi", "bedi", "donut", "bedi", "shakevan"));
        }};

        System.out.println(solution(user, friends, visitors));
    }
}
