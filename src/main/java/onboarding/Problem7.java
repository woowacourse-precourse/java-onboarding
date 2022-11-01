package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> list = new ArrayList<>();
        TreeMap<String, Integer> score = new TreeMap<>();

        searchFriend(user, friends, list);
        addScore(user, list, friends, score);
        addVisitScore(visitors, list, score);
        removeOverLap(list, score);
        answer = sortScore(score);

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
    static void addScore(String user, List<String> list, List<List<String>> friends, Map<String, Integer> score) {
        for (int i = 0; i < list.size(); i++) {
            String friend = list.get(i);
            for (int j = 0; j < friends.size(); j++) {
                if (friend.equals(friends.get(j).get(0)) && !user.equals(friends.get(j).get(1))) {
                    score.put(friends.get(j).get(1), score.getOrDefault(friends.get(j).get(1), 0) + 10);
                }
                if (friend.equals(friends.get(j).get(1)) && !user.equals(friends.get(j).get(0))) {
                    score.put(friends.get(j).get(0), score.getOrDefault(friends.get(j).get(0), 0) + 10);
                }
            }
        }
    }

    // 사용자의 타임 라인에 방문한 사람에게 점수를 부여하는 메서드
    static void addVisitScore(List<String> visitors, List<String> list, Map<String, Integer> score) {
        List<String> temp = new ArrayList<>(visitors);
        temp.removeAll(list);

        for (int i = 0; i < temp.size(); i++) {
            score.put(temp.get(i), score.getOrDefault(temp.get(i), 0) + 1);
        }
    }

    // score에서 중복을 제거하는 메서드
    static void removeOverLap(List<String> list, Map<String, Integer> score) {
        for (int i = 0; i < list.size(); i++) {
            score.containsKey(list.get(i));
            score.remove(list.get(i));
        }
    }

    // 정렬하는 메서드
    static List<String> sortScore(Map<String, Integer> score) {
        List<String> result = new ArrayList<>(score.keySet());
        result.sort((Comparator.comparingInt(score::get).reversed()));

        if (result.size() > 5) {
            result = result.subList(0, 5);
        }
        return result;
    }
}
