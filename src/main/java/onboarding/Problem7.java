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

        private String user;
        private List<List<String>> friends;
        private List<String> visitors;

        public FriendRecommendationAlgorithm(String user, List<List<String>> friends, List<String> visitors) {
            this.user = user;
            this.friends = friends;
            this.visitors = visitors;
        }

        public List<String> result() {

            List<String> acquaintance = getAcquaintance();
            Map<String, Integer> result = new HashMap<>();

            calculateAcquaintanceScore(acquaintance, result);
            calculateVisitorScore(acquaintance, result);

            return getAnswer(result);
        }

        private static List<String> getAnswer(Map<String, Integer> result) {
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

        private void calculateAcquaintanceScore(List<String> acquaintance, Map<String, Integer> result) {
            for (List<String> friend : friends) {

                for (String aqt : acquaintance) {
                    if (friend.get(0).equals(aqt) && !friend.get(1).equals(user)) {
                        result.put(friend.get(1), getValue(result, friend.get(1)) + 10);
                    } else if (friend.get(1).equals(aqt) && !friend.get(0).equals(user)) {
                        result.put(friend.get(0), getValue(result, friend.get(0)) + 10);
                    }
                }
            }
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

        private void calculateVisitorScore(List<String> acquaintance, Map<String, Integer> result) {
            for (String visitor : visitors) {

                boolean isFriend = false;

                for (String aqt : acquaintance) {

                    if (aqt.equals(visitor)) {
                        isFriend = true;
                        break;
                    }
                }

                if (!isFriend) {
                    result.put(visitor, getValue(result, visitor) + 1);
                }

            }
        }

        private int getValue(Map<String, Integer> result, String friend) {
            Integer integer = result.get(friend);
            return integer == null ? 0 : integer;
        }
    }
}
