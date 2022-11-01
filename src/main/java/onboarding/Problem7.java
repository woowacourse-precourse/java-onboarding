package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> visitorPeople = new ArrayList<>(visitors);

        Set<String> findAllPeople = allPeopleMember(friends, visitorPeople, user);
        final List<String> allPeople = new ArrayList<>(findAllPeople);

        HashMap<String, Integer> friendScore = new HashMap<>();

        List<String> userFriends = findFriends(friends, user);

        for (String person : allPeople) {
            friendScore.put(person, 0);
        }

        for (String userFriend : userFriends) {
            for (List<String> strings : friends) {
                if (!(strings.get(0).equals(user) || strings.get(1).equals(user))) {
                    if (strings.get(0).equals(userFriend)) {
                        String friend = strings.get(1);
                        int score = friendScore.get(friend) + 10;
                        friendScore.put(friend, score);
                    } else if (strings.get(1).equals(userFriend)) {
                        String friend = strings.get(0);
                        int score = friendScore.get(friend) + 10;
                        friendScore.put(friend, score);
                    }
                }
            }
            visitorPeople.remove(userFriend);
        }

        for (String visitor : visitorPeople) {
            int score = friendScore.get(visitor) + 1;
            friendScore.put(visitor, score);
        }

        friendScore.values().removeIf(num -> num == 0);

        List<String> listKeySet = new ArrayList<>(friendScore.keySet());
        listKeySet.sort((o1, o2) -> {
            if (friendScore.get(o1) > friendScore.get(o2)) return -1;
            else if (Objects.equals(friendScore.get(o1), friendScore.get(o2))) {
                if (o1.charAt(0) > o2.charAt(0)) {
                    return 1;
                } else return 0;
            } else return 1;
        });

        List<String> answer = new ArrayList<>(5);

        if(listKeySet.size() < 5) {
            answer.addAll(listKeySet);
        } else {
            for(int index = 0; index < 5; index++) {
                answer.add(listKeySet.get(index));
            }
        }
        return answer;
    }
    private static Set<String> allPeopleMember(List<List<String>> friends, List<String> visitor , String user) {
        Set<String> allFriends = new HashSet<>();

        for (List<String> friend : friends) {
            if (!(friend.get(0).equals(user) || friend.get(1).equals(user))) {
                allFriends.add(friend.get(0));
                allFriends.add(friend.get(1));
            }
        }
        allFriends.addAll(visitor);
        return allFriends;
    }

    private static List<String> findFriends(List<List<String>> friends, String name) {

        List<String> searchFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.get(0).equals(name)) {
                searchFriends.add(friend.get(1));
            } else if (friend.get(1).equals(name)) {
                searchFriends.add(friend.get(0));
            }
        }
        return searchFriends;
    }
}