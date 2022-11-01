package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    private static final int DUPLICATED_COUNT = 2;

    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> nicknames = createNicknameMap(forms);
        Set<String> duplicateEmails = getDuplicateEmails(nicknames);
        return sortAnswer(duplicateEmails);
    }

    private static List<String> sortAnswer(Set<String> duplicateEmails) {
        return duplicateEmails.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static Set<String> getDuplicateEmails(Map<String, List<String>> nicknameDict) {
        Set<String> duplicatedEmails = new HashSet<>();

        nicknameDict.forEach((nickname, emails) -> {
            if (emails.size() >= DUPLICATED_COUNT) {
                duplicatedEmails.addAll(emails);
            }
        });

        return duplicatedEmails;
    }

    private static Map<String, List<String>> createNicknameMap(List<List<String>> forms) {
        Map<String, List<String>> nicknames = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            Set<String> twoLetterNicknames = splitTwoLetter(nickname);
            storeEmails(nicknames, email, twoLetterNicknames);
        }

        return nicknames;
    }

    private static Set<String> splitTwoLetter(String nickname) {
        Set<String> twoLetterNicknames = new HashSet<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLetterNickname = nickname.substring(i, i + 2);
            twoLetterNicknames.add(twoLetterNickname);
        }

        return twoLetterNicknames;
    }

    private static void storeEmails(Map<String, List<String>> nicknames, String email, Set<String> twoLetterNicknames) {
        for (String twoLetterNickname : twoLetterNicknames) {
            List<String> emails = nicknames.getOrDefault(twoLetterNickname, new ArrayList<>());
            emails.add(email);
            nicknames.put(twoLetterNickname, emails);
        }
    }
}
