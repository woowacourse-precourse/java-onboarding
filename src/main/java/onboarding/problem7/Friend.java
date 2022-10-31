package onboarding.problem7;

import java.util.*;
public class Friend {
    private static final HashMap<String, Integer> weight = new HashMap<>();

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

    public static List<String> getRecommendedList(String user, List<String> myFriends) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(weight.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        entryList = Util.sameEntryValueSort(entryList);
        Collections.reverse(entryList);
        List<String> resultList = new ArrayList<>();
        entryList.removeIf(entry -> myFriends.contains(entry.getKey()));
        entryList.removeIf(entry -> entry.getKey() == user);
        entryList.stream()
                .limit(Constant.MAX_RECOMMEND)
                .filter(entry -> !entry.getKey().equals(user))
                .filter(entry -> entry.getValue() != 0)
                .forEach(entry -> resultList.add(entry.getKey()));
        return resultList;
    }
}
