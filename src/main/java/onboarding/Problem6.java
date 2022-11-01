package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> notifiedEmails = findEmailsWithDuplicatedName(forms);
        return notifiedEmails.stream()
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
    }

    private static List<String> findEmailsWithDuplicatedName(List<List<String>> forms) {
        List<String> notifiedEmails = new ArrayList<>();

        for (int size = forms.size(), i = 0; i < size; i++) {
            notifiedEmails.addAll(findEmailsWithTargetName(forms, i));
        }

        return notifiedEmails;
    }

    private static List<String> findEmailsWithTargetName(List<List<String>> forms, int currentIdx) {
        List<String> notifiedEmails = new ArrayList<>();

        List<String> currentForm = forms.get(currentIdx);
        String currentEmail = currentForm.get(0);
        String currentName = currentForm.get(1);

        if (!isValidEmail(currentEmail)) {
            return Collections.emptyList();
        }

        for (int len = currentName.length() - 1, i = 0; i < len; i++) {
            String target = currentName.substring(i, i + 2);
            notifiedEmails.addAll(findEmailsWithTargetName(forms, currentIdx, target));
        }

        if (!notifiedEmails.isEmpty()) {
            notifiedEmails.add(currentEmail);
        }

        return notifiedEmails;
    }

    private static List<String> findEmailsWithTargetName(List<List<String>> forms, int currentIdx, String target) {
        List<String> notifiedEmails = new ArrayList<>();

        for (int size = forms.size(), i = currentIdx + 1; i < size; i++) {
            List<String> comparedForm = forms.get(i);
            String comparedEmail = comparedForm.get(0);
            String comparedName = comparedForm.get(1);

            if (!isValidEmail(comparedEmail)) {
                continue;
            }

            if (RabinKarp.contains(comparedName, target)) {
                notifiedEmails.add(comparedEmail);
            }
        }

        return notifiedEmails;
    }

    private static boolean isValidEmail(String email) {
        int atIdx = email.indexOf("@");
        if (atIdx == -1) {
            return false;
        }

        String domain = email.substring(atIdx + 1);
        if (!domain.equals("email.com")) {
            return false;
        }

        return (11 <= email.length()) && (email.length() < 20);
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

        if ((hashValueOfSrc == hashValueOfTarget)
                && isSame(src, 0, target, 0, lengthOfTarget)) {
            return true;
        }

        for (int i = lengthOfTarget; i < lengthOfSrc; i++){
            hashValueOfSrc = hashValueOfSrc * POW + src.charAt(i);
            hashValueOfSrc -= src.charAt(i - lengthOfTarget) * cachedPow;

            if ((hashValueOfSrc == hashValueOfTarget)
                    && isSame(src, i - lengthOfTarget + 1, target, 0, lengthOfTarget)) {
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