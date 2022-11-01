package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emailSet = new HashSet<>();
        Map<String, String> formMap = new ConcurrentHashMap<>();

        forms.forEach(form -> formMap.put(
            form.get(1), // nickname
            form.get(0) // email
        ));

        formMap.keySet().forEach(nickname -> {
            IntStream.range(0, nickname.length()-1).forEach(i -> {
                String email = formMap.get(nickname);
                String search = nickname.substring(i,i+2);
                
                if (formMap.containsKey(search)) {
                    String searchEmail = formMap.get(search);
                    if (!email.equals(searchEmail)) {
                        emailSet.add(email);
                        emailSet.add(searchEmail);
                    }
                }

                formMap.put(search, email);
            });
        });

        return emailSet.stream()
            .sorted()
            .collect(Collectors.toList());
    }
}
