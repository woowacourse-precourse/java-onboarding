package onboarding;

import java.util.*;
import java.util.regex.Pattern;

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

    public static boolean validation(String user, List<List<String>> friends, List<String> visitors) {
        if (user.length() < 1 || user.length() > 30 || !Pattern.matches("^[a-z]*$", user)) {
            return false;
        }
        if (friends.size() < 1 || friends.size() > 10000) {
            return false;
        }
        if (visitors.size() > 10000) {
            return false;
        }

        for (int i = 0; i < friends.size(); i++) {
            String f1 = friends.get(i).get(0);
            String f2 = friends.get(i).get(1);

            if (friends.get(i).size() != 2 || !Pattern.matches("^[a-z]*$", f1) || !Pattern.matches("^[a-z]*$", f2)) {
                return false;
            }
            if (f1.length() < 1 || f1.length() > 30 || f2.length() < 1 || f2.length() > 30) {
                return false;
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            String vis = visitors.get(i);
            if (vis.length() < 1 || vis.length() > 30 || !Pattern.matches("^[a-z]*$", vis)) {
                return false;
            }
        }
        return true;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> relation = new HashMap<>();
        if (!validation(user, friends, visitors)) {
            return null;
        }

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

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(score.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        int cnt = 0;
        for (int i = 0; i < entryList.size() && cnt < 5; i++, cnt++) {
            if (entryList.get(i).getValue() == 0) {
                break;
            }
            answer.add(entryList.get(i).getKey());
        }
        return answer;
    }
}
