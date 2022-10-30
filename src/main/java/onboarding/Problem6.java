package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static final int LETTERS = 2;
    public static final int EMAIL = 0;
    public static final int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
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
        for (int next = prev + 1; next < forms.size(); next++) {
            String nickname = forms.get(prev).get(NICKNAME);
            String compareNickname = forms.get(next).get(NICKNAME);

            if (isDeduplication(nickname, compareNickname)) {
                emails.add(forms.get(prev).get(EMAIL));
                emails.add(forms.get(next).get(EMAIL));
                break;
            }
        }
    }

    private static boolean isDeduplication(String nickname, String compareNickname) {
        List<String> subStrings = getSubNicknames(nickname);

        for (String subString : subStrings) {
            return compareNickname.contains(subString);
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
