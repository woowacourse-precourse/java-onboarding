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
        List<String> prevForm = forms.get(prev);
        String nickname = prevForm.get(NICKNAME);
        List<String> SubNicknames = getSubNicknames(nickname);

        for (int next = prev + 1; next < forms.size(); next++) {
            List<String> nextForm = forms.get(next);
            String compareNickname = nextForm.get(NICKNAME);
            if (isDeduplication(SubNicknames, compareNickname)) {
                emails.add(prevForm.get(EMAIL));
                emails.add(nextForm.get(EMAIL));
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
