package onboarding.problem7;

import java.util.*;

public class Friend {
    private static HashMap<Integer, Integer> weight = new HashMap<>();
    private static HashMap<String, Integer> uniqueIDs = new HashMap<>();
    private static int forID = 0;

    public static List<String> getDistinctFriends(Relations relations) {
        List<String> forJoin = new ArrayList<>();
        for (int i = 0; i < relations.size(); i++) {
            List<String> relation = relations.getRelation(i);
            forJoin.addAll(relation);
        }
        Set<String> distinctSet = new HashSet<>(forJoin);
        List<String> distinctList = new ArrayList<>(distinctSet);
        return distinctList;
    }
    public static List<String> getFriendsList(Relations relations, String user) {
        List<String> friendsList = new ArrayList<>();
        for (int i = 0; i < relations.size(); i++) {
            List<String> relation = relations.getRelation(i);
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

    public static void initID(List<String> friends, List<String> visitors) {
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
    public static void initWeight() {
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
            if (count >= Constant.MAX_RECOMMEND) {
                break;
            }
            if (entryList.get(i).getValue() != 0) {
                String name = Util.getKeyFromValue(uniqueIDs, entryList.get(i).getKey());
                resultList.add(name);
            }
            count++;
        }
        return resultList;
    }
}
