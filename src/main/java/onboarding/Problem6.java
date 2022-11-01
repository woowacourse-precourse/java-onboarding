package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    static List<String> emails;

    public static List<String> solution(List<List<String>> forms) {
        emails = new ArrayList<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            findEmail(i, forms);
        }
        emails.sort(Comparator.naturalOrder());

        return emails;
    }

    public static void findEmail(int i, List<List<String>> forms) {
        List<String> form = forms.get(i);

        String email_1 = form.get(0);
        String name_1 = form.get(1);

        for (int j = i + 1; j < forms.size(); j++) {
            List<String> compareWithForm = forms.get(j);

            String email_2 = compareWithForm.get(0);
            String name_2 = compareWithForm.get(1);

            if (name_1.length() < 2) continue;

            List<String> names = List.of(name_1, name_2);
            List<String> email = List.of(email_1, email_2);
            addEmails(names, email);
        }
    }

    public static void addEmails(List<String> names, List<String> email) {
        if (isDuplicatedEmail(names.get(0), names.get(1))) {
            containEmail(email);
        }
    }

    public static boolean isDuplicatedEmail(String name_1, String name_2) {
        for (int i = 0; i < name_1.length() - 1; i++) {
            String tmp = name_1.substring(i, i + 2);
            if (name_2.contains(tmp)) return true;
        }
        return false;
    }

    public static void containEmail(List<String> email) {
        for (String e : email) {
            if (!emails.contains(e)) {
                emails.add(e);
            }
        }
    }
}
