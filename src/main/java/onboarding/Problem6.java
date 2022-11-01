package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> partialName = new ArrayList<>();
        Set<String> dupMail = new HashSet<>();
        Set<String> duplName = new HashSet<>();

        partialName = getPartialName(forms);
        duplName = getDuplicateName(partialName);
        dupMail = getMail(forms, duplName);

        List<String> answer = new ArrayList<>(dupMail);
        Collections.sort(answer);

        return answer;
    }

    static List<String> getPartialName(List<List<String>> forms) {

        List<String> partialName = new ArrayList<>();
        String userName;

        for (List<String> form : forms) {
            userName = form.get(1);
            for (int i = 0; i < userName.length() - 1; i++) {
                partialName.add(userName.substring(i, i + 2));
            }
        }

        return partialName;
    }

    static Set<String> getDuplicateName(List<String> partialName) {

        Set<String> duplName = new HashSet<>();
        for (String s : partialName) {
            if (Collections.frequency(partialName, s) > 1) {
                duplName.add(s);
            }
        }

        return duplName;
    }

    static Set<String> getMail(List<List<String>> forms, Set<String> duplName) {

        Set<String> dupMail = new HashSet<>();
        String userName;

        for (List<String> form : forms) {
            userName = form.get(1);

            for (String name : duplName) {
                if (userName.contains(name)) {
                    dupMail.add(form.get(0));
                }
            }
        }

        return dupMail;
    }
}
