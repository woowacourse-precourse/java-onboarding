package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> mrkoFriends = new ArrayList<>();
        Map<String, Integer> temporaryStorage = new HashMap<>();

        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                mrkoFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                mrkoFriends.add(friend.get(0));
            }
        }

        for (List<String> friend : friends) {
            for (int j = 0; j < friend.size(); j++) {
                if (!friend.get(0).equals(user) && !friend.get(1).equals(user)) {
                    if (friend.get(0).equals(mrkoFriends.get(j))) {
                        temporaryStorage.put(friend.get(1), temporaryStorage.getOrDefault(friend.get(1), 0) + 10);
                    } else if (friend.get(1).equals(mrkoFriends.get(j))) {
                        temporaryStorage.put(friend.get(0), temporaryStorage.getOrDefault(friend.get(0), 0) + 10);
                    }
                }
            }
        }

        List<String> newVisitors = new ArrayList<>();

        for (String visitor : visitors) {
            int count = 0;
            for (String mrkoFriend : mrkoFriends) {
                if (!visitor.equals(mrkoFriend)) {
                    count++;
                }
            }
            if (mrkoFriends.size() == count) {
                newVisitors.add(visitor);
            }
        }

        for (String s : newVisitors) {
            temporaryStorage.put(s, temporaryStorage.getOrDefault(s, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(temporaryStorage.keySet());
        keySet.sort((o1, o2) -> temporaryStorage.get(o2).compareTo(temporaryStorage.get(o1)));
        return new ArrayList<>(keySet);
    }

}
