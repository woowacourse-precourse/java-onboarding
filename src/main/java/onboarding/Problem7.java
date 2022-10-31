package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> relation = snsRelation(friends);
        List<String> userFriends = relation.get(user);
        userFriends.add(user);

        Map<String, Integer> friendScore = new HashMap<>();

        scoreFriendFriend(relation, userFriends, friendScore);
        scoreVisitFriend(friendScore, userFriends, visitors);

        answer = sortAsc(friendScore);


        return answer;
    }


    // sns관계설정
    public static Map<String, List<String>> snsRelation (List<List<String>> friends) {

        Map<String, List<String>> relation = new HashMap<>(); // K : 사람 V : K와의 관계에 있는 사람들

        for (List<String> friend : friends) {
            userFriends(relation, friend.get(0), friend.get(1)); //
            userFriends(relation, friend.get(1), friend.get(0));
        }

        return relation;
    }


    // user의 친구관계 설정
    public static void userFriends(Map<String, List<String>> relation, String person, String personFriends) {
        if (relation.containsKey(person)) {
            relation.get(person).add(personFriends);
        } else {
            List<String> friends = new ArrayList<>();
            friends.add(personFriends);
            relation.put(person, friends);
        }
    }

    public static void getScore(Map<String, Integer> friendScore, List<String> userFriends, List<String> friends, int score) {
        for (String friend : friends) {
            if (userFriends.contains(friend)) {
                continue;
            }

            if (friendScore.containsKey(friend)) {
                friendScore.replace(friend, friendScore.get(friend) + score);
            } else {
                friendScore.put(friend, score);
            }
        }
    }

    public static void scoreFriendFriend(Map<String, List<String>> relation, List<String> userFriends, Map<String, Integer> friendScore) {
        for (String friend : userFriends) {
            List<String> friendFriend = relation.get(friend);
            getScore(friendScore, userFriends, friendFriend, 10);
        }
    }

    public static void scoreVisitFriend(Map<String, Integer> friendScore, List<String> userFriends, List<String> visitors) {
        getScore(friendScore, userFriends, visitors, 1);
    }

    public static List<String> sortAsc(Map<String, Integer> friendScore) {
        List<String> listSort = new ArrayList<>(friendScore.keySet());
        listSort.sort((a, b) ->
                friendScore.get(b) - friendScore.get(a));

        if (listSort.size() > 5) {
            listSort.subList(0, 5);
        }

        return listSort;
    }
}
