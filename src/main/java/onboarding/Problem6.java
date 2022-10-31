package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return getDuplicatedEmail(forms);
    }

    public static List<String> getDuplicatedEmail(List<List<String>> forms){
        Map<String,String> hashMap = new HashMap<>();
        HashSet<String> emails = new HashSet<>();

        for (List<String> form : forms) {
            String name = form.get(1);

            if (name.length() < 2) {
                break;
            }

            for (int j = 0; j < name.length() - 1; j++) {
                String key = name.substring(j, j + 2);
                if (hashMap.containsKey(key)) {
                    String email = hashMap.get(key);
                    if (!email.equals(form.get(0))) {
                        emails.add(email);
                        emails.add(form.get(0));
                    }
                }
                hashMap.put(key, form.get(0));
            }
        }

        return emails.stream()
                .sorted().collect(Collectors.toList());
    }
}
