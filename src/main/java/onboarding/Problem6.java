package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = duplicatedCrewEmail(forms);
        return answer;
    }
    private static List<String> duplicatedCrewEmail(List<List<String>> forms) {

        Set<String> e = (Set<String>) duplicatedCrewEmail(forms);
        List<String> emailList = new ArrayList<>(e);

        sortEmailList(emailList);

        return emailList;
    }
    private static Set<String> getDuplicatedEmailSet(List<List<String>> forms) {
        Set<String> result = new HashSet<>();
        Map<Integer, Set<String>> charSetEmailMap = new HashMap<>();
        for(List<String> form : forms) {
            putCharSet(form, charSetEmailMap);
        }

        charSetEmailMap.forEach((strKey, setValue) -> {
            if(setValue.size() >= 2) {
                result.addAll(setValue);
            }
        });

        return result;
    }


}
