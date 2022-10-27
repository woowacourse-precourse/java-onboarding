package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class Problem7 {
    private static final int VISITOR_SCORE = 1;

    private static final int ACQUAINTANCE_SCORE = 10;

    private static final int MAX_RECOMMEND_FRIEND_COUNT = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> recommendedFriendList = new HashMap<>();
        ArrayList<String> userFriendList = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {

                for (String name : friend) {
                    if (!name.equals(user)) {
                        userFriendList.add(name);
                    }
                }
            }
        }

        for (String friendName : userFriendList) {
            for (List<String> friend : friends) {
                if (friend.contains(friendName) && !friend.contains(user)) {
                    for (String name : friend) {
                        if (!name.equals(friendName)) {
                            if (recommendedFriendList.containsKey(name)) {
                                recommendedFriendList.put(name, Integer.valueOf(recommendedFriendList.get(name).intValue() + ACQUAINTANCE_SCORE));
                            }

                            recommendedFriendList.put(name, Integer.valueOf(ACQUAINTANCE_SCORE));
                        }
                    }
                }
            }
        }

        for (String visitorName : visitors) {
            if (!userFriendList.contains(visitorName)) {
                if (recommendedFriendList.containsKey(visitorName)) {
                    recommendedFriendList.put(visitorName, Integer.valueOf(recommendedFriendList.get(visitorName).intValue() + VISITOR_SCORE));
                }

                recommendedFriendList.put(visitorName, Integer.valueOf(VISITOR_SCORE));
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(recommendedFriendList.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().intValue() - o2.getValue().intValue() == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });

        List<String> answer = new ArrayList<>(MAX_RECOMMEND_FRIEND_COUNT);

        for(Map.Entry<String, Integer> entry : entryList){
            if (answer.size() == MAX_RECOMMEND_FRIEND_COUNT) {
                break;
            }

            answer.add(entry.getKey());
        }
        return answer;
    }
}
