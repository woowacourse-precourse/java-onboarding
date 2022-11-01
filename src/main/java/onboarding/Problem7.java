package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> relationship = makeRelationship(friends);
        Map<String, Integer> recommendNum = new HashMap<>();

        for (String s : relationship.get(user)) {
            for (String key : relationship.keySet()) {
                if (!key.equals(user) && !s.equals(key) && relationship.get(key).contains(s)) {
                    if (!recommendNum.containsKey(key)) {
                        recommendNum.put(key, 0);
                    }
                    int i = recommendNum.get(key);
                    recommendNum.replace(key, i + 10);
                }
            }
        }

        for (String key : visitors) {
            if (!relationship.get(user).contains(key)) {
                if (!recommendNum.containsKey(key)) {
                    recommendNum.put(key, 0);
                }
                int i = recommendNum.get(key);
                recommendNum.replace(key, i + 1);
            }
        }

        List<String> answer = sort(recommendNum);

        return answer;
    }

    public static List<String> sort(Map<String, Integer> m) {
        List<Map.Entry<String, Integer>> l = new ArrayList<>(m.entrySet());
        l.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().equals(o2.getKey()) ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue();
            }
        });

        List<String> ss = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if (i == 5) {
                break;
            }
            ss.add(l.get(i).getKey());
        }
        return ss;
    }

    public static Map<String, List<String>> makeRelationship(List<List<String>> friends) {
        Map<String, List<String>> m = new HashMap<>();

        for (List<String> l : friends) {
            for (int i = 0; i < 2; i++) {
                String s = l.get(i);
                if (!m.containsKey(s)) {
                    m.put(s, new ArrayList<>());
                }
                m.get(s).add(l.get((i + 1) % 2));
            }
        }
        return m;
    }
}
