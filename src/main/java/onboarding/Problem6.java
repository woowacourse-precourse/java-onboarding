package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> emails = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        
        for (List<String> form : forms) {
            Map<String, String> tmp = new HashMap<>();
            final String crewName = form.get(1);
            final String email = form.get(0);
            
            for (int index = 0; index < crewName.length() - 1; index++) {
                final String consecutiveLetters = crewName.substring(index, index + 2);
                
                if (map.containsKey(consecutiveLetters)) {
                    emails.add(email);
                    emails.add(map.get(consecutiveLetters));
                }
                
                tmp.put(consecutiveLetters, email);
            }
            
            map.putAll(tmp);
        }
    
        System.out.println(emails);
        return emails.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    
    public static boolean isExistTwoConsecutiveLetters(final Map<String, String> map, final String twoConsecutiveLetters) {
        return map.containsKey(twoConsecutiveLetters);
    }
}
