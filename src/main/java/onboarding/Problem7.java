package onboarding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {

    static class Friend implements Comparable<Friend> {
        private String name;
        private int score;
        private List<String> myFriends;

        Friend (String name, int score) {
            this.name = name;
            this.score = score;
            myFriends = new ArrayList<>();
        }

        @Override
        public int compareTo(Friend o) {
            if (this.score == o.score) {
                return name.compareTo(o.name);
            }

            return o.score - score;
        }

        public void addScore(int score) {
            this.score += score;
        }

        public String getName() {
            return name;
        }

        public List<String> getMyFriends() {
            return myFriends;
        }
    }

    public static List<String> solution(String user, List<List<String>> friendships, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
