package onboarding.feature6;

import static onboarding.feature6.Constants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateLettersFinder {
    private String duplicateLetters = null;
    private String currentEmail;
    private String nextEmail;
    
    private List<String> userEmails;
    private List<String> userNicknames;
    private Map<String, Set<String>> filteredResults = new HashMap<>(); // {key: duplicate letters & value: filtered emails}

    public DuplicateLettersFinder(UserInfo userInfo) {
        userEmails = userInfo.getEmails();
        userNicknames = userInfo.getNicknames();
    }

    public Map<String, Set<String>> findDuplicateLetters() {
        for (int i = 0; i < userNicknames.size() - 1; i++) {
            String currentNickname = userNicknames.get(i);
            currentEmail = userEmails.get(i);
            for (int k = i + 1; k < userNicknames.size(); k++) {
                String nextNickname = userNicknames.get(k);
                nextEmail = userEmails.get(k);
                chooseNicknames(currentNickname, nextNickname);
            }
        }
        return filteredResults;
    }

    public void chooseNicknames(String currentNickname, String nextNickname) {
        for (int m = 0; m < currentNickname.length() - 1; m++) {
            String lettersOfCurrentNickname = currentNickname.substring(m, m + INCREMENT);
            for (int n = 0; n < nextNickname.length() - 1; n++) {
                String lettersOfNextNickname = nextNickname.substring(n, n + INCREMENT);
                compareLetters(lettersOfCurrentNickname, lettersOfNextNickname);
            }
        }
    }

    public void compareLetters(String lettersOfCurrentNickname, String lettersOfNextNickname) {
        if (lettersOfCurrentNickname.equals(lettersOfNextNickname)) {
            duplicateLetters = lettersOfCurrentNickname;
            updateFilteredResults();
        }
    }

    public void updateFilteredResults() {
        if (filteredResults.containsKey(duplicateLetters)) {
            Set<String> existingFilteredEmails = filteredResults.get(duplicateLetters);
            existingFilteredEmails.add(currentEmail);
            existingFilteredEmails.add(nextEmail);
            filteredResults.replace(duplicateLetters, existingFilteredEmails);
            return;
        }
        Set<String> newFilteredEmails = new HashSet<>();
        newFilteredEmails.add(currentEmail);
        newFilteredEmails.add(nextEmail);
        filteredResults.put(duplicateLetters, newFilteredEmails);
    }
}
