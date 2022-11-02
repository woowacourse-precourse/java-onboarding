package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {

    static HashSet<String> mailSet = new HashSet<String>();
    static HashMap<String, String> mailMappedBySubNickname = new HashMap<String, String>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        for (List<String> form : forms) {
            checkMapped(form);
        }
        return answer;
    }

    private static void checkMapped(List<String> form) {
        String email = form.get(0);
        String nickname = form.get(1);
        for (int i = 0; i < nickname.length() - 1; i++) {
            String subNickname = nickname.substring(i, i + 2);
            mapDuplication(email, subNickname);
        }
    }

    private static void mapDuplication(String email, String subNickname) {
        mailMappedBySubNickname.put(subNickname, email);
    }
}
