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
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        solution(user, friends, visitors);
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> pointsMap = new HashMap<>();
        int score = 0;
        Set<String> friendsSet = new HashSet<>();

        // friendsSet 해시set에 user의 친구 입력하기
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                String friendName = IsLeftOrRight(friends.get(i), user);
                friendsSet.add(friendName);
            }
        }

        System.out.println(friendsSet);

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

        System.out.println(pointsMap);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> findFriendOfUser(String user, List<List<String>> friends) {
        List<String> listFriendOfUser = new ArrayList<>();


        return listFriendOfUser;
    }

    private static String IsLeftOrRight(List<String> friend, String user) {
        if (friend.get(0).equals(user)) {
            return friend.get(1);
        } else {
            return friend.get(0);
        }
    }
}
