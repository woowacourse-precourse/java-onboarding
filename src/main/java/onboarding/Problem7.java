package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Problem7 {

    public static HashMap<String, Integer> inputHash (List<List<String>> friends) {
        HashSet<String> overlapFriendKeys = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            overlapFriendKeys.add(friends.get(i).get(0));
            overlapFriendKeys.add(friends.get(i).get(1));
        }
        List<String> friendKeys = new ArrayList<>(overlapFriendKeys);
        Collections.sort(friendKeys);

        HashMap<String, Integer> friendsRelation = new HashMap<>(friendKeys.size());

        for (int j = 0; j < friendKeys.size(); j++) {
            friendsRelation.put(friendKeys.get(j), 0);
        }
        return friendsRelation;
    }

    public static HashMap<String, Integer> scoreVisitFriend (HashMap<String, Integer> friendsRelation, List<String> visitors) {
        for (String visitor : visitors) {
            if (!friendsRelation.containsKey(visitor)){
                friendsRelation.put(visitor, 1);
            }else {
                friendsRelation.put(visitor, friendsRelation.get(visitor)+1);
            }
        }
        return friendsRelation;
    }

    public static List<String> sortScore (HashMap<String, Integer> friendsRelation, List<String> yesFriends) {
        List<String> keySetList = new ArrayList<>(friendsRelation.keySet());
        Collections.sort(keySetList);
        Collections.sort(keySetList, ((o1, o2) -> friendsRelation.get(o2).compareTo(friendsRelation.get(o1))));

        List<String> answerList = new ArrayList<>();
        for (String key: keySetList) {
            if (friendsRelation.get(key) == 0) {
                break;
            }else if (yesFriends.contains(key)) {
                continue;
            }else {
                answerList.add(key);
            }
        }

        return answerList;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> friendsRelation = inputHash(friends);
        HashMap<String, Integer> friendsScore = scoreVisitFriend(friendsRelation, visitors);
        List<String> yesFriends = new ArrayList<>();
        List<List<String>> noFriends = new ArrayList<>();

        for (List<String> twoFriends : friends) {
            if (twoFriends.get(0).equals(user)) {
                yesFriends.add(twoFriends.get(1));
            } else if (twoFriends.get(1).equals(user)) {
                yesFriends.add(twoFriends.get(0));
            } else {
                noFriends.add(twoFriends);
            }
        }

        for (List<String> twoNoFriends : noFriends) {
            if (yesFriends.contains(twoNoFriends.get(0))) {
                friendsScore.put(twoNoFriends.get(1), friendsScore.get(twoNoFriends.get(1))+10);
            }else if (yesFriends.contains(twoNoFriends.get(1))) {
                friendsScore.put(twoNoFriends.get(0), friendsScore.get(twoNoFriends.get(0))+10);
            }
        }

        List<String> answerList = sortScore(friendsScore, yesFriends);
        return answerList;
    }
}
