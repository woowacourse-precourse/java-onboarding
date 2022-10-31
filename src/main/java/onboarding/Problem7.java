package onboarding;

import java.util.*;

public class Problem7 {
    public static HashMap<String, Integer> score;
    public static HashSet<String> friendOfUser;
    public static void Hashing(String user, List<List<String>> friends, List<String> visitors) {
        score = new HashMap<>();

        score.put(user, 0);
        for (List<String> i : friends) {
            score.put(i.get(0), 0);
            score.put(i.get(1), 0);
        }
        for (String i : visitors) {
            score.put(i, 0);
        }
    }

    public static void scoringWithFriends(String user, List<List<String>> friends) {
        // user의 친구들을 모두 모음.
        friendOfUser = new HashSet<>();
        for (List<String> i : friends) {
            if (i.get(0) == user) friendOfUser.add(i.get(1));
            if (i.get(1) == user) friendOfUser.add(i.get(0));
        }

        // 점수 계산
        for (List<String> i : friends) {
            if (friendOfUser.contains(i.get(0))) {
                score.put(i.get(1), score.get(i.get(1)) + 10);
            }
            if (friendOfUser.contains(i.get(1))) {
                score.put(i.get(0), score.get(i.get(0)) + 10);
            }
        }
    }

    public static void scoringWithVisits(List<String> visitors) {
        for (String i : visitors) {
            score.put(i, score.get(i) + 1);
        }
    }

    public static List<String> get5PeopleWithTheHighestScore(String user) {
        // 점수에 따라 내림차순 정렬
        List<Map.Entry<String, Integer>> scoreList = new LinkedList<>(score.entrySet());

        scoreList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()) return o2.getValue() - o1.getValue();
                else return o1.getKey().compareTo(o2.getKey());
            }
        });

        // 최대 5명의 이름을 반환.
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> i : scoreList) {
            if (i.getValue() == 0) break;

            if (i.getKey() == user) continue;
            if (friendOfUser.contains(i.getKey())) continue;
            result.add(i.getKey());

            if (result.size() == 5) break;
        }

        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 친구들의 이름과 점수를 map으로 저장
        Hashing(user, friends, visitors);

        // 사용자와 함께 아는 친구의 수에 따른 점수 계산
        scoringWithFriends(user, friends);

        // 방문 횟수에 따른 점수 계산
        scoringWithVisits(visitors);

        // 점수가 가장 높은 순으로 정렬하여 최대 5명을 return
        List<String> answer = get5PeopleWithTheHighestScore(user);

        for (String i : answer) {
            System.out.print(i + ' ');
            System.out.println(score.get(i));
        }

        return answer;
    }
}
