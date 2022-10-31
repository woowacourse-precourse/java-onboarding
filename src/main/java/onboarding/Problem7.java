package onboarding;

import java.util.*;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static Map<String, Integer> checkFriend(String user, ArrayList<List<String>> friendList) {
        Map<String, Integer> friendScoreMap = new HashMap<String, Integer>();

        for (int i = 0; i < friendList.size(); i++) {
            if (friendList.get(i).get(0).equals(user)) {
                friendScoreMap.put(friendList.get(i).get(1), 10);
            }

            else if (friendList.get(i).get(1).equals(user)) {
                friendScoreMap.put(friendList.get(i).get(0), 10);
            }
        }

        return friendScoreMap;
    }

    public static Map<String, Integer> checkVisitor(String user, ArrayList<String> friendList, Map<String, Integer> scoreMap) {
        Map<String, Integer> visitorScoreMap = scoreMap;

        for (int i = 0; i < friendList.size(); i++) {
            if (visitorScoreMap.containsKey(friendList.get(i))) {
                int changeValue = visitorScoreMap.get(friendList.get(i)) + 1;
                visitorScoreMap.put(friendList.get(i), changeValue);
            }
            else {
                visitorScoreMap.put(friendList.get(i), 1);
            }
        }

        return visitorScoreMap;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        ArrayList<List<String>> friendList = new ArrayList<List<String>> ();
        for (int i = 0; i < friends.size(); i++) {
            friendList.add(friends.get(i));
        }

        Map<String, Integer> scoreMap = new HashMap<String, Integer>();

        scoreMap = checkFriend(user, friendList);

        ArrayList<String> visitorList = new ArrayList<String>();
        for (int i = 0; i < visitors.size(); i++) {
            visitorList.add(visitors.get(i));
        }

        scoreMap = checkVisitor(user, visitorList, scoreMap);

        System.out.print(scoreMap);

        return answer;

    }
}
