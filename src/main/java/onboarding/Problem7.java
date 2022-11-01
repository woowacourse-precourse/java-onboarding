package onboarding;

import java.util.*;

public class Problem7 {
    private static HashMap<String, Integer> friendsBook = new HashMap<String, Integer>();
    private static List<String> friendsList = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        findFriends(user, friends);
        checkFriends(user, friends);
        checkVisitors(visitors);
        return sortFriendsBook(user);
    }

    private static List<String> sortFriendsBook(String user) {
        List<String> sortedAnswer = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(friendsBook.entrySet());
        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> entry : entryList) {
            if(!friendsList.contains(entry.getKey()) && entry.getKey() != user) {
                sortedAnswer.add(entry.getKey());
            }
        }
        return sortedAnswer;
    }
    private static void findFriends(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friend.get(0).contains(user)) {
                friendsList.add(friend.get(1));
            }
            else if (friend.get(1).contains(user)) {
                friendsList.add(friend.get(0));
            }
        }
        return ;
    }
    private static void checkFriends(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friendsList.contains(friend.get(0))) {
                if (friendsBook.containsKey(friend.get(1))) {
                    friendsBook.put(friend.get(1), friendsBook.get(friend.get(1)) + 10);
                }
                else {
                    friendsBook.put(friend.get(1), 10);
                }
            }
            else if (friend.get(1).contains(user)) {
                if (friendsBook.containsKey(friend.get(0))) {
                    friendsBook.put(friend.get(0), friendsBook.get(friend.get(1)) + 10);
                }
                else {
                    friendsBook.put(friend.get(0), 10);
                }
            }
        }
    }
    private static void checkVisitors(List<String> visitors) {
        for (String visitor : visitors ) {
            if (friendsBook.containsKey(visitor)) {
                friendsBook.put(visitor, friendsBook.get(visitor) + 1);
            }
            else {
                friendsBook.put(visitor, 1);
            }
        }
    }
}
