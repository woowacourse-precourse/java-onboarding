package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> friendsList;
    public static Map<String, Integer> recommendScore;
    public static Map<String, List<String>> relationships;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendsList = new ArrayList<>();
        recommendScore = new HashMap<>();
        relationships = new HashMap<>();

        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void initFriendsList(List<String> relationship, String user) {
        String userA = relationship.get(0);
        String userB = relationship.get(1);

        if(userA.equals(user)){
            friendsList.add(userB);
            return;
        }
        friendsList.add(userA);
    }

}
