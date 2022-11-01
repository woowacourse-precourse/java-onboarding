package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        answer.addAll(overlapInspector(forms));
        return answer;
    }

    static TreeSet<String> overlapInspector(List<List<String>> forms) {
        TreeSet<String> emailSet = new TreeSet<>();
        HashMap<String, String> formMap = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickName = forms.get(i).get(1);
            formMap.put(nickName, email);
        }
        for (String outername : formMap.keySet()) {
            HashSet<String> splitted = getSplitName(outername);
            for (String splittedName : splitted) {
                for (String innername : formMap.keySet()) {
                    if (!innername.equals(outername) && innername.contains(splittedName))
                        emailSet.add(formMap.get(innername));
                }
            }
        }
        return emailSet;
    }

    static HashSet<String> getSplitName(String str) {
        HashSet<String> result = new HashSet<>();
        if (str.length() < 2)
            return result;
        for (int i = 0; i < str.length() - 1; i++) {
            result.add(str.substring(i, i + 2));
        }
        return result;
    }
}
