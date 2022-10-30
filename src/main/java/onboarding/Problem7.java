package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static class User {
        private String id;
        private int score;
        private List<String> friends;

        public User(String id) {
            this.id = id;
            this.score = 0;
            this.friends = new ArrayList<>();
        }

        public String getId() {
            return id;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public void addFriend(String friend) {
            this.friends.add(friend);
        }

        public List<String> getFriends() {
            return friends;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
