package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Set<String> duplicatedUserEmailSet = getDuplicatedUserEmailHashSet(forms);
        return answer;
    }

    public static HashSet<String> getDuplicatedUserEmailHashSet(List<List<String>> forms) {
        HashMap<String, ArrayList<String>> stringEmailHashMap = getStringEmailHashMap(forms);
        HashSet<String> duplicatedUserEmailHashSet = new HashSet<>();

        return duplicatedUserEmailHashSet;
    }

    public static HashMap<String, ArrayList<String>> getStringEmailHashMap(List<List<String>> forms) {
        HashMap<String, ArrayList<String>> stringEmailMap = new HashMap<>();
        for (List<String> userInfo : forms) {
            String email = userInfo.get(0);
            String nickname = userInfo.get(1);
            for (int i=0; i<nickname.length()-1; i++) {
                String partial = nickname.substring(i, i+2);
                if (!stringEmailMap.containsKey(partial)) {
                    stringEmailMap.put(partial, new ArrayList<>(List.of(email)));
                    continue;
                }
                ArrayList<String> emailList = stringEmailMap.get(partial);
                emailList.add(email);
            }
        }
        return stringEmailMap;
    }
}
