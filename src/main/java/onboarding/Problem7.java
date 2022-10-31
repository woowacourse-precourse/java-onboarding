package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        UserRelation userRelation = new UserRelation(user, friends);
        UserScore userScore = new UserScore(user, userRelation.getRelations(), visitors);

        return userScore.getTop5();
    }

    private static class UserScore {
        private String user;
        private List<String> userFriends;
        private Map<String, Integer> score = new HashMap<>();

        public UserScore(String user, Map<String, List<String>> relations, List<String> visitors) {
            this.user = user;
            this.userFriends = relations.get(user);
            addAcquaintanceScore(user, relations, userFriends);
            addVisitorScore(visitors, userFriends);
        }

        public List<String> getTop5() {
            return score.keySet()
                .stream()
                .sorted((String s1, String s2) -> {
                    if(score.get(s1).equals(score.get(s2))){
                        return s1.compareTo(s2);
                    }
                    return score.get(s2) - score.get(s1);
                })
                .limit(5)
                .collect(Collectors.toList());
        }

        private void addAcquaintanceScore(String user, Map<String, List<String>> relations, List<String> userFriends) {
            Set<String> keys = relations.keySet();
            for(String key : keys) {
                int cnt = 0;
                if(key.equals(user) || userFriends.contains(key)) continue;
                for(String friend : relations.get(key)) {
                    if(userFriends.contains(friend)) {
                        cnt++;
                    }
                }
                if(cnt != 0) {
                    score.put(key, 10*cnt);
                }
            }
        }

        private void addVisitorScore(List<String> visitors, List<String> userFriends) {
            for(String visitor : visitors) {
                if(userFriends.contains(visitor)) continue;
                score.put(visitor, score.getOrDefault(visitor, 0)+1);
            }
        }
    }

    private static class UserRelation {
        private String user;
        private Map<String, List<String>> relations = new HashMap<>();

        public UserRelation(String user, List<List<String>> friends) {
            this.user = user;
            relateFriend(friends);
        }

        public String getUser() {
            return user;
        }

        public Map<String, List<String>> getRelations() {
            return relations;
        }

        private void relateFriend(List<List<String>> friends) {
            for(List<String> friend : friends) {
                String s1 = friend.get(0);
                String s2 = friend.get(1);
                if(relations.containsKey(s1)) {
                    relations.get(s1).add(s2);
                } else {
                    relations.put(s1, new ArrayList<>(List.of(s2)));
                }

                if(relations.containsKey(s2)) {
                    relations.get(s2).add(s1);
                } else {
                    relations.put(s2, new ArrayList<>(List.of(s1)));
                }
            }
        }
    }
}
