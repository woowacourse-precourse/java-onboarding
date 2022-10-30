package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static class User {

        private String name;
        private List<String> friends;
        private Map<String, Integer> friendRecommendScore = new HashMap<>();

        public User() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getFriends() {
            return friends;
        }

        public void setFriends(List<String> friends) {
            this.friends = friends;
        }

        public Map<String, Integer> getFriendRecommendScore() {
            return friendRecommendScore;
        }

        public void setFriendRecommendScore(Map<String, Integer> friendRecommendScore) {
            this.friendRecommendScore = friendRecommendScore;
        }
    }

}
