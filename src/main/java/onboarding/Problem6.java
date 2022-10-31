package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;

        HashSet<String> emails = compareDuplicateName(forms);
        answer = sortEmails(emails);

        return answer;
    }

    public static HashSet<String> compareDuplicateName(List<List<String>> crewInfo) {
        HashSet<String> emails = new HashSet<>();
        Map<String, String> nameAndEmailPair = new HashMap<>();
        String name = "";
        String duplicateName = "";
        String email = "";

        for (int i = 0; i < crewInfo.size(); i++) {
            name = crewInfo.get(i).get(1);

            if (name.length() < 2) {
                break;
            }

            for (int j = 0; j < name.length() - 1; j++) {
                duplicateName = name.substring(j, j + 2);

                if (nameAndEmailPair.containsKey(duplicateName)) {
                    email = nameAndEmailPair.get(duplicateName);

                    if (!email.equals(crewInfo.get(i).get(0))) {
                        emails.add(email);
                        emails.add(crewInfo.get(i).get(0));
                    }
                }

                nameAndEmailPair.put(duplicateName, crewInfo.get(i).get(0));
            }
        }

        return emails;
    }

    public static List<String> sortEmails(HashSet<String> emails) {
        List<String> sortedEmails = emails.stream()
                .sorted()
                .collect(Collectors.toList());

        return sortedEmails;
    }
}
