package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void scoreFriendOfFriend(HashMap<String, Integer> scoreRecordMap, String user, HashMap<String, ArrayList<String>> relationshipMap) {
        ArrayList<String> friendListOfUser = relationshipMap.get(user);

        for (String friend :
                friendListOfUser) {
            if (relationshipMap.containsKey(friend)) {
                for (String friendOfFriend :
                        relationshipMap.get(friend)) {
                    if (!Objects.equals(friendOfFriend, user)) {
                        if (!scoreRecordMap.containsKey(friendOfFriend)) {
                            scoreRecordMap.put(friendOfFriend, 10);
                        }
                        int value = scoreRecordMap.get(friendOfFriend);
                        value += 10;
                        scoreRecordMap.put(friendOfFriend, value);
                    }
                }
            }
        }
    }

    private static HashMap<String, ArrayList<String>> registerRelationshipMap(List<List<String>> friends) {
        HashMap<String, ArrayList<String>> relationshipMap = new HashMap<>();

        for (List<String> relation :
                friends) {
            for (int i = 0; i < 2; i++) {
                ArrayList<String> value;
                String person1 = relation.get(i);
                String person2 = relation.get(1 - i);

                if (relationshipMap.containsKey(person1)) {
                    value = relationshipMap.get(person1);
                } else {
                    value = new ArrayList<>();
                }

                value.add(person2);
                relationshipMap.put(person1, value);
            }
        }
        return relationshipMap;
    }
}
