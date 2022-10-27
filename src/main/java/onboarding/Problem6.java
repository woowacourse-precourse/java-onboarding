package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Set<String> emails = new HashSet<>();
        Map<String, String> combinationsOfNames = new HashMap<>();
        for(int i = 0; i < forms.size(); ++i){
            findDuplicatedNamePart(forms.get(i), emails, combinationsOfNames);
        }
        return answer;
    }

    public static void findDuplicatedNamePart(List<String> member, Set<String> emails,
                                              Map<String, String> combinationsOfNames){
        String email = member.get(0);
        String name = member.get(1);
        int nameLen = name.length();
        if(nameLen == 1) return;
        for(int i = 0; i < nameLen - 1; ++i){
            String smallNamePart = String.valueOf(name.charAt(i) + name.charAt(i + 1));
            if(combinationsOfNames.containsKey(smallNamePart)) {
                emails.add(combinationsOfNames.get(smallNamePart));
                emails.add(email);
            } else if(!combinationsOfNames.containsKey(smallNamePart)) {
                combinationsOfNames.put(smallNamePart, email);
            }
        }
    }

}
