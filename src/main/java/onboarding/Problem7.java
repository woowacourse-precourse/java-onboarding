package onboarding;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.*;

public class Problem7 {
    static HashMap<String, Integer> scoreMap = new HashMap<>();
    static HashMap<String, Boolean> userFriendMap = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        userFriendMap.put(user, true);
        recordUserFriends(user, friends);
        setScoreOfKnown(user, friends);
        setScoreOfVisit(visitors);

        List<String> keySetList = new ArrayList<>(scoreMap.keySet());
        Collections.sort(keySetList);
        Collections.sort(keySetList, (o1, o2) -> (scoreMap.get(o2).compareTo(scoreMap.get(o1))));
        List<String> answer = new ArrayList<>(keySetList.subList(0,keySetList.size() > 5 ? 5 : keySetList.size()));
        return answer;
    }
    static void recordUserFriends(String user, List<List<String>> friends) {
        for (List<String> friend: friends) {
            if (friend.get(0).equals(user) || friend.get(1).equals(user)) {
                if (friend.get(0).equals(user)) {
                    userFriendMap.put(friend.get(1), true);
                } else {
                    userFriendMap.put(friend.get(0), true);
                }
            }
        }
    }
    static void setScoreOfKnown(String user, List<List<String>> friends) {
        for (List friend: friends) {
            String A = (String) friend.get(0);
            String B = (String) friend.get(1);
            if (userFriendMap.containsKey(A) && !userFriendMap.containsKey(B)) {
                addScore(10, B);
            } else if (!userFriendMap.containsKey(A) && userFriendMap.containsKey(B)) {
                addScore(10, A);
            }
        }
    }
    static void addScore(int score, String friend) {
        if (scoreMap.containsKey(friend)) {
            scoreMap.put(friend, scoreMap.get(friend) + score);
        } else {
            scoreMap.put(friend, score);
        }
    }
    static void setScoreOfVisit(List<String> visitors) {
        for (String visitor: visitors) {
            if (!userFriendMap.containsKey(visitor)) {
                addScore(1, visitor);
            }
        }
    }
}
