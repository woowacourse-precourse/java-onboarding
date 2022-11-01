package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> uniqueFriends = new HashSet<>();
        List<String> listOfUniqueFriends;
        ArrayList<String>[] friendsOfUsers;
        ArrayList<String> friendsOfThisUser;
        Map<String, Integer> scoresWithNames = new HashMap<>();
        int userIdx, numOfUsers;
        Score scores;

        for (List<String> friendship : friends) {
            uniqueFriends.addAll(friendship);
        }
        uniqueFriends.addAll(visitors);
        numOfUsers = uniqueFriends.size();

        listOfUniqueFriends = new ArrayList<>(uniqueFriends);

        friendsOfUsers = createListOfFriendships(friends, listOfUniqueFriends, numOfUsers);

        userIdx = listOfUniqueFriends.indexOf(user);
        friendsOfThisUser = friendsOfUsers[userIdx];
        friendsOfUsers[userIdx] = new ArrayList<>();

        scores = new Score(numOfUsers);
        scores.setAllToZero();

        for (int j = 0; j < numOfUsers; j++) {
            for (String friend : friendsOfUsers[j]) {
                if (friendsOfThisUser.contains(friend)) {
                    scores.increaseBy(j,10);
                }
            }
        }

        for (String visitor : visitors) {
            scores.increaseBy(listOfUniqueFriends.indexOf(visitor), 1);
        }

        for (String friendOfThisUser : friendsOfThisUser) {
            scores.setToZero(listOfUniqueFriends.indexOf(friendOfThisUser));
        }

        for (int k = 0; k < numOfUsers; k++) {
            scoresWithNames.put(listOfUniqueFriends.get(k), scores.getValue(k));
        }

        return topFive(sortByValueThenKey(scoresWithNames));

    }

    static class Score {
        int[] scores;
        public Score(int size) {
            scores = new int[size];
        }
        public void setAllToZero() {
            Arrays.fill(scores, 0);
        }
        public void setToZero(int idx) {
            scores[idx] = 0;
        }
        public void setValue(int idx, int v) {
            scores[idx] = v;
        }
        public void increaseBy(int idx, int v) {
            scores[idx] += v;
        }
        public int getValue(int idx) {
            return scores[idx];
        }
    }

    static <K extends Comparable<? super K>, V extends Comparable<? super V>> Map<K, V> sortByValueThenKey(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> user1, Map.Entry<K, V> user2) {
                if (user1.getValue().equals(user2.getValue()))
                    return user1.getKey().compareTo(user2.getKey());
                else
                    return user2.getValue().compareTo(user1.getValue());
            }
        });

        Map<K, V> sorted = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            sorted.put(entry.getKey(), entry.getValue());
        }
        return sorted;
    }

    static ArrayList<String> topFive(Map<String, Integer> hm) {
        int count = 0;
        ArrayList<String> recommended = new ArrayList<>();
        for (Map.Entry<String, Integer> user : hm.entrySet()) {
            if (user.getValue() > 0 && count < 6) {
                recommended.add(user.getKey());
                count++;
            }
        }
        return recommended;
    }

    static ArrayList<String>[] createListOfFriendships(List<List<String>> friends, List<String> listOfUniqueFriends, int numOfUsers) {
        int f1, f2;
        ArrayList<String>[] friendsOfUsers = new ArrayList[numOfUsers];
        for (int i = 0; i < numOfUsers; i ++) {
            friendsOfUsers[i] = new ArrayList<>();
        }
        for (List<String> friendship : friends) {
            f1 = listOfUniqueFriends.indexOf(friendship.get(0));
            f2 = listOfUniqueFriends.indexOf(friendship.get(1));
            friendsOfUsers[f1].add(friendship.get(1));
            friendsOfUsers[f2].add(friendship.get(0));
        }
        return friendsOfUsers;
    }
}
