package onboarding;

import java.util.*;

public class Problem7 {

    private static Map<String, List<String>> relations = new HashMap<>();
    private static Map<String, Integer> score = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (!isValidUserNameRange(user) || !isValidUserNameFormat(user) || !isValidFriendsRange(friends) || !isValidVisitorsRange(visitors)) {
            return Collections.emptyList();
        }
        getFriends(friends);
        List<String> friendScore = getFriendsScore(user, friends);
        getVisitedScore(visitors);
        Map<String, Integer> totalScore = getTotalScore(score);
        List<String> answer = getResult(totalScore, friendScore);
        return answer;
    }

    private static boolean isValidUserNameRange(String username) {
        return username.length() >= 1 && username.length() <= 30;
    }

    private static boolean isValidUserNameFormat(String username) {
        char[] alphabets = username.toCharArray();
        for (char alphabet : alphabets) {
            if (!(alphabet >= 'a' && alphabet <= 'z')) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidFriendsRange(List<List<String>> friends) {
        return friends.size() >= 1 && friends.size() <= 10000;
    }

    private static boolean isValidVisitorsRange(List<String> visitors) {
        return visitors.size() >= 0 && visitors.size() <= 10000;
    }

    private static void getFriends(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String preFriend = friend.get(0);
            String nextFriend = friend.get(1);

            if (!relations.containsKey(preFriend)) {
                setNewList(preFriend);
            }
            if (!relations.containsKey(nextFriend)) {
                setNewList(nextFriend);
            }
            setRelations(preFriend, nextFriend);
        }
    }

    private static void setNewList(String friend) {
        List<String> friendList = new ArrayList<>();
        score.put(friend, 0);
        relations.put(friend, friendList);
    }

    private static void setRelations(String preFriend, String nextFriend) {
        List<String> preFriendList = relations.get(preFriend);
        preFriendList.add(nextFriend);

        List<String> nextFriendList = relations.get(nextFriend);
        nextFriendList.add(preFriend);
    };

    private static List<String> getFriendsScore(String user, List<List<String>> friends) {
        List<String> friendList = relations.get(user);
        for (String list : friendList) {
            List<String> knownFriends = relations.get(list);
            for (String friend : knownFriends) {
                if (friends.contains(friend)) continue;
                if (friend.equals(user)) continue;
                Integer friendScore = score.get(friend);
                score.put(friend, friendScore + 10);
            }
        }
        return friendList;
    }

    private static void getVisitedScore(List<String> visitors) {
        for (String visitor : visitors) {
            if (!score.containsKey(visitor)) {
                score.put(visitor, 1);
                continue;
            }
            Integer visitedScore = score.get(visitor);
            score.put(visitor, visitedScore + 1);
        }
    }

    private static Map<String, Integer> getTotalScore(Map<String, Integer> score) {
        Object[] mapKey = score.keySet().toArray();
        Arrays.sort(mapKey);
        return score;
    }

    private static List<String> getResult(Map<String, Integer> totalScore, List<String> withFriends) {
        List<String> result = new ArrayList<>();
        int count = 0;

        for(Map.Entry<String, Integer> entry: totalScore.entrySet()){
            if (count == 5) break;
            if (entry.getValue() == 0) continue;
            if (withFriends.contains(entry.getKey())) continue;
            result.add(entry.getKey());
            count++;
        }
        return result;
    }

}
