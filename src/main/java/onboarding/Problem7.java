package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [기능 구현]
 * 1. 각자의 친구 목록을 전역변수인 map_friends 에 <key, list> 형식으로 저장하는 메소드
 * 2. 주어지는 user 를 기준으로 하나씩 비교하며 함께 아는친구 판별 후 map_points <key, integer> 형식으로 점수 추가하는 메소드
 * 3. 주어지는 user 의 친구목록에 해당하지 않는 visitor 의 점수 추가하는 메소드
 * 4. 점수를 저장하는 map 을 value 기준으로 내림차순 정렬하는 메소드 -> stream 사용 treemap 을 사용했기 때문에 key 는 자동 오름차순 정렬
 * <p>
 * -> [예외사항 및 코드 수정]
 * 1. 사용자 즉 , user 로 주어진 사용자의 친구가 없을 경우 null 예외사항 처리를 위한 코드 수정
 * 2. 함께아는 친구의 목록이 겹치더라도, 사용자와 친구관계 일 경우 추천 점수 +10 이 적용되지 않도록 코드 수정
 **/
public class Problem7 {
    private static Map<String, ArrayList> map_friends;
    private static Map<String, Integer> map_points;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        map_friends = new HashMap<>();
        map_points = new TreeMap<>();

        // 양방향 친구목록 만드는 메소드
        createFriendsList(friends);
        // 함께아는 친구 점수 추가하는 메소드
        plusPointFriendWith(user);
        // 방문자 점수 추가하는 메소드
        plusPointVisitor(user, visitors);
        // answer 만드는 메소드
        createAnswer(answer);

        return answer;
    }

    // answer 만드는 메소드
    private static void createAnswer(List<String> answer) {
        // stream() 을 사용해 map 을 value 기준으로 역정렬 후 상위 5개만 저장
        List<Map.Entry<String, Integer>> collect = map_points.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(5)
                .collect(Collectors.toList());

        // collect 안의 5개의 요소들을 answer 에 add
        for (Map.Entry<String, Integer> entry : collect) {
            answer.add(entry.getKey());
        }
    }

    // 양방향 친구목록을 만들어주는 메소드 (Arraylist 사용)
    private static void createFriendsList(List<List<String>> friends) {
        for (List<String> list : friends) {
            ArrayList A_List = map_friends.getOrDefault(list.get(0), new ArrayList());
            ArrayList B_List = map_friends.getOrDefault(list.get(1), new ArrayList());

            A_List.add(list.get(1));
            B_List.add(list.get(0));

            map_friends.put(list.get(0), A_List);
            map_friends.put(list.get(1), B_List);
        }
    }

    // 사용자와 함께아는 친구의 점수를 hashmap 에 저장하는 메소드
    private static void plusPointFriendWith(String user) {
        for (String str : map_friends.keySet()) {
            plusPointFriendWithToMap(user, str);
        }
    }

    /**
     * 함께아는 친구의 점수를 더해주는 메소드
     * <p>
     * 1. user 가 아니면서 user 의 친구가 있는 경우
     * -> if (!str.equals(user) && map_friends.get(user) != null)
     * 2. 사용자와 함께아는 친구이고 사용자와 이미 친구관계가 아닐 경우
     * -> if (friendList.contains(map_friends.get(user).get(i)) && !friendList.contains(user))
     */
    private static void plusPointFriendWithToMap(String user, String str) {
        if (!str.equals(user) && map_friends.get(user) != null) {
            ArrayList friendList = map_friends.get(str); // jun {donut, shakevan}
            for (int i = 0; i < map_friends.get(user).size(); i++) { // donut shakevan
                if (friendList.contains(map_friends.get(user).get(i)) && !friendList.contains(user)) {
                    map_points.put(str, map_points.getOrDefault(str, 0) + 10);
                }
            }
        }
    }

    /**
     * 방문한 사용자의 점수를 저장하는 메소드
     * <p>
     * 1. 방문자가 user 가 아닐 경우만 진행
     * -> if (user.equals(visitor)) continue;
     */
    private static void plusPointVisitor(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if (user.equals(visitor)) continue; // 방문자가 user 일 경우는 skip
            plusPointVisitorToMap(user, visitor);
        }
    }

    /**
     * 친구관계인지 아닌지 판단 후 방문자의 점수를 더해주는 메소드
     * <p>
     * 1. user 의 친구가 없을 경우와 있는 경우
     * -> if (map_friends.get(user) != null) .. else
     * 2. user 의 친구 목록에 visitor 가 없는 경우
     * -> if (!map_friends.get(user).contains(visitor))
     */
    private static void plusPointVisitorToMap(String user, String visitor) {
        if (map_friends.get(user) != null) {
            if (!map_friends.get(user).contains(visitor)) {
                map_points.put(visitor, map_points.getOrDefault(visitor, 0) + 1);
            }
        } else {
            map_points.put(visitor, map_points.getOrDefault(visitor, 0) + 1);
        }
    }
}