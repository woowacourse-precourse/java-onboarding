package onboarding;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> duplicatedEmails = getDuplicatedEmails(new HashMap<>(), forms);
        return duplicatedEmails.values().stream()
            .filter(s -> s.size() > 1)
            .flatMap(emails -> emails.stream())
            .distinct()
            .sorted().collect(Collectors.toList());
    }

    private static Map<String, List<String>> getDuplicatedEmails(
        HashMap<String, List<String>> duplicatedEmails, List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);
            for (int i = 1; i < name.length(); i++) {
                String key = name.substring(i - 1, i + 1);
                if (!duplicatedEmails.containsKey(key)) {
                    duplicatedEmails.put(key, new ArrayList<>());
                }
                duplicatedEmails.get(key).add(email);
            }
        }
        return duplicatedEmails;
    }

}

