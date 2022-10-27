package onboarding;

import java.util.*;

/**
 * [기능 구현]
 * 1. 각자의 친구 목록을 전역변수인 map_friends 에 <key, list> 형식으로 저장하는 메소드
 * 2. 주어지는 user 를 기준으로 하나씩 비교하며 함께 아는친구 판별 후 map_points <key, integer> 형식으로 점수 추가하는 메소드
 * 3. 주어지는 user 의 친구목록에 해당하지 않는 visitor 의 점수 추가하는 메소드
 * 4. 점수를 저장하는 map 을 value 기준으로 내림차순 정렬하는 메소드 -> stream 사용 treemap 을 사용했기 때문에 key 는 자동 오름차순 정렬
 **/
public class Problem7 {
    private static Map<String, ArrayList> map_friends = new HashMap<>();
    private static Map<String, Integer> map_points = new TreeMap<>();

    // 각자의 친구 목록을 자료구조 hashmap 을 사용해 저장해주는 메소드
    private static void makeFriendsMap(List<List<String>> friends) {
        for (List<String> list : friends) {
            ArrayList A_List = map_friends.getOrDefault(list.get(0), new ArrayList());
            ArrayList B_List = map_friends.getOrDefault(list.get(1), new ArrayList());

            A_List.add(list.get(1));
            B_List.add(list.get(0));

            map_friends.put(list.get(0), A_List);
            map_friends.put(list.get(1), B_List);
        }
    }

    // 함께 아는 친구 점수 추가해주는 메서드
    private static void friendsPlusPoint(String user, ArrayList arrayList) {
        for (String str : map_friends.keySet()) {
            if (!str.equals(user)) {
                ArrayList friendList = map_friends.get(str); // jun {donut, shakevan}
                for (int i = 0; i < arrayList.size(); i++) { // donut shakevan
                    if (friendList.contains(arrayList.get(i))) {
                        map_points.put(str, map_points.getOrDefault(str, 0) + 10);
                    }
                }
            }
        }
    }

    // visitor 기반으로 방문한 친구 점수 추가해주는 메서드
    private static void visitorPlusPoint(List<String> visitors, ArrayList arrayList) {
        for (String str : visitors) {
            if (!arrayList.contains(str)) {
                map_points.put(str, map_points.getOrDefault(str, 0) + 1);
            }
        }
    }

    // map_points 를 정렬하는 메서드
    private static void sortPointList(List<String> answer) {
        List<String> keySet = new ArrayList<>(map_points.keySet());
        // Value 값으로 오름차순 정렬
        keySet.sort((o1, o2) -> map_points.get(o2).compareTo(map_points.get(o1)));
        for (String str : keySet) {
            if (map_points.get(str) != 0) {
                answer.add(str);
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        return answer;
    }
}
