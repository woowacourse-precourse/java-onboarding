package onboarding.feature6;

import static onboarding.feature6.Constants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateCharactersFinder {
    private String duplicateLetters = null;
    private String currentEmail;
    private String nextEmail;
    
    private List<String> userEmails;
    private List<String> userNicknames;
    private Map<String, Set<String>> filteredResults = new HashMap<>(); // {key: duplicate letters & value: filtered emails}

    public DuplicateCharactersFinder(UserInfo userInfo) {
        userEmails = userInfo.getEmails();
        userNicknames = userInfo.getNicknames();
    }

    public List<String> getFilteredEmails(Map<String, Set<String>> filteredResults) {
        List<String> setToList = new ArrayList<>(filteredResults.get(duplicateLetters));
        List<String> idsSorted = new ArrayList<>();
        List<String> emailsSorted = new ArrayList<>();

        for (String email : setToList) {
            idsSorted.add(email.split("@")[0]);
        }
        Collections.sort(idsSorted);
        for (String id : idsSorted) {
            for (String email : setToList) {
                if (id.equals(email.split("@")[0])) {
                    int index = setToList.indexOf(email);
                    emailsSorted.add(setToList.get(index));
                }
            }
        }
        return emailsSorted;
    }

    /*
     * The method below🔻 could return more than two pairs of key and value
     * if given nicknames share several cases of adjacent duplicate letters.
     */
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
