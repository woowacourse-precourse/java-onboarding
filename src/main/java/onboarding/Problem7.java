package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static class RecommendAlgorithm {
        List<String> userKnownMembers = new ArrayList<>();
        List<List<String>> userUnknownMembers = new ArrayList<>();
        String user;

        public void setUser(String user) {
            this.user = user;
        }


        // 1번
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
            for (String friend : userKnownMembers) {
                for (List<String> friendship : userUnknownMembers) {
                    if (friendship.contains(friend)) {
                        friendship.stream()
                                .filter(f -> !f.equals(friend))
                                .forEach(x -> setScore(x, "friends"));
                    }
                }
            }
        }
        public void setScore (String member, String category) {
            if (category == "friends") {
                if (membersScore.containsKey(member)) {
                    membersScore.put(member, membersScore.get(member) + 10);
                } else {
                    membersScore.put(member, 10);
                }
            } else {
                if (membersScore.containsKey(member)) {
                    membersScore.put(member, membersScore.get(member) + 1);
                } else {
                    membersScore.put(member, 1);
                }
            }
        }


    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = Collections.emptyList();

        return answer;
    }

}
