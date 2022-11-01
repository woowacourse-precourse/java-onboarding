package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> map = new HashMap<>();
        Set<String> result = new HashSet<>();
        result.add(forms.get(0).get(0));

        for(List<String> form : forms) {

            String email = form.get(0);
            String nickname = form.get(1);

            if(nickname.length() == 1) {
                continue;
            }

            for(int i = 0; i < nickname.length() - 1; i++) {
                String continuousWord = nickname.substring(i, i + 2);

                if(map.containsKey(continuousWord)) {
                    result.add(email);
                } else {
                    map.put(continuousWord, email);
                }
            }
        }

        return result.stream().sorted().collect(Collectors.toList());
    }
}
