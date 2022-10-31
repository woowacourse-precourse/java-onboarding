package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    private static final int LETTERS = 2;
    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        return getEmails(forms);
    }

    public static List<String> getEmails(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();

        for (int prev = 0; prev < forms.size(); prev++) {
            setEmails(forms, emails, prev);
        }

        emails = deduplication(emails);
        Collections.sort(emails);

        return emails;
    }

    private static void setEmails(List<List<String>> forms, List<String> emails, int prev) {
        String nickname = forms.get(prev).get(NICKNAME);
        List<String> SubNicknames = getSubNicknames(nickname);

        for (int next = prev + 1; next < forms.size(); next++) {
            String compareNickname = forms.get(next).get(NICKNAME);
            if (isDeduplication(SubNicknames, compareNickname)) {
                emails.add(forms.get(prev).get(EMAIL));
                emails.add(forms.get(next).get(EMAIL));
                break;
            }
        }
    }

    private static boolean isDeduplication(List<String> SubNicknames, String compareNickname) {
        for (String SubNickname : SubNicknames) {
            if (compareNickname.contains(SubNickname)) {
                return true;
            }
        }

        return false;
    }

    private static List<String> getSubNicknames(String nickname) {
        List<String> subNicknames = new ArrayList<>();
        for (int i = 0; i <= nickname.length() - LETTERS; i++) {
            subNicknames.add(nickname.substring(i, i + LETTERS));
        }

        return subNicknames;
    }

    private static List<String> deduplication(List<String> emails) {
        HashSet<String> hashSet = new HashSet<>(emails);
        return new ArrayList<>(hashSet);
    }
}
