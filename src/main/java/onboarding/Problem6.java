package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> nicknames = collectNicknames(forms);

        for (List<String> info : forms) {
            String email = info.get(0);
            String nickname = info.get(1);
            nicknames.remove(nickname);

            if (checkNickname(nickname, nicknames)) {
                answer.add(email);
            }
            nicknames.add(nickname);
        }
        answer = arrangeEmail(answer);
        return answer;
    }

    private static List collectNicknames(List<List<String>> name) {
        List<String> collection = new ArrayList<>();
        for (List target : name) {
            collection.add((String)target.get(1));
        }
        return collection;
    }
    private static boolean checkNickname(String name, List<String> comparedNames) {

        for (String target : comparedNames) {
            for (int i = 0; i < name.length() - 1; i++) {
                if (target.contains(name.substring(i, i + 2))) {
                    return true;
                }
            }
        }
        return false;
    }
    private static List<String> arrangeEmail(List<String> emails) {
        List<String> uniqueEmails = new ArrayList(new HashSet(emails));
        Collections.sort(uniqueEmails);
        return uniqueEmails;
    }
}
