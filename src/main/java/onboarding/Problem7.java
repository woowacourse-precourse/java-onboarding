package onboarding;

import java.util.*;

/**
 * Problem 7
 * @author Davin An
 * @version 1.0
 */
public class Problem7 {
    /**
     * Goes through friend list and visitor list to calculate scores
     * @param user User to recommend friends for
     * @param friends List of pairs who are currently friends
     * @param visitors List of ppl who have visited the user
     * @return List of recommended friends for the user
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> users = new HashMap<>();
        List<String> friendList = findFriends(user, friends);
        String l0, l1;
        // Iterates through friend list
        for (List<String> l : friends) {
            l0 = l.get(0);
            l1 = l.get(1);
            if (!l.contains(user) && friendList.contains(l0)) {
                if (users.containsKey(l1)) {
                    users.put(l1, users.get(l1) + 10);
                } else {
                    users.put(l1, 10);
                }
            } else if (!l.contains(user) && friendList.contains(l1)) {
                if (users.containsKey(l0)) {
                    users.put(l0, users.get(l0) + 10);
                } else {
                    users.put(l0, 10);
                }
            }
        }
        // Iterates through visitor list
        for (String s : visitors) {
            if (!friendList.contains(s)) {
                if (users.containsKey(s)) {
                    users.put(s, users.get(s) + 1);
                } else {
                    users.put(s, 1);
                }
            }
        }
        return recommendation(users);
    }

    /**
     * Finds out who are currently friends with the user
     * @param user Subject user to find friends for
     * @param friends List of pairs who are currently friends
     * @return List of friends of current user
     */
    public static List<String> findFriends(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (List<String> l : friends) {
            if (l.contains(user)) {
                friendList.add(l.get(0).equals(user) ? l.get(1) : l.get(0));
            }
        }
        return friendList;
    }

    /**
     * Sorts Hashmap by value and returns the top 5 users with the highest scores
     * Note, there is no user with score 0 in the Hashmap
     * @param users List of users to recommend from
     * @return List of friend recommendations
     */
    public static List<String> recommendation(Map<String, Integer> users) {
        List<String> recommendation = new ArrayList<>();
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(users.entrySet());
        sortedList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        for (int i = 0; (i < 5) && (i < sortedList.size()); i++) {
            recommendation.add(sortedList.get(i).getKey());
        }
        return recommendation;
    }

    public static void main(String[] args) {}
}
