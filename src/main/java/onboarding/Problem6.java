package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (List<String> item : forms) {
            for (int j = 0; j < item.get(1).length(); j++) {
                for (int k = 0; k < item.get(1).length() - 1 - j; k++) {
                    if (map.containsKey(item.get(1).substring(k, k + j + 2))) {
                        int cnt = map.get(item.get(1).substring(k, k + j + 2));
                        map.put(item.get(1).substring(k, k + j + 2), cnt + 1);
                    } else {
                        map.put(item.get(1).substring(k, k + j + 2), 1);
                    }
                }
            }
        }
        List<String> resultlist = new ArrayList<String>();
        for (String str : map.keySet()) {
            if (map.get(str) != 1) {
                for (List<String> item : forms) {
                    if (item.get(1).contains(str) == true) {
                        resultlist.add(item.get(0));
                    }
                }
            }
        }
        Collections.sort(resultlist);
        return (new ArrayList<String>(new HashSet(resultlist)));
    }
}
