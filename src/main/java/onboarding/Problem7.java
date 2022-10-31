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
