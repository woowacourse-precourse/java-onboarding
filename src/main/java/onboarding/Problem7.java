package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        int size = 5;

        List<String> allUsers = getAllUsers(friends, visitors);
        List<String> myFriends = getMyFriends(user, friends);

        User me = new User(user, myFriends);

        HashMap<String, Integer> scoresMap = initFriendScores(me, allUsers);

        scoresMap = toKnowTogether(me, friends, scoresMap);
        scoresMap = toVisit(visitors, scoresMap);
        scoresMap = toRemoveZero(scoresMap);

        scoresMap = sortMap(scoresMap);
        answer = new ArrayList<>(scoresMap.keySet());

        if (answer.size() > size) {
            answer = answer.subList(0, size);
        }

        return answer;
    }

    private static HashMap<String, Integer> sortMap(HashMap<String, Integer> scoresMap) {

        List<Map.Entry<String, Integer>> entries = new LinkedList<>(scoresMap.entrySet());
        Collections.sort(entries, (o1, o2) -> {
            int state = (o1.getValue() - o2.getValue()) * -1;
            int resultState = (state == 0) ? o1.getKey().compareTo(o2.getKey()) : state;
            return resultState;
        });

        HashMap<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    private static HashMap<String, Integer> toRemoveZero(HashMap<String, Integer> scoresMap) {
        List<String> keys = new LinkedList<>(scoresMap.keySet());

        for (String key : keys) {
            scoresMap = removeMap(key, scoresMap);
        }

        return scoresMap;
    }

    public static HashMap<String, Integer> toKnowTogether(User user, List<List<String>> friends, HashMap<String, Integer> scoresMap) {

        int friendSize = friends.size();

        for (int i = 0; i < friendSize; i++) {
            List<String> relation = friends.get(i);
            scoresMap = updateFriends(scoresMap, user, relation);
        }

        return scoresMap;
    }

    private static HashMap<String, Integer> putMap(HashMap<String, Integer> scoresMap, String name) {
        if (scoresMap.containsKey(name)) {
            int score = scoresMap.get(name) + 1;
            scoresMap.put(name, score);
        }
        return scoresMap;
    }

    private static HashMap<String, Integer> removeMap(String key, HashMap<String, Integer> scoresMap) {
        int score = scoresMap.get(key);

        if (score == 0) {
            scoresMap.remove(key);
        }

        return scoresMap;
    }
    private static HashMap<String, Integer> updateFriends(HashMap<String, Integer> scoresMap, User user, List<String> relation) {

        String name = user.getName();
        List<String> myFriends = user.getFriendsList();

        String friendA = relation.get(0);
        String friendB = relation.get(1);

        if (friendA.equals(name) || friendB.equals(name)) {
            return scoresMap;
        }

        if (myFriends.contains(friendA)) {
            int score = scoresMap.get(friendB) + 10;
            scoresMap.put(friendB, score);
            return scoresMap;
        }

        if (myFriends.contains(friendB)) {
            int score = scoresMap.get(friendA) + 10;
            scoresMap.put(friendA, score);
        }

        return scoresMap;
    }

    private static HashMap<String, Integer> toVisit(List<String> visitors, HashMap<String, Integer> scoresMap) {

        int visitorSize = visitors.size();

        for (int i = 0; i < visitorSize; i++) {
            String name = visitors.get(i);
            scoresMap = putMap(scoresMap, name);
        }

        return scoresMap;
    }

    public static HashMap<String, Integer> initFriendScores(User user, List<String> allUsers) {

        String name = user.getName();
        List<String> userFriends = user.getFriendsList();

        HashMap<String, Integer> scoresMap = new HashMap<>();

        allUsers.remove(name);
        int userSize = allUsers.size();
        int userFriendSize = userFriends.size();

        for (int i = 0; i < userSize; i++) {
            name = allUsers.get(i);
            scoresMap.put(name, 0);
        }

        for (int i = 0; i < userFriendSize; i++) {
            name = userFriends.get(i);
            scoresMap.remove(name);
        }

        return scoresMap;
    }


    private static List<String> getMyFriends(String user, List<List<String>> friends) {

        List<String> myFriends = new LinkedList<>();

        int friendSize = friends.size();

        for (int i = 0; i < friendSize; i++) {
            List<String> relation = friends.get(i);
            myFriends = addFriend(myFriends, relation, user);
        }
        return myFriends;
    }

    private static List<String> addFriend(List<String> myFriends, List<String> relation, String user) {
        String friendA = relation.get(0);
        String friendB = relation.get(1);

        if (friendA.equals(user)) {
            myFriends.add(friendB);
        }
        if (friendB.equals(user)) {
            myFriends.add(friendA);
        }
        return myFriends;
    }

    private static List<String> getAllUsers(List<List<String>> friends, List<String> visitors) {

        List<String> allUsers = new LinkedList<>();

        int friendSize = friends.size();
        int visitorSize = visitors.size();

        for (int i = 0; i < friendSize; i++) {
            List<String> relation = friends.get(i);

            String friendA = relation.get(0);
            String friendB = relation.get(1);

            allUsers = addUser(allUsers, friendB);
            allUsers = addUser(allUsers, friendA);
        }

        for (int i = 0; i < visitorSize; i++) {
            String visitor = visitors.get(i);
            allUsers = addUser(allUsers, visitor);
        }
        return allUsers;
    }

    private static List<String> addUser(List<String> allUsers, String friend) {
        if (!allUsers.contains(friend)) {
            allUsers.add(friend);
        }
        return allUsers;
    }

    public static class User {
        String name;
        List<String> friendsList;

        public User(String name, List<String> friendsList) {
            this.name = name;
            this.friendsList = friendsList;
        }

        public String getName() {
            return name;
        }

        public List<String> getFriendsList() {
            return friendsList;
        }
    }
}
