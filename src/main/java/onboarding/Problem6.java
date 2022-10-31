package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, Integer> nameCount = new HashMap<>();

        for (int i = 0; i < forms.size(); i += 1) {
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j += 1) {
                String slicedName = forms.get(i).get(1).substring(j, j + 2);
                if (nameCount.containsKey(slicedName)) {
                    nameCount.put(slicedName, nameCount.get(slicedName) + 1);
                } else {
                    nameCount.put(slicedName, 1);
                }
            }
        }

        for (String key : nameCount.keySet()) {
            System.out.println(nameCount);
            if (nameCount.get(key) > 1) {
                for (int i = 0; i < forms.size(); i += 1) {
                    if (forms.get(i).get(1).contains(key)) {
                        answer.add(forms.get(i).get(0));
                    }
                }
            }
        }

        return answer;
    }
}