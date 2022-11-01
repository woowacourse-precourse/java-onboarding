package onboarding;

import java.util.*;

public class Problem6 {
    private static void addOrUpdate(String key, String email, Map<String, Set<String>> letterMap, TreeSet<String> result) {
        if(letterMap.containsKey(key)) {
            Set<String> emailList = letterMap.get(key);
            emailList.add(email);
            emailList.forEach(otherEmail -> result.add(otherEmail));
        }
        else {
            letterMap.put(key, new HashSet<>());
            letterMap.get(key).add(email);
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        TreeSet<String> result = new TreeSet<>();
        Map<String, Set<String>> letterMap = new HashMap<>(); // 2 letter to email

        for(List<String> form: forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            for(int i = 1; i < nickname.length(); ++i) {
                addOrUpdate(nickname.substring(i-1, i+1), email, letterMap, result);
            }
        }
        return List.copyOf(result);
    }
}
