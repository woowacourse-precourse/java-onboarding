package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static HashMap<String, List<String>> getFriendMap(List<List<String>> friends) {
        HashMap<String, List<String>> result = new HashMap<>();

        for (List<String> names : friends) {
            for (int i = 0; i < names.size(); i++) {
                String name1 = names.get(i);
                for (int j = 0; j < names.size(); j++) {
                    if (i == j) {
                        continue;
                    }

                    String name2 = names.get(j);
                    if (result.containsKey(name1)) {
                        result.get(name1).add(name2);
                    }else{
                        result.put(name1, new ArrayList<String>(Arrays.asList(name2)));
                    }
                }
            }
        }

        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
