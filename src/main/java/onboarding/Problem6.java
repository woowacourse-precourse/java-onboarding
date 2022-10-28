package onboarding;

import java.util.*;

public class Problem6 {
    final static int EMAIL = 0;
    final static int NAME = 1;
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, Integer> combinationCount = new HashMap<>();
        HashSet<String> duplicateEmails = new HashSet<>();
        for (int i=0; i<forms.size(); i++) {
            List<String> form = forms.get(i);
            HashSet<String> combinations = getCombinations(form.get(NAME));
            for (String combination : combinations) {
                combinationCount.put(combination, combinationCount.getOrDefault(combination, 0)+1);
            }
        }

        for (String twoName : combinationCount.keySet()) {
            if (combinationCount.get(twoName)>1) {
                duplicateEmails.addAll(getDuplicateList(twoName, forms));
            }
        }
        List<String> answer = List.of("answer");
        return answer;
    }

    private static List<String> getDuplicateList(String twoName, List<List<String>> forms) {
        List<String> duplicateEmails = new ArrayList<>();
        for (List<String> form : forms) {
            if (form.get(NAME).contains(twoName)) {
                duplicateEmails.add(form.get(EMAIL));
            }
        }
        return duplicateEmails;
    }

    private static HashSet<String> getCombinations(String name) {
        HashSet<String> combinations = new HashSet<>();

        for (int i=0; i<name.length()-1; i++) {
            combinations.add(name.substring(i, i+1));
        }
        return combinations;
    }
}
