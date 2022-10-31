package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    private class User implements Comparable<User> {
        int score;
        String name;

        @Override
        public int compareTo(User o) {
            if(this.score==o.score) return this.name.compareTo(o.name);
            return this.score > o.score ? 1 : -1;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, User> users = new HashMap<>();
        return answer;
    }

    private static List<String> findFriends(String userName, List<List<String>> friends){

    }

    private static boolean isMeOrUserFriends(String userName, String user, String userFriends){

    }

    private static List<String> getTop5(Map<String, User> users){

    }
}
