package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

        for (List<String> friend : friends) {
            String fr = friend.get(0);
            String me = friend.get(1);
            if (fr == user) {
                list.add(me);
            } else if (me == user) {
                list.add(fr);
            }
        }
        for (List<String> friendlist : friends) {
            String a = friendlist.get(0);
            String b = friendlist.get(1);
            if (list.contains(a) && !friendlist.contains(user)) {
                list1.add(b);
            } else if (list.contains(b) && !friendlist.contains(user)) {
                list1.add(a);
            }
        }

        for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i), map.getOrDefault(list1.get(i), 0) + 10);
        }

        for (int i = 0; i < visitors.size(); i++) {
            String c = list.get(0);
            String d = list.get(1);
            if (c != (visitors.get(i)) && d != (visitors.get(i)))
                map.put(visitors.get(i), map.getOrDefault(visitors.get(i),
                    0) + 1);
        }
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (String key : map.keySet()) {
            answer.add(key);
        }

        return answer;
    }
}
