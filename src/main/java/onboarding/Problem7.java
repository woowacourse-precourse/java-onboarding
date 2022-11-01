package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> findAllFriends(String user, List<List<String>> friends) {
        List<String> friendsList = new ArrayList<>();

        for(List<String> friendRelationship : friends) {
            if(friendRelationship.contains(user)) {
                friendsList.add(
                        (friendRelationship.get(0).equals(user))? friendRelationship.get(1) : friendRelationship.get(0)
                );
            }
        }

        return friendsList;
    }
}
