package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> directfriend = new ArrayList<>();
        Map<String, Integer> fscore = new HashMap<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                String f = friend.get(0);
                if (!f.equals(user)) {
                    directfriend.add(f);
                } else {
                    directfriend.add(friend.get(1));
                }
            }
        }

        for (List<String> friend : friends) {
            for (String f : directfriend) {
                if (friend.contains(f)) {
                    for (int j = 0; j < 2; j++) {
                        String f2 = friend.get(j);
                        if (!f2.equals(f) && !f2.equals(user)) {
                            fscore.put(f2, fscore.getOrDefault(f2, 0) + 10);
                        }
                    }
                }
            }
        }

        for (String v : visitors) {
            if (!directfriend.contains(v))
                fscore.put(v, fscore.getOrDefault(v, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(fscore.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<String> result = new ArrayList<>(fscore.keySet());

        return result;
    }
}
