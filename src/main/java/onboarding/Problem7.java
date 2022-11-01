package onboarding;

import java.util.*;

public class Problem7 {
    static class RecommendAlgorithm {
        List<String> userKnownMembers = new ArrayList<>();
        List<List<String>> userUnknownMembers = new ArrayList<>();

        String user;

        public void setUser(String user) {
            this.user = user;
        }

        public void checkUserFriends (List<List<String>> friends){
            for (List<String> friend : friends) {
                if (friend.contains(user)) {
                    friend.stream()
                            .filter(f -> !f.equals(user))
                            .forEach(x -> userKnownMembers.add(x));
                }
                else {
                    userUnknownMembers.add(friend);
                }
            }

        }

    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = Collections.emptyList();

        return answer;
    }

}
