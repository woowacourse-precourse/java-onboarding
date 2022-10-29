package onboarding;

import java.util.*;

public class Problem6 {
    private static final Map<String, Set<String>> subNicknames = new HashMap<>();
    public static void main(String[] args) {
        List<String> answer = Problem6.solution(List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워닝닝"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "엠제임마"),
                List.of("hhgg@email.com", "워니버니"),
                List.of("dasd@email.com", "버니룽띵"),
                List.of("asdas@email.com", "딩룽띵룽띵룽")
        ));

        for (String a : answer) {
            System.out.println(a);
        }
    }

    public static List<String> solution(List<List<String>> forms) {
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
        return nickname.substring(startIndex, startIndex + 2);
    }

    private static List<String> getCrewEmails() {
        Set<String> totalDuplicated = getTotalDuplicated();
        return null;
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
        return subNicknames.get(subNickName).size() >= 2;
    }
}
