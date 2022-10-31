package onboarding;

import java.util.*;

public class Problem6 {
    private static final int DUPLICATE_STANDARD = 2;
    private static final int SPLIT_INDEX_COUNT = 2;

    private static Map<String, Set<String>> subNicknames;

    public static List<String> solution(List<List<String>> forms) {
        subNicknames = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            splitNickname(email, nickname);
        }

        return getCrewEmails();
    }


    private static void splitNickname(String email, String nickname) {
        for (int i = 0 ; i < nickname.length() - 1 ; i++) {
            String subNickname = getSubNickname(nickname, i);
            Set<String> emails;

            if (!subNicknames.containsKey(subNickname)) {
                emails = new HashSet<>();
            } else {
                emails = subNicknames.get(subNickname);
            }

            emails.add(email);
            subNicknames.put(subNickname, emails);
        }
    }

    private static String getSubNickname(String nickname, int startIndex) {
        return nickname.substring(startIndex, startIndex + SPLIT_INDEX_COUNT);
    }

    private static List<String> getCrewEmails() {
        Set<String> totalDuplicated = getTotalDuplicated();
        List<String> crewEmails = new ArrayList<>(totalDuplicated);

        Collections.sort(crewEmails);

        return crewEmails;
    }

    private static Set<String> getTotalDuplicated() {
        Set<String> totalDuplicated = new HashSet<>();

        for (String subNickName : subNicknames.keySet()) {
            if (isDuplicated(subNickName)) {
                totalDuplicated.addAll(subNicknames.get(subNickName));
            }
        }

        return totalDuplicated;
    }

    private static boolean isDuplicated(String subNickName) {
        return subNicknames.get(subNickName).size() >= DUPLICATE_STANDARD;
    }
}
