package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> crewEmail = getDuplicatedCrewEmail(forms);
        return getSortedData(crewEmail);
    }

    private static Set<String> getDuplicatedCrewEmail(List<List<String>> forms) {
        String nickname;
        String divNickname;

        Map<String, String> crew = new HashMap<>();
        Set<String> email = new HashSet<>();

        for (List<String> form : forms) {
            nickname = form.get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                divNickname = nickname.substring(j, j + 2);

                if (crew.containsKey(divNickname)) {
                    email.add(crew.get(divNickname));
                    email.add(form.get(0));
                }

                crew.put(divNickname, form.get(0));
            }
        }
        return email;
    }

    private static List<String> getSortedData(Set<String> email) {
        List<String> emails = new ArrayList<>(email);
        Collections.sort(emails);

        return emails;
    }
}