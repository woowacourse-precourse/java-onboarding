package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> notifiedForms = findFormsWithDuplicatedName(forms);
        List<String> emails = getEmails(notifiedForms);

        return emails.stream()
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
    }

    private static List<List<String>> findFormsWithDuplicatedName(List<List<String>> forms) {
        List<List<String>> notifiedForms = new ArrayList<>();

        for (int size = forms.size(), i = 0; i < size; i++) {
            notifiedForms.addAll(findFormsWithDuplicatedName(forms, i));
        }

        return notifiedForms;
    }

    private static List<List<String>> findFormsWithDuplicatedName(List<List<String>> forms, int currentIdx) {
        List<List<String>> notifiedForms = new ArrayList<>();
        List<String> currentForm = forms.get(currentIdx);
        String currentName = currentForm.get(1);

        for (int len = currentName.length() - 1, i = 0; i < len; i++) {
            String target = currentName.substring(i, i + 2);
            notifiedForms.addAll(findFormsWithTarget(forms, currentIdx, target));
        }

        if (!notifiedForms.isEmpty()) {
            notifiedForms.add(currentForm);
        }

        return notifiedForms;
    }

    private static List<List<String>> findFormsWithTarget(List<List<String>> forms, int currentIdx, String target) {
        List<List<String>> notified = new ArrayList<>();

        for (int size = forms.size(), i = currentIdx + 1; i < size; i++) {
            List<String> comparedForm = forms.get(i);
            String comparedName = comparedForm.get(1);

            if (comparedName.contains(target)) {
                notified.add(comparedForm);
            }
        }

        return notified;
    }

    private static List<String> getEmails(List<List<String>> notified) {
        List<String> emails = new ArrayList<>();

        for (List<String> form : notified) {
            String email = form.get(0);

            if (isEmail(email)) {
                emails.add(email);
            }
        }

        return emails;
    }

    private static boolean isEmail(String email) {
        int atInx = email.indexOf("@");

        if (atInx == -1) {
            return false;
        }

        String domain = email.substring(atInx + 1);

        if (!domain.equals("email.com")) {
            return false;
        }

        return 11 <= email.length() && email.length() < 20;
    }

}
