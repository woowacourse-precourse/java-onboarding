package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, String> map = new HashMap<>();
        
        for (List<String> form : forms) {
            Map<String, String> tmp = new HashMap<>();
            final String crewName = form.get(1);
            final String email = form.get(0);
            
            for (int index = 0; index < crewName.length() - 1; index++) {
                tmp.put(crewName.substring(index, index + 2), email);
            }
            
            map.putAll(tmp);
        }
    
        System.out.println(map.keySet());
        
        return answer;
    }
    
    public static boolean isExistTwoConsecutiveLetters(final Map<String, String> map, final String twoConsecutiveLetters) {
        return map.containsKey(twoConsecutiveLetters);
    }
}
