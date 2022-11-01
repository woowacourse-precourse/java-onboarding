package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {
    static Set<String> emailsSet;
    static Map<String, String> consecutiveWordsMap;

    static List<String> solution(List<List<String>> forms) {
        Set<String> resultEmailSet = getEmailsSet(forms);
        List<String> sortedEmailList = getSortedEmailList(resultEmailSet);

        return sortedEmailList;
    }

    static Set<String> getEmailsSet(List<List<String>> forms) {
        emailsSet = new HashSet<>();
        consecutiveWordsMap = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            String currentEmail = forms.get(i).get(0);
            String currentName = forms.get(i).get(1);

            if(currentName.length() > 1) {
                validateConsecutiveWord(currentName, currentEmail);
            }
        }

        return emailsSet;
    }

    static void validateConsecutiveWord(String currentName, String currentEmail) {
        for (int j = 0; j < currentName.length() - 1; j++) {
            String consecutiveWord = currentName.substring(j, j+2);

            inputConsecutiveWordsMap(consecutiveWord, currentName, currentEmail);
            consecutiveWordsMap.put(consecutiveWord, currentEmail);
        }
    }

    static void inputConsecutiveWordsMap(String consecutiveWord, String currentName, String currentEmail) {
        if (consecutiveWordsMap.containsKey(consecutiveWord)) {
            String consecutiveEmail = consecutiveWordsMap.get(consecutiveWord);

            inputEmails(consecutiveEmail, currentEmail);
        }
    }

    static void inputEmails(String consecutiveEmail, String currentEmail) {
        if(!consecutiveEmail.equals(currentEmail)) {
            emailsSet.add(consecutiveEmail);
            emailsSet.add(currentEmail);
        }
    }

    static List<String> getSortedEmailList (Set<String> emails) {
        return emails.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
