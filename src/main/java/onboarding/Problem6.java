package onboarding;

import java.util.*;

public class Problem6 {
    final static int EMAIL = 0;
    final static int NAME = 1;
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> contacts = new HashMap<>();
        HashMap<String, Integer> combinationCount = new HashMap<>();
        for (int i=0; i<forms.size(); i++) {
            List<String> form = forms.get(i);
            contacts.put(form.get(EMAIL),form.get(NAME));
            HashSet<String> combinations = getCombinations(form.get(NAME));
            for (String combination : combinations) {
                combinationCount.put(combination, combinationCount.getOrDefault(combination, 0)+1);
            }
        }

        List<String> answer = List.of("answer");
        return answer;
    }

    private static HashSet<String> getCombinations(String name) {
        HashSet<String> combinations = new HashSet<>();

        for (int i=0; i<name.length()-1; i++) {
            combinations.add(name.substring(i, i+1));
        }
        return combinations;
    }
}
