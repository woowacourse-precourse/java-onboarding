package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {

    static ArrayList<String> userFriend = new ArrayList<>();
    static HashMap<String, Integer> recommendList = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        getFriends(user, friends);
        countVisited(visitors, user);
        countFriendOfFriend(friends, user);
        answer = recommendInOrder(user);

        return answer;
    }

    public static void getFriends(String user, List<List<String>> friends) {
        int index;
        List<String> friendsList;

        for (index = 0; index < friends.size(); index++) {

            friendsList = friends.get(index);

            if (friendsList.get(0).equals(user)) {
                userFriend.add(friendsList.get(1));
            }

            if (friendsList.get(1).equals(user)) {
                userFriend.add(friendsList.get(0));
            }
        }
    }

    public static void countVisited(List<String> visitors, String user) {
        int index;
        int score;

        for(index = 0; index < visitors.size(); index++) {
            if (userFriend.contains(visitors.get(index)) || userFriend.contains(user)){
                continue;
            }

            if (recommendList.containsKey(visitors.get(index))) {
                score = recommendList.get(visitors.get(index));
                score += 1;
                recommendList.put(visitors.get(index), score);
                continue;
            }

            recommendList.put(visitors.get(index), 1);
        }
    }

    public static void countFriendOfFriend(List<List<String>> friends, String user) {
        int score;

        for (List<String> friendsArray: friends) {
            if (userFriend.contains(friendsArray.get(0))) {
                if (user.equals(friendsArray.get(1))) {
                    continue;
                }

                if (recommendList.containsKey(friendsArray.get(1))) {
                    score = recommendList.get(friendsArray.get(1));
                    score += 10;
                    recommendList.put(friendsArray.get(1), score);
                    continue;
                }

                recommendList.put(friendsArray.get(1), 10);
                continue;
            }

            if (userFriend.contains(friendsArray.get(1))) {
                if (user.equals(friendsArray.get(0))) {
                    continue;
                }

                if (recommendList.containsKey(friendsArray.get(0))) {
                    score = recommendList.get(friendsArray.get(0));
                    score += 10;
                    recommendList.put(friendsArray.get(0), score);
                    continue;
                }

                recommendList.put(friendsArray.get(0), 10);
            }
        }

    }

    public static ArrayList<String> recommendInOrder(String user) {
        List<Entry<String, Integer>> listEntry = new ArrayList<>(recommendList.entrySet());
        ArrayList<String> orderList = new ArrayList<>();

        Collections.sort(listEntry, new Comparator<Entry<String, Integer>>() {

            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {

                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        for (Entry<String, Integer> entry: listEntry) {
            if (orderList.size() == 5) {
                return orderList;
            }
            if(userFriend.contains(entry.getKey())) {
                continue;
            }
            orderList.add(entry.getKey());
        }

        return orderList;
    }
}
