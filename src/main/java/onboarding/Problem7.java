package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    class User{
        final String name;
        List<String> friends;
        List<String> visitor;
        int score;

        public User(String name) {
            this.name = name;
            this.friends = new ArrayList<>();
            this.visitor = new ArrayList<>();
            this.score = 0;
        }

        public void addFriend(String name){
            friends.add(name);
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }
}
