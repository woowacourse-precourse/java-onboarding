package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Map<String,Integer> getScoreList(Map<String, List<String>> friendList, List<String> visitors, String user) {
        //사용자와 함께 아는 친구의 수 +10점
        Map<String, Integer> scoreList = new HashMap<>();
        List<String> userFriendList = friendList.get(user);
        for (String friend : friendList.keySet()) {
            List<String> list = friendList.get(friend);
            int score = getScore(userFriendList, list);
            scoreList.put(friend, score);
        }

        //사용자의 타임 라인에 방문한 횟수 +1점
        for (String visitor : visitors) {
            if (!scoreList.containsKey(visitor)) {
                scoreList.put(visitor, 1);
            }else {
                Integer score = scoreList.get(visitor);
                score++;
                scoreList.replace(visitor, score);
            }
        }

        return scoreList;
    }

    private static int getScore(List<String> userFriendList, List<String> friendList) {
        int score = 0;
        for (String userFriend : userFriendList) {
            if (friendList.contains(userFriend)) {
                score += 10;
            }
        }
        return score;
    }

    public static Map<String, List<String>> friendList(List<List<String>> friends) {
        Map<String, List<String>> friendList = new HashMap<>();
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            addFriend(friendList, friend1, friend2);
            addFriend(friendList, friend2, friend1);
        }
        return friendList;
    }

    private static void addFriend(Map<String, List<String>> friendList, String friend1, String friend2) {
        //friend값이 처음으로 리스트에 들어오면 초기화 진행
        if (!friendList.containsKey(friend1)) {
            friendList.put(friend1, new ArrayList<>());
            friendList.get(friend1).add(friend2);
            return;
        }
        friendList.get(friend1).add(friend2);
    }
}
