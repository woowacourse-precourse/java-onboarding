package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * [기능 구현]
 * 1. 각자의 친구 목록을 전역변수인 map_friends 에 <key, list> 형식으로 저장하는 메소드
 * 2. 주어지는 user 를 기준으로 하나씩 비교하며 함께 아는친구 판별 후 map_points <key, integer> 형식으로 점수 추가하는 메소드
 * 3. 주어지는 user 의 친구목록에 해당하지 않는 visitor 의 점수 추가하는 메소드
 * 4. 점수를 저장하는 map 을 value 기준으로 내림차순 정렬하는 메소드 -> stream 사용 treemap 을 사용했기 때문에 key 는 자동 오름차순 정렬

 -> [예외사항 및 코드 수정]
 1. 사용자 즉 , user 로 주어진 사용자의 친구가 없을 경우 null 예외사항 처리를 위한 코드 수정
 2. 함께아는 친구의 목록이 겹치더라도, 사용자와 친구관계 일 경우 추천 점수 +10 이 적용되지 않도록 코드 수정
 **/
public class Problem7 {
//    private static Map<String, ArrayList> map_friends = new HashMap<>();
//    private static Map<String, Integer> map_points = new TreeMap<>();

    // 각자의 친구 목록을 자료구조 hashmap 을 사용해 구현한다.
    private static void makeFriendsMap(List<List<String>> friends, Map<String, ArrayList> map_friends) {
        for (List<String> list : friends) {
            putFriendsToMap(list, map_friends);
        }
    }

    // 각 사용자 별로 친구 목록을 저장하는 메서드
    private static void putFriendsToMap(List<String> list, Map<String, ArrayList> map_friends) {
        ArrayList A_List = map_friends.getOrDefault(list.get(0), new ArrayList());
        ArrayList B_List = map_friends.getOrDefault(list.get(1), new ArrayList());

        A_List.add(list.get(1));
        B_List.add(list.get(0));

        map_friends.put(list.get(0), A_List);
        map_friends.put(list.get(1), B_List);
    }

    // 함께 아는 친구 점수 추가해주는 메서드
    private static void friendsPlusPoint(String user, ArrayList arrayList,
                                         Map<String, Integer> map_points, Map<String, ArrayList> map_friends) {
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
    private static void visitorPlusPoint(List<String> visitors, ArrayList arrayList, Map<String, Integer> map_points) {
        for (String str : visitors) {
            putPointsToMap(str, arrayList, map_points);
        }
    }

    // 각 사용자 별로 추천 점수를 저장해주는 메서드
    private static void putPointsToMap(String str, ArrayList arrayList, Map<String, Integer> map_points) {
        if (!arrayList.contains(str)) {
            map_points.put(str, map_points.getOrDefault(str, 0) + 1);
        }
    }

    // map_points 를 정렬하는 메서드
    private static void sortPointList(List<String> answer, Map<String, Integer> map_points) {
        List<String> keySet = new ArrayList<>(map_points.keySet());
        // Value 값으로 오름차순 정렬
        keySet.sort((o1, o2) -> map_points.get(o2).compareTo(map_points.get(o1)));
        for (String str : keySet) {
            addAnswer(answer, str, map_points);
        }
    }

    // 점수가 0점인 사용자를 제외하고 정렬한 순서에 따라 정답에 넣어주는 메서드
    private static void addAnswer(List<String> answer, String str, Map<String, Integer> map_points) {
        if (map_points.get(str) != 0) {
            answer.add(str);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, ArrayList> map_friends = new HashMap<>();
        Map<String, Integer> map_points = new TreeMap<>();

//        makeFriendsMap(friends, map_friends);
        for (List<String> list : friends) {
            ArrayList A_List = map_friends.getOrDefault(list.get(0), new ArrayList());
            ArrayList B_List = map_friends.getOrDefault(list.get(1), new ArrayList());

            A_List.add(list.get(1));
            B_List.add(list.get(0));

            map_friends.put(list.get(0), A_List);
            map_friends.put(list.get(1), B_List);
        }

//        friendsPlusPoint(user, arrayList, map_points, map_friends);
        for (String str : map_friends.keySet()) {
            if (!str.equals(user) && map_friends.get(user) != null) {
                ArrayList friendList = map_friends.get(str); // jun {donut, shakevan}
                for (int i = 0; i < map_friends.get(user).size(); i++) { // donut shakevan
                    // 사용자와 친구관계 일 경우 추천 점수 +10 이 적용되지 않도록 코드 수정
                    if (friendList.contains(map_friends.get(user).get(i)) && !friendList.contains(user)) {
                        map_points.put(str, map_points.getOrDefault(str, 0) + 10);
                    }
                }
            }
        }
//        visitorPlusPoint(visitors, arrayList, map_points);
        // 사용자 즉 , user 로 주어진 사용자의 친구가 없을 경우 null 예외사항 처리를 위한 코드 수정
        for (String visitor : visitors) {
            if (map_friends.get(user) != null) {
                if (!map_friends.get(user).contains(visitor)) {
                    map_points.put(visitor, map_points.getOrDefault(visitor, 0) + 1);
                }
            } else {
                map_points.put(visitor, map_points.getOrDefault(visitor, 0) + 1);
            }
        }
//        sortPointList(answer, map_points);

        List<String> keySet = new ArrayList<>(map_points.keySet());
        // Value 값으로 오름차순 정렬
        keySet.sort((o1, o2) -> map_points.get(o2).compareTo(map_points.get(o1)));
        int idx = 0;
        for (String str : keySet) {
            if (idx == 5) {
                break;
            }
            answer.add(str);
            idx++;
        }

        return answer;
    }
}
