package onboarding;

import java.util.*;
import java.util.stream.Collectors;

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

        // 입력 폼을 순회 -> 다른 사용자 인덱스의 원소를 키로 지정 하는 로직
        for (List<String> friend : friends) {
            String userKey = friend.get(differentUserNameIndex);
            String userFriends = friend.get(userNameIndex);

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

        // 입력한 사용자의 친구 목록 리스트
        Set<String> findFriends = map.get(user);

        // 사용자와 친구추천 포인트를 담을 friendPoints
        Map<String, Integer> friendPoints = new LinkedHashMap<>();

        // 아는 친구 1명 당 점수 10점
        int relationPoint = 10;

        // 입력한 사용자의 친구 목록 리스트 순회
        for (String findFriend : findFriends) {
            Set<String> knowRelationShip = map.get(findFriend);

            // 사이즈 값 조회
            int knowRelationShipCount = knowRelationShip.size();

            // 아는 친구 목록에 입력한 사용자 즉, 자신이 포함하고 있으면 자신을 제거 한 나머지 결과값에 저장
            if (knowRelationShip.contains(user)) {
                knowRelationShipCount = knowRelationShip.size() - 1;
            }

            int resultRelationPoint = knowRelationShipCount * relationPoint;

            // 아는 친구들을 순회
            for (String knowUser : knowRelationShip) {

                // 입력한 사용자가 아는 친구와 같으면 다음 반복으로 넘어간다
                if (knowUser.equals(user)) {
                    continue;
                }

                // 그게 아니라면 사용자와 친구추천 포인트를 담을 friendPoints 에 저장한다.
                friendPoints.put(knowUser, resultRelationPoint);
            }
        }

        // 방문한 사용자 목록을 순회
        for (String visitor : visitors) {

            // 사용자와 친구추천 포인트를 담을 friendPoints 에 merge 한다
            // 방문한 사람의 점수는 1점 추가 된다.
            friendPoints.put(visitor, friendPoints.getOrDefault(visitor, 0) + 1);
        }

        // 결과 값을 반환한다.
        // 내림차순으로 정렬 (포인트 값으로 비교) 같으면 닉네임으로 정렬
        // 자신의 친구를 포함하지 않고 아는 친구만 가져와야함
        // 결과 값을 5개 사이즈로 반환해야 한다.
        return  friendPoints.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .map(Map.Entry::getKey)
                .filter(s -> !map.get(user).contains(s))
                .limit(5)
                .collect(Collectors.toList());
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
