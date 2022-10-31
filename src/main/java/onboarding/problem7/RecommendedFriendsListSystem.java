package onboarding.problem7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class RecommendedFriendsListSystem {
    private static List<Entry<String, Integer>> getSortedList(Map<String, Integer> hashMap) {
        List<Entry<String, Integer>> friendList = new ArrayList<>(hashMap.entrySet());
        Collections.sort(friendList, RecommendedFriendsListSystem::compare);
        return friendList;
    }

    private static int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
        if (Objects.equals(obj1.getValue(), obj2.getValue())) {
            return obj1.getKey().compareTo(obj2.getKey());
        }
        return obj2.getValue().compareTo(obj1.getValue());
    }

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 3);
        hashMap.put("s", 3);
        hashMap.put("t", 3);
        hashMap.put("d", 3);
        hashMap.put("e", 3);
        hashMap.put("aonut", 3);
        hashMap.put("sdwq", 13);
        hashMap.put("adwq", 13);
        hashMap.put("zz", 23);
        hashMap.put("sss", 4);
        System.out.println(getSortedList(hashMap));
    }
}
