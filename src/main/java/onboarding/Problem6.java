package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> needToChange = new HashSet<>();
        Map<String, String> crew = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            if(name.length() < 2){
                break;
            }
            for (int j = 0; j < name.length() - 1; j++) {
                String key = name.substring(j, j+2);
                if (crew.containsKey(key)) {
                    String email = crew.get(key);
                    if (!email.equals(forms.get(i).get(0))) {
                        needToChange.add(email);
                        needToChange.add(forms.get(i).get(0));
                    }
                }
                crew.put(key, forms.get(i).get(0));
            }
        }
        List<String> result = needToChange.stream().sorted().collect(Collectors.toList());

        return result;
    }
}
