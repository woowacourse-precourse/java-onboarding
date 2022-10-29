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
        List<String> answer;
        answer = duplicateEmails.stream()
                .sorted()
                .collect(Collectors.toList());
        return answer;
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

            List<String> twoLetterNicknames = splitTwoLetter(nickname);
            storeEmails(nicknames, email, twoLetterNicknames);
        }
        return nicknames;
    }

    private static List<String> splitTwoLetter(String nickname) {
        List<String> twoLetterNicknames = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLetterNickname = nickname.substring(i, i + 2);
            twoLetterNicknames.add(twoLetterNickname);
        }

        return twoLetterNicknames;
    }

    private static void storeEmails(Map<String, List<String>> nicknames, String email, List<String> splitNicknames) {
        for (String nickname : splitNicknames) {
            List<String> emails = new ArrayList<>();
            if (nicknames.containsKey(nickname)) {
                emails = nicknames.get(nickname);
            }
            emails.add(email);
            nicknames.put(nickname, emails);
        }
    }
}
