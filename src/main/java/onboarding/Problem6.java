package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    private static Map<String,Set<String>> nicknameMap = new HashMap<>();
    private static Set<String> emailSet = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void addPartOfNickToMap(String partOfNickname, String email) {
        Set<String> newEmailSet= new HashSet<>();
        newEmailSet.add(email);
        nicknameMap.put(partOfNickname, newEmailSet);
    }

    private static void addEmailSet(Set<String> newEmailSet) {
        emailSet.addAll(newEmailSet);
    }





}
