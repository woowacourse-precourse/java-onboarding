package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, String> infoMap = setInfoMap(forms);
        return answer;
    }

    private static Map<String, String> setInfoMap(List<List<String>> form) {
        // k : nickname | v : email
        Map<String, String> m = new HashMap<>();
        for(List<String> l : form) {
            m.put(l.get(1),l.get(0));
        }
        return m;
    }
}
