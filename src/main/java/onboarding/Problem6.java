package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    private static Map<String,List<String>> nicknameMap = new HashMap<>();
    private static Set<String> emailSet = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void addEmailSet(List<String> emailList) {
        for(String email : emailList) {
            emailSet.add(email);
        }
    }





}
