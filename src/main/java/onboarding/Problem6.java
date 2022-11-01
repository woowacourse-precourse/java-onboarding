package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, List<List<String>>> nameMap = new HashMap<String, List<List<String>>>();
        Set<String> emailSet = new TreeSet<String>();

        for (List<String> form : forms) {
            String name = form.get(1);

            for (int i = 0; i < name.length() - 1; i++) {
                for (int j = i + 2; j <= name.length(); j++) {
                    String key = name.substring(i, j);
                    if (nameMap.containsKey(key)) {
                        List<List<String>> newList = new ArrayList<List<String>>();
                        List<List<String>> list = nameMap.get(key);
                        for (List<String> l : list) {
                            newList.add(l);
                        }
                        newList.add(form);
                        nameMap.put(key, newList);
                    } else {
                        nameMap.put(key, List.of(form));
                    }
                }
            }
        }

        for (List<List<String>> list : nameMap.values()) {
            if (list.size() > 1) {
                for (List<String> form : list) {
                    emailSet.add(form.get(0));
                }
            }
        }

        answer = List.copyOf(emailSet);

        return answer;
    }
}
