package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> emails = emailsOfDuplicateNickname(forms);
    
        return emails.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    
    private static Set<String> emailsOfDuplicateNickname(final List<List<String>> forms) {
        Set<String> emails = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        
        for (List<String> form : forms) {
            addConsecutiveLettersOfEachCrew(emails, map, form);
        }
        return emails;
    }
    
    private static void addConsecutiveLettersOfEachCrew(final Set<String> emails, final Map<String, String> map, final List<String> form) {
        Map<String, String> tmp = new HashMap<>();
        final String crewName = form.get(1);
        final String email = form.get(0);
        
        for (int index = 0; index < crewName.length() - 1; index++) {
            final String consecutiveLetters = crewName.substring(index, index + 2);
            
            if (isExistTwoConsecutiveLetters(map, consecutiveLetters)) {
                emails.add(email);
                emails.add(map.get(consecutiveLetters));
            }
            
            tmp.put(consecutiveLetters, email);
        }
        
        map.putAll(tmp);
    }
    
    private static boolean isExistTwoConsecutiveLetters(final Map<String, String> map, final String twoConsecutiveLetters) {
        return map.containsKey(twoConsecutiveLetters);
    }
}
