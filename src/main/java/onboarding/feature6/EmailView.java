package onboarding.feature6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmailView {
    private List<String> emailsToBeSorted;
    private List<String> sortedIdsOfEmails;
    private List<String> sortedEmails;
    private Map<String, Set<String>> results;

    public EmailView(DuplicateLettersFinder duplicateLettersFinder) {
        results = duplicateLettersFinder.findDuplicateLetters();
    }

    public Map<String, List<String>> getSortedResults() {
        Map<String, List<String>> sortedResults = new HashMap<>();
        for (String key : results.keySet()) {
            Set<String> emailValues = results.get(key);
            emailsToBeSorted = new ArrayList<>(emailValues);
            sortedIdsOfEmails = separateEmails(emailsToBeSorted);
            sortedEmails = new ArrayList<>();

            for (String sortedId : sortedIdsOfEmails) {
                sortEmailsById(sortedId);
            }
            sortedResults.put(key, sortedEmails);
        }
        return sortedResults;
    }

    public List<String> separateEmails(List<String> emails) {
        List<String> ids = new ArrayList<>();
        for (String email : emails) {
            String id = getIdFromEmail(email);
            ids.add(id);
        }
        Collections.sort(ids);
        return ids;
    }

    public String getIdFromEmail(String email) {
        return email.split("@")[0];
    }

    public void sortEmailsById(String sortedId) {
        for (String email : emailsToBeSorted) {
            if (getIdFromEmail(email).equals(sortedId)) {
                int index = emailsToBeSorted.indexOf(email);
                sortedEmails.add(emailsToBeSorted.get(index));
            }
        }
    }
}
