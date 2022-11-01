package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer; 
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<String, Integer> points = new HashMap<>();

        for (List<String> rel : friends) {
            String first = rel.get(0);
            String second = rel.get(1);

            if (map.getOrDefault(first, new ArrayList<>()).equals(Collections.EMPTY_LIST)) {
                map.put(first, new ArrayList<>());
            }
            map.get(first).add(second);

            if (map.getOrDefault(second, new ArrayList<>()).equals(Collections.EMPTY_LIST)) {
                map.put(second, new ArrayList<>());
            }
            map.get(second).add(first);
        }

//        for (String candidate : map.get(user)) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            String candidate = entry.getKey();
            if (user.equals(candidate)) continue;
            else if(map.get(user).contains(candidate)) continue;

            HashSet<String> temp = new HashSet<>(map.get(user));
            temp.retainAll(new HashSet<>(map.get(candidate)));
            int withFriends = temp.size();

            if (points.getOrDefault(candidate, 0) == 0) {
                points.put(candidate, withFriends * 10);
            } else {
                points.put(candidate, points.get(candidate) + withFriends * 10);
            }
        }

        for (String visitor : visitors) {
            if (map.get(user).contains(visitor)) continue;
            if (points.getOrDefault(visitor, 0) == 0) {
                points.put(visitor, 1);
            } else {
                points.put(visitor, points.get(visitor) + 1);
            }
        }

        List<String> keyList = new ArrayList<>(points.keySet());
        for (int i = 0; i < keyList.size() - 1; i++) {
            for (int j = i + 1; j < keyList.size(); j++) {
                if (points.get(keyList.get(i)) < points.get(keyList.get(j))) {
                    String temp = keyList.get(i);
                    keyList.set(i, keyList.get(j));
                    keyList.set(j, temp);
                } else if (points.get(keyList.get(i)).equals(points.get(keyList.get(j)))) {
                    if (keyList.get(i).compareTo(keyList.get(j)) > 0) {
                        String temp = keyList.get(i);
                        keyList.set(i, keyList.get(j));
                        keyList.set(j, temp);
                    }
                }
            }
        }

        return keyList;
    }
}