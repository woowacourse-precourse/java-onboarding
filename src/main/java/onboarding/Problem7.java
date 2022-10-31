package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        return answer;
    }

    public static List<String> getAlreadyFriend(String user, List<List<String>> friends) {
        List<String> alreadyFriend = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                alreadyFriend.add(friends.get(i).get(0));
            }
        }
        return alreadyFriend;
    }
    public static List<List<String>> getFriendCountKnownTogether(String user, List<String> alreadyFriend, List<List<String>> friends) {
        List<List<String>> recommendationFriend = new ArrayList<>();

        for (int i = 0; i < alreadyFriend.size(); i++) {
            for (int j = 0; j < friends.size(); j++) {
                if (friends.get(j).get(0).equals(alreadyFriend.get(i)) && !friends.get(j).contains(user)) {
                    recommendationFriend.add(List.of(friends.get(j).get(1), "10"));
                }
            }
        }
        return recommendationFriend;
    }
//    public static List<String> getCountofVisitor() {}
//    public static List<String> getRecommendedFriend() {}
//    public static void sortByScore() {}

}
