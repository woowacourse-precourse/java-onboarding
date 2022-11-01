package onboarding;

import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        String user = "hello";
        List<List<String>> friends = List.of(
                List.of("andole", "jun"),
                List.of("andole", "bedi"),
                List.of("jun", "shakevan"),
                List.of("jun", "kane"),
                List.of("jun", "sam"),
                List.of("bedi", "shakevan"),
                List.of("bedi", "anne"),
                List.of("bedi", "sam"),
                List.of("anne", "mrko")
        );
        List<String> visitors = List.of("donut", "anne", "mrko", "mrko", "sam");
        System.out.println(solution(user, friends, visitors));
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
                    if (user != friendOfFriendName && !friendsSet.contains(friendOfFriendName)) {
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

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(pointsMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });

        System.out.println(entryList);

        List<String> answer = new ArrayList<>();

        if (entryList.size() > 5) {
            for (int i = 0; i < 5; i++) {
                answer.add(entryList.get(i).getKey());
            }
        } else {
            for (int i = 0; i < entryList.size(); i++) {
                answer.add(entryList.get(i).getKey());
            }
        }

        return answer;
    }

    private static String IsLeftOrRight(List<String> friend, String user) {
        if (friend.get(0).equals(user)) {
            return friend.get(1);
        } else {
            return friend.get(0);
        }
    }
}
