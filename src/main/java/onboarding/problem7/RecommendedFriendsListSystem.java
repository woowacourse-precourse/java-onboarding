package onboarding.problem7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class RecommendedFriendsListSystem {
    private static final int MAX_FRIEND_LIST_SIZE = 5;

    public static List<String> getRecommendedFriendsList(Map<String, Integer> hashMap){
        List<Entry<String, Integer>> sortedList = getSortedList(hashMap);
        List<String> result = new ArrayList<>();
        int last = Math.min(sortedList.size(), MAX_FRIEND_LIST_SIZE);
        for (int i = 0; i < last; i++) {
            result.add(sortedList.get(i).getKey());
        }
        return result;
    }

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
}
