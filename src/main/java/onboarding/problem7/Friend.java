package onboarding.problem7;

import java.util.*;

public class Friend {
    private static HashMap<Integer, Integer> weight = new HashMap<>();
    private static HashMap<String, Integer> uniqueIDs = new HashMap<>();
    private static int forID = 0;
    
    public static void initID(List<String> people) {
        for (int i = 0; i < people.size(); i++) {
            String name = people.get(i);
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
