package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicationNotificator {

    private final Map<String, List<String>> nicknameParts = new HashMap<>();

    public List<String> notifyEmails(List<List<String>> forms) {
        checkDuplication(forms);
        List<String> emails = new ArrayList<>();
        for (String key : nicknameParts.keySet()) {
            List<String> emailsOfParts = nicknameParts.get(key);
            if (emailsOfParts.size() > 1)
                emails.addAll(emailsOfParts);
        }
        emails.sort(String::compareTo);
        return emails.stream().distinct().collect(Collectors.toList());
    }

    private void checkDuplication(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                String partOfNickname = nickname.substring(i, i + 2);
                if (nicknameParts.containsKey(partOfNickname)) {
                    List<String> emails = nicknameParts.get(partOfNickname);
                    if (!emails.contains(email))
                        emails.add(email);
                } else {
                    nicknameParts.put(partOfNickname, new ArrayList<>(Collections.singletonList(email)));
                }
            }
        }
    }
}
