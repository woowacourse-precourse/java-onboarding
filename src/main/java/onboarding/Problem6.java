package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> use_word = new HashSet<String>();
        Set<String> result = new HashSet<String>(new ArrayList<>());

        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);

            for (int j = 0; j < name.length() - 2; j++) {
                String split_name = name.substring(j, j + 2);
                if (use_word.contains(split_name)) continue;

                for (int k = i; k < forms.size(); k++) {
                    String compare_name = forms.get(k).get(1);

                    if (i != k && compare_name.contains(split_name)) {
                        result.add(forms.get(i).get(0));
                        result.add(forms.get(k).get(0));
                    }
                }
                use_word.add(split_name);
            }
        }
        List<String> answer =new ArrayList<String>(result);
        Collections.sort(answer);
        return answer;
    }

}
