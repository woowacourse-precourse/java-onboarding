package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicationNotificator {

    private final Map<String, List<String>> parts = new HashMap<>();

    public List<String> notifyEmails(List<List<String>> forms) {
        checkDuplication(forms);
        List<String> emails = new ArrayList<>();
        for (String key : parts.keySet()) {
            List<String> emailsOfParts = parts.get(key);
            if (emailsOfParts.size() > 1)
                emails.addAll(emailsOfParts);
        }
        emails.sort(String::compareTo);
        return emails.stream().distinct().collect(Collectors.toList());
    }

    private void checkDuplication(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nick = form.get(1);
            for (int i = 0; i < nick.length() - 1; i++) {
                String part = nick.substring(i, i + 2);
                if (parts.containsKey(part)) {
                    List<String> emails = parts.get(part);
                    if (!emails.contains(email))
                        emails.add(email);
                } else {
                    parts.put(part, new ArrayList<>(Collections.singletonList(email)));
                }
            }
        }
    }
}
