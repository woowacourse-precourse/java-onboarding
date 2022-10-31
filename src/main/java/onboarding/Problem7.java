package onboarding;

import java.util.*;

public class Problem7 {

    public static int countAcquaintance(List<String> userRelation1, List<String> userRelation2) {
        int idx1 = 0, idx2 = 0;
        int count = 0;
        while (idx1 < userRelation1.size() && idx2 < userRelation2.size()) {
            String str1 = userRelation1.get(idx1);
            String str2 = userRelation1.get(idx2);
            int result = str1.compareTo(str2);
            if (result < 0) {
                idx1++;
            } else if (result > 0) {
                idx2++;
            } else {
                count++;
                idx1++;
                idx2++;
            }
        }
        return count;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> relation = new HashMap<>();
        for (List<String> list : friends) {
            String f1 = list.get(0);
            String f2 = list.get(1);
            List<String> arr = new ArrayList<>();
            if (!relation.containsKey(f1)) {
                relation.put(f1, new ArrayList<>());
            }
            if (!relation.containsKey(f2)) {
                relation.put(f2, new ArrayList<>());
            }
            relation.get(f1).add(f2);
            relation.get(f2).add(f1);
        }

        List<String> userRelation = relation.get(user);
        userRelation.sort(Comparator.naturalOrder());


        HashMap<String, Integer> score = new HashMap<>();
        for (String key : relation.keySet()) {
            relation.get(key).sort(Comparator.naturalOrder());
            if (key.equals(user) || userRelation.contains(key)) {
                continue;
            }
            int count = countAcquaintance(relation.get(key), userRelation);
            if (!score.containsKey(key)) {
                score.put(key, 0);
            }
            score.put(key, score.get(key) + 10 * count);
        }

        for (String key : visitors) {
            if (userRelation.contains(key)) {
                continue;
            }
            if (!score.containsKey(key)) {
                score.put(key, 0);
            }
            score.put(key, score.get(key) + 1);
        }

        return answer;
    }
}
