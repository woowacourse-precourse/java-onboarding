package onboarding;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();
        Map<String, String> map = new HashMap<>();

        for (List<String> form : forms){
            final String email = form.get(0);
            final String nickname = form.get(1);

            for (int i=0;i<nickname.length()-1;i++){
                String substring = nickname.substring(i,i+2);

                if (map.containsKey(substring)) {
                    if (map.get(substring) != null){
                        answer.add(map.get(substring));
                        map.put(substring, null);
                    }
                    answer.add(email);
                }
                else {
                    map.put(substring, email);
                }
            }
        }
        return answer.stream().sorted().collect(Collectors.toList());

    }
}
