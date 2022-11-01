package onboarding;

import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko"),
                List.of("Kim", "mrko"),
                List.of("andole", "Kim")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "andole");
        solution(user, friends, visitors);
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> pointsMap = new HashMap<>();
        Set<String> friendsSet = new HashSet<>();

        // friendsSet 해시set에 user의 친구 입력하기
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                String friendName = IsLeftOrRight(friends.get(i), user);
                friendsSet.add(friendName);
            }
        }

        // 친구의 친구를 구해서 HashMap에 점수와 함께 저장
        Iterator it = friendsSet.iterator();
        while (it.hasNext()) {
            String friendName = (String) it.next();
            for (int i = 0; i < friends.size(); i++) {
                if (friends.get(i).contains(friendName)) {
                    String friendOfFriendName = IsLeftOrRight(friends.get(i), friendName);
                    if (user != friendOfFriendName) {
                        int point = pointsMap.get(friendOfFriendName) != null ? pointsMap.get(friendOfFriendName) + 10 : 10;
                        pointsMap.put(friendOfFriendName, point);
                    }
                }
            }
        }

        // 방문자 점수 추가
        List<String> friendsList = new ArrayList<>(friendsSet);
        for (int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);
            if (friendsList.contains(visitor)) {
                continue;
            }
            int point = pointsMap.get(visitor) != null ? pointsMap.get(visitor) + 1 : 1;
            pointsMap.put(visitor, point);
        }

        sortMap(pointsMap);


        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static String IsLeftOrRight(List<String> friend, String user) {
        if (friend.get(0).equals(user)) {
            return friend.get(1);
        } else {
            return friend.get(0);
        }
    }

    private static void sortMap(Map<String, Integer> pointsMap) {
        Set<Map.Entry<String, Integer>> set = pointsMap.entrySet();
        System.out.println(set);
        List list = new ArrayList(set);
        System.out.println(list);

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
                    Map.Entry e1 = (Map.Entry) o1;
                    Map.Entry e2 = (Map.Entry) o2;

                    int v1 = (Integer) e1.getValue();
                    int v2 = (Integer) e2.getValue();

                    return v1 > v2 ? 1 : (v1 < v2 ? -1 : 0);
                }
                return 0;
            }
        });
    }
}
