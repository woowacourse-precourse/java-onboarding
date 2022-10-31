package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> saveUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        // 사용자의 친구 리스트 저장하기
        for (int i=0; i<friends.size(); i++) {
            if (friends.get(i).get(0).equals(user) && !userFriends.contains(friends.get(i).get(1))) {
                userFriends.add(friends.get(i).get(1));
            }

            if (friends.get(i).get(1).equals(user) && !userFriends.contains(friends.get(i).get(0))) {
                userFriends.add(friends.get(i).get(0));
            }
        }

        return userFriends;
    }

    public static HashMap<String, Integer> saveScoreByfriends(List<String> userFriends, List<List<String>> friends, String user) {
        HashMap<String, Integer> scores = new HashMap<>();

        // 친구 목록에서 사용자의 친구의 친구 찾기
        for (int i=0; i<userFriends.size(); i++) {
            String userFriendName = userFriends.get(i);
            for (int j=0; j<friends.size(); j++) {
                if (friends.get(j).contains(user)) continue;
                if (friends.get(j).get(0).equals(userFriendName) && !userFriends.contains(friends.get(j).get(1))) {
                    // 내 친구를 발견했고, 친구의 친구가 내 친구가 아니라면 저장한다.
                    Integer friendScore = scores.get(friends.get(j).get(1));
                    if (friendScore != null) {
                        friendScore += 10;
                        scores.put(friends.get(j).get(1), friendScore);
                    } else {
                        scores.put(friends.get(j).get(1), 10);
                    }
                }

                if (friends.get(j).get(1).equals(userFriendName) && !userFriends.contains(friends.get(j).get(0))) {
                    // 내 친구를 발견했고, 친구의 친구가 내 친구가 아니라면 저장한다.
                    Integer friendScore = scores.get(friends.get(j).get(0));
                    if (friendScore != null) {
                        friendScore += 10;
                        scores.put(friends.get(j).get(0), friendScore);
                    } else {
                        scores.put(friends.get(j).get(0), 10);
                    }
                }
            }
        }

        return scores;
    }

    public static HashMap<String, Integer> saveScoreByVisitor(List<String> visitors, List<String> userFriends, HashMap<String, Integer> scores) {
        // 사용자의 타임 라인에 방문한 횟수 저장
        for (int i=0; i<visitors.size(); i++) {
            if (userFriends.contains(visitors.get(i))) continue;
            Integer friendScore = scores.get(visitors.get(i));
            if (friendScore != null) {
                friendScore++;
                scores.put(visitors.get(i), friendScore);
            } else {
                scores.put(visitors.get(i), 1);
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // List<String> answer = Collections.emptyList();
        List<String> answer = new ArrayList<>();
        List<String> userFriends;
        HashMap<String, Integer> scores;

        userFriends = saveUserFriends(user, friends);
        scores = saveScoreByfriends(userFriends, friends, user);
        scores = saveScoreByVisitor(visitors, userFriends, scores);

       return answer;
    }
}
