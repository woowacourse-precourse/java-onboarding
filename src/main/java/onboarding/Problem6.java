package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, Integer> counter = makeCounter(forms);
        TreeSet<String> set = new TreeSet<>();

        for (List<String> form: forms) {
            String nickname = form.get(1);

            removePartialNickname(nickname, counter);
            if (isRestricted(nickname, counter)) {
                String emailDomain = form.get(0);
                int len = emailDomain.length();
                String email = emailDomain.substring(0, len - 10);
                set.add(email);
            }
            addPartialNickname(nickname, counter);
        }

        List<String> answer = new ArrayList<>();
        for (String email: set) {
            String emailDomain = email + "@email.com";
            answer.add(emailDomain);
        }
        return answer;
    }
    private static HashMap<String, Integer> makeCounter(List<List<String>> forms) {
        HashMap<String, Integer> counter = new HashMap<>();
        for (List<String> form: forms) {
            String nickname = form.get(1);
            addPartialNickname(nickname, counter);
        }
        return counter;
    }
    private static void addPartialNickname(String nickname, HashMap<String, Integer> counter) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String partialNickname = nickname.substring(i, i + 2);
            int count = counter.getOrDefault(partialNickname, 0);
            counter.put(partialNickname, count + 1);
        }
    }
    private static void removePartialNickname(String nickname, HashMap<String, Integer> counter) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String partialNickname = nickname.substring(i, i + 2);
            int count = counter.get(partialNickname);
            counter.put(partialNickname, count - 1);
        }
    }
    private static boolean isRestricted(String nickname, HashMap<String, Integer> counter) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String partialNickname = nickname.substring(i, i + 2);
            int count = counter.get(partialNickname);
            if (count > 0)
                return true;
        }
        return false;
    }
}