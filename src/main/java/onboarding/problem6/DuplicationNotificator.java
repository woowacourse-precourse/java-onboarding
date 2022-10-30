package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class searching for duplicated nickname and notify email addresses
 */
public class DuplicationNotificator {

    private Map<String, List<String>> parts = new HashMap<>();

    /**
     * Constructor with forms
     * @param forms email and nickname list
     */
    public DuplicationNotificator(List<List<String>> forms) {
        checkDuplication(forms);
    }

    /**
     * Check duplication of nickname parts and create parts map
     * @param forms email and nickname list
     */
    private void checkDuplication(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nick = form.get(1);
            for (int i = 0; i < nick.length() - 1; i++) {
                String part = nick.substring(i, i + 2);
                if (parts.containsKey(part)) parts.get(part).add(email);
                else parts.put(part, new ArrayList<>(Collections.singletonList(email)));
            }
        }
    }

    /**
     * Get email list needs to be notified
     * - Check if part of nickname is duplicated
     * - Sort email list
     * - Remove duplicated email address
     * @return email list needs notification
     */
    public List<String> duplicationNotify() {
        List<String> emails = new ArrayList<>();
        for (String key : parts.keySet()) {
            List<String> emailsOfParts = parts.get(key);
            if (emailsOfParts.size() > 1)
                emails.addAll(emailsOfParts);
        }
        emails.sort(String::compareTo);
        return emails.stream().distinct().collect(Collectors.toList());
    }
}
