package onboarding;

import java.util.*;

/**
 * 기능 목록
 * 1. 친구 관계를 인접 리스트로 나타내기
 * 2. 사용자와 함께 아는 친구에게 10점씩 주기
 * 3. 방문한 친구에게 1점씩 주기
 * 4. 사용자, 사용자가 아는 사람들은 결과에 영향을 안끼치도록 점수 없애기
 * 5. 점수와 이름으로 정렬하기
 * 6. 최대 5명의 이름 반환하기
 */
public class Problem7 {
    static class Score {
        int score;
        String name;
        Score(int s, String n) {
            this.score = s;
            this.name = n;
        }
    }
    static Map<String, List<String>> makeRelation(List<List<String>> friends) {
        Map<String, List<String>> relation = new HashMap<>();

        for (List<String> friend: friends) {
            String p0 = friend.get(0), p1 = friend.get(1);

            List<String> l0 = new ArrayList<>();
            if (relation.containsKey(p0)) {
                l0 = relation.get(p0);
            }
            l0.add(p1);
            relation.put(friend.get(0), l0);

            List<String> l1 = new ArrayList<>();
            if (relation.containsKey(p1)) {
                l1 = relation.get(p1);
            }
            l1.add(p0);
            relation.put(friend.get(1), l1);
        }
        return relation;
    }

    static void score10(String user, Map<String, List<String>> relation, Map<String, Integer> scores) {
        for (String userFriend: relation.get(user)) {
            for (String friends: relation.get(userFriend)) {
                if (scores.containsKey(friends)) {
                    scores.put(friends, scores.get(friends) + 10);
                } else {
                    scores.put(friends, 10);
                }
            }
        }
    }

    static void score1(List<String> visitors, Map<String, Integer> scores) {
        for (String visitor: visitors) {
            if (scores.containsKey(visitor)) {
                scores.put(visitor, scores.get(visitor) + 1);
            } else {
                scores.put(visitor, 1);
            }
        }
    }

    static void exceptUserFriends(String user, Map<String, Integer> scores, List<String> userFreinds) {
        userFreinds.add(user);
        for (String userFriend: userFreinds) {
            scores.remove(userFriend);
        }
    }

    static List<Score> SortByScoreAndName(Map<String, Integer> scores) {
        List<Score> result = new ArrayList<>();
        for (String key: scores.keySet()) {
            result.add(new Score(scores.get(key), key));
        }

        Comparator<Score> comparator = (a, b) -> {
            if (a.score != b.score)
                return b.score - a.score;
            return a.name.compareTo(b.name);
        };
        result.sort(comparator);
        return result;
    }

    static List<String> getTop(List<Score> sortList, int num) {
        int size =  sortList.size();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            if (size <= i)
                break;
            result.add(sortList.get(i).name);
        }
        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> relation = makeRelation(friends);
        Map<String, Integer> scores = new HashMap<>();
        score10(user, relation, scores);
        score1(visitors, scores);
        exceptUserFriends(user, scores, relation.get(user));

        List<Score> sortList = SortByScoreAndName(scores);
        return getTop(sortList, 5);
    }
}
