package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        int maxRcm = 5;
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> friendsList = new HashMap<String, List<String>>();
        HashMap<String, Integer> friendScore = new HashMap<String, Integer>();

        friendsList = relateFriend(friends);
        friendScore = getFriendScore(friendsList, user);
        friendScore = getVisitScore(friendScore, visitors);
        friendScore = removeMyFriend(friendScore, friendsList);

        List<String> keySet = new ArrayList<>(friendScore.keySet());
        Map<String, Integer> finalScore = friendScore;
        keySet.sort((o1, o2) -> finalScore.get(o2).compareTo(finalScore.get(o1)));
        for (String s : finalScore.keySet()) {

        }

        if (keySet.size() < maxRcm) {
            maxRcm = keySet.size();
        }
        answer = keySet.subList(0, maxRcm);


        return answer;
    }

    static HashMap<String, List<String>> relateFriend(List<List<String>> friends) {

        HashMap<String, List<String>> friendsList = new HashMap<String, List<String>>();

        for (List<String> friend : friends) {
            String name1 = friend.get(0);
            String name2 = friend.get(1);

            if (friendsList.containsKey(name1)) {
                friendsList.get(name1).add(name2);
                continue;
            }
            friendsList.put(name1, new ArrayList<>(List.of(name2)));
        }

        return friendsList;
    }

    static HashMap<String, Integer> getFriendScore(HashMap<String, List<String>> friendsList, String user) {

        HashMap<String, Integer> friendScore = new HashMap<String, Integer>();

        for (String key : friendsList.keySet()) {
            if (friendsList.get(key).contains(user)) {
                for (String friend : friendsList.get(key)) {
                    if (friendScore.containsKey(friend)) {
                        friendScore.put(friend, friendScore.get(friend) + 10);
                        continue;
                    }
                    friendScore.put(friend, 10);
                }
            }
        }
        friendScore.remove(user);

        return friendScore;
    }

    static HashMap<String, Integer> getVisitScore(HashMap<String, Integer> friendScore, List<String> visitors) {
        for (String visitor : visitors) {
            if (friendScore.containsKey(visitor)) {
                friendScore.put(visitor, friendScore.get(visitor) + 1);
                continue;
            }
            friendScore.put(visitor, 1);
        }

        return friendScore;
    }

    static HashMap<String, Integer> removeMyFriend(HashMap<String, Integer> friendScore,
                                                      HashMap<String, List<String>> friendsList) {
        for (String friend : friendsList.keySet()) {
            friendScore.remove(friend);
        }
        return friendScore;
    }


}
