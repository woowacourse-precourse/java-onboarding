package onboarding;

import java.util.*;

public class Problem7 {
    private static HashMap<Integer, Integer> weight = new HashMap<>();
    private static HashMap<String, Integer> uniqueIDs = new HashMap<>();
    private static int forID = 0;
    private static int FRIEND_WEIGHT = 10;
    private static int VISITOR_WEIGHT = 1;
    private static int MAX_RECOMMEND = 5;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = getSolution(user, friends, visitors);
        return answer;
    }
    public static List<String> getSolution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> distinctFriends = getDistinctFriends(friends);
        List<String> distinctVisitors = getDistinctVisitors(visitors);
        setDistinctID(distinctFriends, distinctVisitors);
        List<String> myFriends = getFriendsList(friends, user);

        initializeWeight();
        for (int i = 0; i < myFriends.size(); i++) {
            List<String> acquaintance = getFriendsList(friends, myFriends.get(i));
            addWeight(acquaintance, FRIEND_WEIGHT);
        }
        addWeight(visitors, VISITOR_WEIGHT);
        List<String> recommendedList = recommendedList(user);
        List<String> friendList = getFriendsList(friends, user);
        for (int i = 0; i < recommendedList.size(); i++) {
            String person = recommendedList.get(i);
            if (friendList.contains(person)) {
                recommendedList.remove(person);
            }
        }
        return recommendedList;
    }
    public static List<String> recommendedList(String user) {
        int myID = uniqueIDs.get(user); // 결과에서 본인은 제외
        List<Integer> IDList = new ArrayList<>(weight.values());
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(weight.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        List<String> resultList = new ArrayList<>();
        int count = 0;
        for (int i = entryList.size() - 1; i >= 0; i--) {
            if (entryList.get(i).getKey() == myID) {
                count++;
                continue;
            }
            if (count >= MAX_RECOMMEND) {
                break;
            }
            if (entryList.get(i).getValue() != 0) {
                String name = getKeyFromValue(entryList.get(i).getKey());
                resultList.add(name);
            }
            count++;
        }
        return resultList;
    }
    public static String getKeyFromValue(int value) {
        String result = "";
        for (String key :  uniqueIDs.keySet()) {
            if (value == uniqueIDs.get(key)) {
                result = key;
            }
        }
        return result;
    }
    public static void initializeWeight() {
        for (int i = 0; i < uniqueIDs.size(); i++) {
            weight.put(i, 0);
        }
    }
    public static void addWeight(List<String> list, int WEIGHT) {
        for (int i = 0; i < list.size(); i++) {
            String user = list.get(i);
            int userID = uniqueIDs.get(user);
            int updatedValue = weight.get(userID) + WEIGHT;
            weight.put(userID, updatedValue);
        }
    }

    public static List<String> getFriendsList(List<List<String>> friends, String user) {
        List<String> friendsList = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            List<String> relation = friends.get(i);
            String friend1 = relation.get(0);
            String friend2 = relation.get(1);

            if (friend1.equals(user)) {
                friendsList.add(friend2);
            } else if (friend2.equals(user)) {
                friendsList.add(friend1);
            }
        }
        return friendsList;
    }
    public static void setDistinctID(List<String> friends, List<String> visitors) { // getDistinctFriends 이후 호출됨
        for (int i = 0; i < friends.size(); i++) {
            String name = friends.get(i);
            uniqueIDs.put(name, forID++);
        }
        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            if (!uniqueIDs.containsKey(name)) {
                uniqueIDs.put(name, forID++);
            }
        }
    }
    public static List<String> getDistinctFriends(List<List<String>> friends) {
        List<String> forJoin = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            List<String> relation = friends.get(i);
            forJoin.addAll(relation);
        }
        Set<String> distinctSet = new HashSet<>(forJoin);
        List<String> distinctList = new ArrayList<>(distinctSet);
        return distinctList;
    }

    public static List<String> getDistinctVisitors(List<String> visitors) {
        Set<String> distinctSet = new HashSet<>(visitors);
        List<String> distinctList = new ArrayList<>(distinctSet);
        return distinctList;
    }

}
