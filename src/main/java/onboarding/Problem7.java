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
//    public static List<String> getFriendCountKnownTogether() {}
//    public static List<String> getCountofVisitor() {}
//    public static List<String> getRecommendedFriend() {}
//    public static void sortByScore() {}

}
