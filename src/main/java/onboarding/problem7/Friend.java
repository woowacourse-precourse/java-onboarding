package onboarding.problem7;

import java.util.*;

public class Friend {
    private static HashMap<String, Integer> weight = new HashMap<>();

    public static void initID(List<String> people) {
        for (int i = 0; i < people.size(); i++) {
            String name = people.get(i);
            if (!weight.containsKey(name)) {
                weight.put(name, 0);
            }
        }
    }

    public static void addWeight(List<String> list, int WEIGHT) {
        for (int i = 0; i < list.size(); i++) {
            String user = list.get(i);
            int beforeWeight = weight.get(user);
            int updatedValue = beforeWeight + WEIGHT;
            weight.put(user, updatedValue);
        }
    }

    public static List<String> recommendedList(String user) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(weight.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        entryList = Util.sameScoreSort(entryList);
        List<String> resultList = new ArrayList<>();
        int count = 0;
        for (int i = entryList.size() - 1; i >= 0; i--) {
            if (entryList.get(i).getKey() == user) {
                count++;
                continue;
            }
            if (count >= Constant.MAX_RECOMMEND) {
                break;
            }
            if (entryList.get(i).getValue() != 0) {
                String name = entryList.get(i).getKey();
                resultList.add(name);
            }
            count++;
        }
        return resultList;
    }
}
