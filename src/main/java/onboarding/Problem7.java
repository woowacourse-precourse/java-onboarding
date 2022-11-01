package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> everyone = new ArrayList<>();
        for (List<String> pair : friends) {
            for (String name : pair) {
                if (!everyone.contains(name)) {
                    everyone.add(name);
                }
            }
        }
        for (String name : visitors) {
            if (!everyone.contains(name)) {
                everyone.add(name);
            }
        }
        Collections.sort(everyone);

        int headcount = everyone.size();
        int [][] matrix = new int[headcount][headcount];
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> reverse = new HashMap<>();
        int count = 0;
        for (String name : everyone) {
            map.put(name, count);
            reverse.put(count, name);
            count++;
        }

        for (List<String> pair : friends) {
            String jack = pair.get(0);
            String jill = pair.get(1);
            int i = map.get(jack);
            int j = map.get(jill);
            matrix[i][j] = -1;
            matrix[j][i] = -1;
        }

        int me = map.get(user);
        for (String name : visitors) {
            int from = map.get(name);
            if (from != me && matrix[me][from] >= 0) {
                matrix[me][from] += 1;
            }
        }

        for (int friend = 0; friend < headcount; friend++) {
            if (matrix[me][friend] < 0) {
                for (int mutual = 0; mutual < headcount; mutual++) {
                    if (mutual != me && matrix[friend][mutual] < 0) {
                        matrix[me][mutual] += 10;
                    }
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int max = me;
            for (int j = 0; j < headcount; j++) {
                if (matrix[me][j] <= 0) {
                    continue;
                }
                String name = reverse.get(j);
                boolean recommended = result.contains(name);
                if (!recommended && matrix[me][j] > matrix[me][max]) {
                    max = j;
                }
            }
            if (max == me) {
                break;
            }
            String name = reverse.get(max);
            result.add(name);
        }
        return result;
    }
}
