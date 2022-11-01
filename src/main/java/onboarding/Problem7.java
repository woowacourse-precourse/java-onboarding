package onboarding;

import java.util.*;

public class Problem7 {

    private static final int TOGETHER_HAVE_FRIEND = 10;

    private static List<String> GetFriendShipFromName(List<List<String>> friendRelations, String user) {
        List<String> friendList = new LinkedList<>();
        friendList.add(user);
        for (List<String> friendRelation : friendRelations) {
            if (friendRelation.contains(user)) {
                friendRelationAddUser(friendList, friendRelation, user);
            }
        }
        return friendList;
    }

    private static void friendRelationAddUser(List<String> friendList, List<String> friendRelation, String user) {
        for (String friendName : friendRelation) {
            if (!friendName.equals(user))
                friendList.add(friendName);
        }
    }

    private static void friend(Map<String, Integer> friendshipScore,
                              List<String> userFriend,
                              List<List<String>> friends) {
        for (String name : userFriend) {
            List<String> nameFriendList = GetFriendShipFromName(friends, name);
            friendListCheck(friendshipScore, nameFriendList, TOGETHER_HAVE_FRIEND);
        }
    }

    private static void friendScoreCalculate(Map<String, Integer> friendshipScore, String name, int score) {
        if (friendshipScore.containsKey(name)) {
            friendshipScore.replace(name, friendshipScore.get(name) + score);
        } else {
            friendshipScore.put(name, score);
        }
    }

    private static void friendListCheck(Map<String, Integer> friendshipScore, List<String> list, int score) {
        for (String name : list) {
            friendScoreCalculate(friendshipScore, name, score);
        }
    }

    private static void visitCheck(Map<String, Integer> friendshipScore, List<String> visitors) {
        friendListCheck(friendshipScore, visitors, 1);
    }

    private static void alreadyCheck(Map<String, Integer> friendshipScore,
                                          List<String> userFriend) {
        for (String name : userFriend) {
            friendshipScore.remove(name);
        }
    }

    private static List<String> resultSort(Map<String, Integer> friendshipScore) {
        List<String> answer = new LinkedList<>();
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(friendshipScore.entrySet());
        entries.sort((tmp1, tmp2) -> {
            if (tmp2.getValue().equals(tmp1.getValue())) {
                return tmp1.getKey().compareTo(tmp2.getKey());
            }
            return tmp2.getValue().compareTo(tmp1.getValue());
        });

        for (int i = 0; i < 5 && i < entries.size(); i++) {
            Map.Entry<String, Integer> entry = entries.get(i);
            answer.add(entry.getKey());
        }
        return answer;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Integer> friendshipScore = new HashMap<>();

        List<String> userFriendList = GetFriendShipFromName(friends, user);
        friend(friendshipScore, userFriendList, friends);
        visitCheck(friendshipScore, visitors);
        alreadyCheck(friendshipScore, userFriendList);

        answer =  resultSort(friendshipScore);
        return answer;
    }
}
