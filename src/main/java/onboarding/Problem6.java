package onboarding;

import java.util.*;

public class Problem6 {
    private static HashMap<String, String> chunk_Email = new HashMap<>();
    private static HashSet<String> emails = new HashSet<>();

    public static List<String> solution(List<List<String>> forms){

        for (List<String> form : forms) {
           String email = form.get(0);
           String nickName = form.get(1);
           checkDuplication(email, nickName);
        }

        List<String> answer = new ArrayList<>(emails);
        Collections.sort(answer);
        return answer;
    }
}
