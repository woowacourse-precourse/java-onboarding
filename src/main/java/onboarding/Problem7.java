package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> list = new ArrayList<>();
        TreeMap<String, Integer> score = new TreeMap<>();

        searchFriend(user, friends, list);
        addScore(user, list, friends, score);

        System.out.println(score);
        return answer;
    }

    // 사용자와 친구인 사람의 목록을 작성하는 메서드
    static void searchFriend(String user, List<List<String>> friends, List<String> list) {
        for (int i = 0; i < friends.size(); i++) {
            if (user.equals(friends.get(i).get(0))) {
                list.add(friends.get(i).get(1));
            }
            if (user.equals(friends.get(i).get(1))) {
                list.add(friends.get(i).get(0));
            }
        }
    }

    // 친구와 함께 아는 사람에게 점수를 부여하는 메서드
    static void addScore(String user, List<String> list, List<List<String>> friends, TreeMap<String, Integer> score) {
        for (int i = 0; i < list.size(); i++) {
            String friend = list.get(i);
            for (int j = 0; j < friends.size(); j++) {
                if (friend.equals(friends.get(j).get(0)) && !user.equals(friends.get(j).get(1))) {
                    score.put(friends.get(j).get(1), score.getOrDefault(friends.get(j).get(1), 0) + 10);
                }
                if (friend.equals(friends.get(j).get(1)) && !user.equals(friends.get(j).get(1))) {
                    score.put(friends.get(j).get(0), score.getOrDefault(friends.get(j).get(0), 0) + 10);
                }
            }
        }
    }
}
