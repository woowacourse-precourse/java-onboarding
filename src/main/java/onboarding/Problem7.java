package onboarding;

import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        String user = "andole";
        List<List<String>> friends = List.of(
                List.of("andole", "jun"),
                List.of("donut", "jun"),
                List.of("donut", "shakevan"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "bedi"),
                List.of("anne", "jun")
//                List.of("shakevan", "jun"),
//                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("donut", "mrko", "peter", "sam");
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
        System.out.println("친구는 누구인가? : " + friendsSet);

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
        System.out.println("친구의 친구는 누구인가? : " + pointsMap.keySet());

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

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(pointsMap.entrySet());
        entries.sort((v1, v2) -> (v2.getValue().compareTo(v1.getValue())));

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            answer.add(entries.get(i).getKey());
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

//    private static List<String> printTop5(List<String> sortedList) {
//        List<String> top5List = new ArrayList<>();
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(sortedList.get(i));
//        }
//        return top5List;
//    }
}
