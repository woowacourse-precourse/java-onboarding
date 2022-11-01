package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        for (List<String> form : forms) {
            Set<String> subSet = subWordSet(form.get(1));
            for (String s : map.keySet()) {
                if (subSet.contains(s)) {
                    answer.add(form.get(0));
                    answer.add(map.get(s));
                    break;
                }
            }

            for (String s : subSet) {
                map.put(s, form.get(0));
            }
        }
        List<String> ansList = new ArrayList<>();
        for (String s : answer) {
            ansList.add(s);
        }
        Collections.sort(ansList);
        return ansList;
    }

    static Set<String> subWordSet(String word) {
        Set<String> set = new HashSet<>();
        for (int len = 2; len <= word.length(); ++len) {
            for (int i = 0; i + len <= word.length(); ++i) {
                set.add(word.substring(i, i+len));
            }
        }
        return set;
    }
}
