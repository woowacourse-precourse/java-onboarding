package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> relations = new HashMap<>();
        /*사용자와 친구들 관계 구현*/
        userAndFriendRelations(user, friends, relations);
        /*사용자와 함께 아는 친구의 수 점수 구하기*/
        Map<String, Integer> scores = saveScoreOfFriend(user, relations);
        /*사용자의 타임 라인에 방문한 횟수 점수 구하기*/
        for (String visitor : visitors) {
            if (scores.containsKey(visitor)) {
                scores.put(visitor, scores.get(visitor) + 1);
                continue;
            }
            List<String> userRelations = relations.get(user);
            validateUserRelation(scores, visitor, userRelations);
        }
        /*점수가 가장 높은 순으로 정렬, 점수가 같은 경우는 이름순으로 정렬*/
        List<Recommend> tmpAnswer = scores.entrySet()
                            .stream()
                            .map(k -> new Recommend(k.getKey(), k.getValue()))
                            .collect(Collectors.toCollection(ArrayList::new));

        answer = tmpAnswer.stream()
                .sorted(Comparator.comparing(Recommend::getScore).reversed()
                        .thenComparing(Recommend::getName))
                .map(x -> x.getName())
                .collect(Collectors.toList());
        return answer;
    }

    private static void userAndFriendRelations(String user, List<List<String>> friends, Map<String, List<String>> relations) {
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            if (!relations.containsKey(friendA)) {
                relations.put(friendA, new ArrayList<>());
            }
            if (!relations.containsKey(friendB)) {
                relations.put(friendB, new ArrayList<>());
            }
            if (!friendB.equals(user)) {
                relations.get(friendA).add(friendB);
            }
            if (!friendA.equals(user)) {
                relations.get(friendB).add(friendA);
            }
        }
    }

    private static Map<String, Integer> saveScoreOfFriend(String user, Map<String, List<String>> relations) {
        Map<String, Integer> scores = new HashMap<>();
        for (String friendRecommend : relations.get(user)) {
            List<String> recommend = relations.get(friendRecommend);
            for (String friend : recommend) {
                if (scores.containsKey(friend)) {
                    scores.put(friend, scores.get(friend) + 10);
                    continue;
                }
                scores.put(friend, 10);
            }
        }
        return scores;
    }

    private static void validateUserRelation(Map<String, Integer> scores, String visitor, List<String> userRelations) {
        for (String userRelation : userRelations) {
            if (userRelation.equals(visitor)) {
                return;
            }
        }
        scores.put(visitor, 1);
    }

    private static class Recommend {
        private String name;
        private int score;

        public Recommend(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }
}