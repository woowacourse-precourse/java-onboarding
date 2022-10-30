package onboarding.feature6;

import static onboarding.feature6.Constants.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateLettersFinder {
    private String duplicateLetters;
    private String currentEmail;
    private String nextEmail;

    private List<String> userEmails;
    private List<String> userNicknames;
    private Map<String, Set<String>> result = new HashMap<>(); // {key: duplicate letters & value: filtered emails}
    public Set<String> duplicateLettersList = new HashSet<>();

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
        return result;
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
            duplicateLettersList.add(duplicateLetters);
            updateResult();
        }
    }

    public void updateResult() {
        if (result.containsKey(duplicateLetters)) {
            Set<String> existingFilteredEmails = result.get(duplicateLetters);
            existingFilteredEmails.add(currentEmail);
            existingFilteredEmails.add(nextEmail);
            result.replace(duplicateLetters, existingFilteredEmails);
            return;
        }
        Set<String> newFilteredEmails = new HashSet<>();
        newFilteredEmails.add(currentEmail);
        newFilteredEmails.add(nextEmail);
        result.put(duplicateLetters, newFilteredEmails);
    }
}
