package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();
        Set<String> duplicatedPattern = new HashSet<>();
        HashMap<String, List<String>> patternEmail = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            for(int i = 0; i < nickname.length()-1; i++) {
                String pattern = nickname.charAt(i) + Character.toString(nickname.charAt(i+1));

                if (duplicatedPattern.contains(pattern)) {
                    answer.add(email);
                    answer.addAll(patternEmail.get(pattern));
                }
                else {
                    duplicatedPattern.add(pattern);
                    patternEmail.put(pattern, new ArrayList<>());
                    patternEmail.get(pattern).add(email);
                }
            }
        }

        return new ArrayList<>(answer).stream().sorted().collect(Collectors.toList());
    }
}
