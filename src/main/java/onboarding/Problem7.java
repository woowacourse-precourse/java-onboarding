package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); ++i) {
            if (friends.get(i).get(0).equals(user)) {
                userFriends.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                userFriends.add(friends.get(i).get(0));
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.size(); ++i) {
            for (int j = 0; j < 2; ++j) {
                if (!friends.get(i).get(j).equals(user) && !map.containsKey(friends.get(i).get(j))) {
                    map.put(friends.get(i).get(j), 0);
                }
            }
        }
        for (int i = 0; i < visitors.size(); ++i) {
            if (!visitors.get(i).equals(user) && !map.containsKey(visitors.get(i))) {
                map.put(visitors.get(i), 0);
            }
        }
        for (int i = 0; i < friends.size(); ++i) {
            if (!friends.get(i).get(0).equals(user) && !friends.get(i).get(1).equals(user)
                    && userFriends.contains(friends.get(i).get(0))) {
                map.put(friends.get(i).get(1), map.get(friends.get(i).get(1)) + 10);
            } else if (!friends.get(i).get(1).equals(user) && !friends.get(i).get(1).equals(user)
                    && userFriends.contains(friends.get(i).get(1))) {
                map.put(friends.get(i).get(0), map.get(friends.get(i).get(0)) + 10);
            }
        }
        for (int i = 0; i < visitors.size(); ++i) {
            if (!visitors.get(i).equals(user) && !userFriends.contains(visitors.get(i))) {
                map.put(visitors.get(i), map.get(visitors.get(i)) + 1);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int[] value = new int[5];
        int idx = 0;
        for (Map.Entry<String, Integer> entry : entryList) {
            if (entry.getValue() == 0 || idx >= 5) {
                break;
            }
            value[idx++] = entry.getValue();
            answer.add(entry.getKey());
        }
        for (int i = 0; i < 4; ++i) {
            if (value[i] != 0 && value[i] == value[i + 1]) {
                int start = i;
                int end = start + 1;
                while (true) {
                    if (end >= 5 || value[start] != value[end]) {
                        --end;
                        break;
                    }
                    ++end;
                }
                Collections.sort(answer.subList(start, end + 1));
                i = end;
            }
        }
        return answer;
    }
}
