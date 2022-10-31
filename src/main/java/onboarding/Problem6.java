package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        HashMap<String, Long> map = new HashMap<>();
        for(List<String> form : forms){
            String id = form.get(1);
            for(int j = 0; j < id.length() - 1; j++){
                String s = id.substring(j, j + 2);
                map.put(s, map.getOrDefault(s, 0L) + 1L);
            }
        }

        return answer;
    }
}
