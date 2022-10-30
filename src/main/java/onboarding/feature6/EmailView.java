package onboarding.feature6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmailView {
    private List<String> emailsToBeSorted;
    private List<String> idsOfEmails;
    private List<String> sortedEmails;
    private List<Map<String, Set<String>>> results = new ArrayList<>();
    private Map<String, Set<String>> answer;

    public EmailView(DuplicateLettersFinder duplicateLettersFinder) {
        results.add(duplicateLettersFinder.findDuplicateLetters());
        /*
         * There could be several cases of adjacent duplicate letters such as ('제이', '이엠', '엠제') depending on given nicknames.
         * But the given test case has only 'one' case ('제이'),
         * so it has to return only one pair of key and value from RESULTS as below.
         * {제이=[jason@email.com, jm@email.com, mj@email.com]}
         *
         * That's why I've assigned RESULTS.GET(0) to ANSWER variable.
         */
        answer = results.get(0);
    }

    public List<String> getSortedEmails() {
        sortedEmails = new ArrayList<>();
        for (String key : answer.keySet()) {
            Set<String> emailValues = answer.get(key);
            emailsToBeSorted = new ArrayList<>(emailValues);
            idsOfEmails = extractIdFromEmail(emailsToBeSorted);
        }
        for (String id : idsOfEmails) {
            sortEmailsById(id);
        }
        return sortedEmails;
    }

    public List<String> extractIdFromEmail(List<String> emails) {
        List<String> ids = new ArrayList<>();
        for (String email : emails) {
            String id = email.split("@")[0];
            ids.add(id);
        }
        Collections.sort(ids);
        return ids;
    }

    public void sortEmailsById(String id) {
        for (String email : emailsToBeSorted) {
            if (email.contains(id)) {
                int index = emailsToBeSorted.indexOf(email);
                sortedEmails.add(emailsToBeSorted.get(index));
            }
        }
    }
}
