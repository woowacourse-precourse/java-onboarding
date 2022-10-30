package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> ans = new HashSet<>();

        parseNickName(forms, map);
        checkDuplication(map, ans);

        List<String> answer = new ArrayList<>(ans);
        Collections.sort(answer);
        return answer;
    }

    private static void checkDuplication(Map<String, List<String>> map, Set<String> ans) {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            if(map.get(key).size() >= 2) {
                for(String email : map.get(key)) {
                    ans.add(email);
                }
            }
        }
    }

    private static void parseNickName(List<List<String>> forms, Map<String, List<String>> map) {
        for(List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);
            for(int i = 0; i < nickName.length()-1; i++) {
                String sub = nickName.substring(i, i+2);
                if(map.containsKey(sub)) {
                    map.get(sub).add(email);
                } else {
                    map.put(sub, new ArrayList<>(List.of(email)));
                }
            }
        }
    }
}
