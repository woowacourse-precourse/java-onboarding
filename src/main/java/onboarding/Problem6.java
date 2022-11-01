package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> duplicatedUserEmailSet = getDuplicatedUserEmailSet(forms);
        List<String> duplicatedUserEmailAscendingList = getDuplicatedUserEmailAscendingList(duplicatedUserEmailSet);
        return duplicatedUserEmailAscendingList;
    }

    private static List<String> getDuplicatedUserEmailAscendingList(Set<String> duplicatedUserEmailSet) {
        List<String> duplicatedUserEmailAscendingList = new ArrayList<>(duplicatedUserEmailSet);
        Collections.sort(duplicatedUserEmailAscendingList);
        return duplicatedUserEmailAscendingList;
    }

    public static Set<String> getDuplicatedUserEmailSet(List<List<String>> forms) {
        HashMap<String, ArrayList<String>> stringEmailHashMap = getStringEmailMap(forms);
        HashSet<String> duplicatedUserEmailHashSet = getDuplicatedUserEmailSet(stringEmailHashMap);
        return duplicatedUserEmailHashSet;
    }

    public static HashMap<String, ArrayList<String>> getStringEmailMap(List<List<String>> forms) {
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

    public static HashSet<String> getDuplicatedUserEmailSet(HashMap<String, ArrayList<String>> stringEmailHashMap) {
        Set<String> partialStringSet = stringEmailHashMap.keySet();
        HashSet<String> duplicatedUserEmailHashSet = new HashSet<>();
        for (String partialString : partialStringSet) {
            ArrayList<String> emailList = stringEmailHashMap.get(partialString);
            if (emailList.size() > 1) {
                duplicatedUserEmailHashSet.addAll(emailList);
            }
        }
        return duplicatedUserEmailHashSet;
    }
}
