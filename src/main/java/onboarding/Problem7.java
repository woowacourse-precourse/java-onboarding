package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> friendsInformation = initializeFriendsInformation(friends);
        return answer;
    }

    public static Map<String, List<String>> initializeFriendsInformation(List<List<String>> friends) {
        Map<String, List<String>> friendsInformation = new HashMap<>();
        for(List<String> relationship : friends) {
            String person1 = relationship.get(0);
            String person2 = relationship.get(1);
            if(!friendsInformation.containsKey(person1)){
                friendsInformation.put(person1, new ArrayList<>());
            }
            friendsInformation.get(person1).add(person2);
            if(!friendsInformation.containsKey(person2)){
                friendsInformation.put(person2, new ArrayList<>());
            }
            friendsInformation.get(person2).add(person1);
        }
        return friendsInformation;
    }
}
