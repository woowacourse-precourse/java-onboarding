package onboarding;

import java.util.*;

public class Problem6 {
    private static final Map<String, Set<String>> subNicknames = new HashMap<>();
    public static void main(String[] args) {
        Problem6.solution(List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        ));
    }
    public static List<String> solution(List<List<String>> forms) {

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            splitNickname(email, nickname);
        }

        return Arrays.asList("", "");
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
}
