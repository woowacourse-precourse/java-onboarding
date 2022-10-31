package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> nickNamesFromForms = getNickNamesFromForms(forms);
        List<String> emailsFromForms = getEmailsFromForms(forms);

        Set<String> emails = new HashSet<>();

        Map<String, String> temp = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {

            String nickName = nickNamesFromForms.get(i);

            for (int j = 0; j < nickName.length() - 1; j++) {
                String key = nickName.substring(j, j + 2);

                if (temp.containsKey(key)) {
                    String email = temp.get(key);
                    emails.add(email);

                    emails.add(emailsFromForms.get(i));
                }

                temp.put(key, emailsFromForms.get(i));
            }
        }

        answer = emails.stream().sorted().collect(Collectors.toList());

        return answer;
    }

    static List<String> getNickNamesFromForms(List<List<String>> forms) {
        return forms.stream()
                .flatMap(Collection::stream)
                .filter(form -> form.matches("^[가-힣]*$"))
                .collect(Collectors.toList());
    }

    static List<String> getEmailsFromForms(List<List<String>> forms) {
        return forms.stream()
                .flatMap(Collection::stream)
                .filter(form -> form.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$"))
                .collect(Collectors.toList());
    }
}
