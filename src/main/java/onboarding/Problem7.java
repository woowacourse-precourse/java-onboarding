package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friendList = findUserFriend(user, friends);
        HashMap<String, Integer> algorithmPointMap = findFriendOfFriend(user, friends, friendList);
        addVisitorPoint(visitors, friendList, algorithmPointMap);

        sortHashMap(algorithmPointMap);

        for (Map.Entry<String, Integer> entry : algorithmPointMap.entrySet()) {
            answer.add(entry.getKey());
            if (answer.size() > 5) {
                break;
            }
        }

        return answer;
    }

    public static void addVisitorPoint(List<String> visitors, List<String> friendList, HashMap<String, Integer> hm) {
        for (String name : visitors) {
            if (!friendList.contains(name)) {
                if (hm.get(name) == null) {
                    hm.put(name, 1);
                    continue;
                }
                hm.put(name, hm.get(name) + 1);
            }
        }
    }

    public static HashMap<String, Integer> findFriendOfFriend(String user, List<List<String>> friends, List<String> friendList) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (List<String> target : friends) {
            if (!target.contains(user)) {
                if (!friendList.contains(target.get(0))) {
                    if (hm.get(target.get(0)) == null) {
                        hm.put(target.get(0), 10);
                        continue;
                    }
                    hm.put(target.get(0), hm.get(target.get(0)) + 10);
                }
                if (!friendList.contains(target.get(1))) {
                    if (hm.get(target.get(1)) == null) {
                        hm.put(target.get(1), 10);
                        continue;
                    }
                    hm.put(target.get(1), hm.get(target.get(1)) + 10);
                }
            }
        }

        return hm;
    }


    public static List<String> findUserFriend(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for (List<String> target : friends) {
            if (target.get(0) == user) {
                friendList.add(target.get(1));
            }
            if (target.get(1) == user) {
                friendList.add(target.get(0));
            }
        }

        return friendList;
    }

    private static Map<String, Integer> sortHashMap(Map<String, Integer> unsortedMap) {
        SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<>((e1, e2) -> {
            int res = e1.getValue().compareTo(e2.getValue());
            if (res == 0)
                return e1.getKey().compareTo(e2.getKey());
            return res * -1;
        });
        sortedSet.addAll(unsortedMap.entrySet());

        Map<String, Integer> sortedLinkedHashMap = new LinkedHashMap<>();
        for (var entry : sortedSet) sortedLinkedHashMap.put(entry.getKey(), entry.getValue());

        return sortedLinkedHashMap;
    }
}
