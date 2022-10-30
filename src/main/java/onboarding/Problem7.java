package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, Integer> aa = new HashMap<>();
        List<String> alreadyFriend = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                alreadyFriend.add(friends.get(i).get(1));
            }
            if (friends.get(i).get(1).equals(user)) {
                alreadyFriend.add(friends.get(i).get(0));
            }
        }

        for (int i = 0; i < friends.size(); i++) {
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);

            for (String value : alreadyFriend) {
                if (friend1.equals(value)) {
                    if (aa.containsKey(friend2)) {
                        aa.put(friend2, aa.get(friend2) + 10);
                    } else {
                        aa.put(friend2, 10);
                    }
                }
                if (friend2.equals(value)) {
                    if (aa.containsKey(friend1)) {
                        aa.put(friend1, aa.get(friend1) + 10);
                    } else {
                        aa.put(friend1, 10);
                    }
                }
            }
        }
        aa.remove(user);

        for (String value : visitors) {
            if (aa.containsKey(value)) {
                aa.put(value, aa.get(value) + 1);
            } else {
                aa.put(value, 1);
            }
        }

        aa.keySet().removeAll(alreadyFriend);

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(aa.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            answer.add(entry.getKey());
        }

        List<String> result = new ArrayList<>();
        if (answer.size() >= 5) {
            result = answer.subList(0, 5);
        } else {
            result = answer;
        }
        return result;
    }
}