package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    private static HashMap<String, List<String>> friendsRelation(List<List<String>> friends) {
        HashMap<String, List<String>> relation = new HashMap<String, List<String>>();
        for (List<String> twoFriends : friends) {
            List<String> basic = new ArrayList<String>();
            String person1 = twoFriends.get(0);
            String person2 = twoFriends.get(1);
            List<String> friends1 = relation.getOrDefault(person1, basic);
            List<String> friends2 = relation.getOrDefault(person2, basic);
            friends1.add(person2);
            friends2.add(person1);
            relation.put(person1, friends1);
            relation.put(person2, friends2);
        }
        return relation;
    }

    private static HashMap<String, Integer> scoreRelation(List<String> visitors) {
        HashMap<String, Integer> relation = new HashMap<String, Integer>();
        for (String visitor : visitors) {
            int before = relation.getOrDefault(visitor, 0);
            relation.put(visitor, before+1);
            relation.put(visitor, before+1);
        }
        return relation;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static HashMap<String, Integer> scoreRelation(List<String> candidate, HashMap<String, Integer> scoreRelation) {
        for (String candi : candidate) {
            int before = scoreRelation.getOrDefault(candi, 0);
            scoreRelation.put(candi, before+10);
            scoreRelation.put(candi, before+10);
        }
        return scoreRelation;
    }
    private static HashMap<String, Integer> extraRelation(HashMap<String, List<String>> friendsRelation, HashMap<String, Integer> scoreRelation, String user) {
        List<String> basic = new ArrayList<String> ();
        List<String> friends = friendsRelation.getOrDefault(user, basic);
        for (String friend: friends) {
            List<String> candidate = friendsRelation.getOrDefault(friend, basic);
            scoreRelation = scoreRelation(candidate, scoreRelation);
        }
        scoreRelation = removeFriends(friends, scoreRelation);
        return scoreRelation;
    }
}
