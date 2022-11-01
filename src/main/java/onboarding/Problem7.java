package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        FriendRecommendationAlgorithm friendRecommendationAlgorithm
                = new FriendRecommendationAlgorithm(user, friends, visitors);

        answer = friendRecommendationAlgorithm.result();
        return answer;
    }

    static class FriendRecommendationAlgorithm {

        private final String user;
        private final List<List<String>> friends;
        private final List<String> visitors;

        public FriendRecommendationAlgorithm(String user, List<List<String>> friends, List<String> visitors) {
            this.user = user;
            this.friends = friends;
            this.visitors = visitors;
        }

        public List<String> result() {

            List<String> acquaintance = getAcquaintance();
            Map<String, Integer> result = new HashMap<>();

            return getNameList(result);
        }

        private List<String> getNameList(Map<String, Integer> result) {

            List<Map.Entry<String, Integer>> collect = result.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toList());

            int count = 1;
            List<String> answer = new ArrayList<>();

            for (Map.Entry<String, Integer> nameScoreEntity : collect) {

                if (count > 5 || nameScoreEntity.getValue() == null) {
                    break;
                }

                answer.add(nameScoreEntity.getKey());
                count++;
            }
            return answer;
        }

        private List<String> getAcquaintance() {

            List<String> acquaintance = new ArrayList<>();

            for (List<String> friend : friends) {

                if (friend.get(0).equals(user)) {
                    acquaintance.add(friend.get(1));
                } else if (friend.get(1).equals(user)) {
                    acquaintance.add(friend.get(0));
                }
            }

            return acquaintance;
        }
    }
}
