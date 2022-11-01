package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());

        Map<String, Integer> map = new HashMap<>();

        map.put(user, 0);
        int v = 1;
        for (List<String> friend : friends) {
            for (int i = 0; i < 2; i++) {
                if (!map.containsKey(friend.get(i))) {
                    map.put(friend.get(i), v);
                    v++;
                }
            }
        }

        for (String visitor : visitors) {
            if (!map.containsKey(visitor)) {
                map.put(visitor, v);
                v++;
            }
        }

        int size = map.size();
        int[][] table = new int[size][size];
        List<Integer> cnt = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = 0;
            }
            cnt.add(0);
        }

        String[] names = new String[size];
        for (List<String> friend : friends) {
            int idx1 = map.get(friend.get(0));
            int idx2 = map.get(friend.get(1));
            table[idx1][idx2]++;
            table[idx2][idx1]++;

            names[idx1] = friend.get(0);
            names[idx2] = friend.get(1);
        }

        for (String visitor : visitors) {
            int idx1 = map.get(visitor);
            names[idx1] = visitor;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if (table[i][j] > 0 && table[0][j] > 0)
                    cnt.set(i, cnt.get(i) + 10);
            }
        }

        for (String visitor : visitors) {
            cnt.set(map.get(visitor), cnt.get(map.get(visitor)) + 1);
        }

        Map<String, Integer> result = new HashMap<>(size);
        for (int i = 1; i < size; i++) {
            if (table[0][i] == 0)
                result.put(names[i], cnt.get(i));
        }

        answer.addAll(result.keySet());
        return answer;
    }
}
