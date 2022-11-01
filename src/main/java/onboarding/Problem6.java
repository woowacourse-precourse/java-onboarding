package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        HashSet<String> emailSet = new HashSet<>();


        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);

            for (int j = 0; j < name.length() - 1; j++) {
                String substring = name.substring(j, j + 1);

                if (map.containsKey(substring)) {
                    String email = map.get(substring);
                    if (!email.equals(forms.get(i).get(0))) {
                        answer.add(email);
                        emailSet.add(email);
                        emailSet.add(forms.get(i).get(0));
                    }
                }

                map.put(substring, forms.get(i).get(0));
            }
        }

        return answer.stream().distinct().sorted().collect(Collectors.toList());
    }
}