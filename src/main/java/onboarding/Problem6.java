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

            if (RabinKarp.contains(comparedName, target)) {
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
        int atIdx = email.indexOf("@");
        if (atIdx == -1) {
            return false;
        }

        String domain = email.substring(atIdx + 1);
        if (!domain.equals("email.com")) {
            return false;
        }

        return 11 <= email.length() && email.length() < 20;
    }

}

final class RabinKarp {

    private static final int POW = 31;

    public static boolean contains(String src, String target) {
        int lengthOfTarget = target.length();
        int lengthOfSrc = src.length();

        if (lengthOfSrc < lengthOfTarget) {
            return false;
        }

        int cachedPow = (int) Math.pow(POW, lengthOfTarget);
        int hashValueOfTarget = getHashValue(target, lengthOfTarget);
        int hashValueOfSrc = getHashValue(src, lengthOfTarget);

        if (hashValueOfSrc == hashValueOfTarget && isSame(src, 0, target, 0, lengthOfTarget)) {
            return true;
        }

        for (int i = lengthOfTarget; i < lengthOfSrc; i++){
            hashValueOfSrc = hashValueOfSrc * POW + src.charAt(i);
            hashValueOfSrc -= src.charAt(i - lengthOfTarget) * cachedPow;

            if (hashValueOfSrc == hashValueOfTarget && isSame(src, i - lengthOfTarget + 1, target, 0, lengthOfTarget)) {
                return true;
            }
        }

        return false;
    }

    private static int getHashValue(String str, int length) {
        int hash = 0;

        for (int  i = 0; i < length; i++) {
            hash = hash * POW + str.charAt(i);
        }

        return hash;
    }

    private static boolean isSame(String src, int srcIdx, String target, int targetIdx, int length) {
        while (length-- > 0) {
            if (src.charAt(srcIdx++) != target.charAt(targetIdx++)) {
                return false;
            }
        }

        return true;
    }

}