package onboarding;


import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> duplicatedEmails = getDuplicatedEmails(new HashMap<>(), forms);
        List<String> answer = new ArrayList<>();

        duplicatedEmails.values().stream().filter(s -> s.size() > 1).forEach(answer::addAll);
        return answer.stream().sorted().collect(Collectors.toList());
    }

    private static Map<String, List<String>> getDuplicatedEmails(HashMap<String, List<String>> duplicatedEmails, List<List<String>> forms) {
        for (List<String> form : forms) {
            String arr[] = form.get(1).split("");
            for (int i = 1; i < arr.length; i++) {
                String nickName = arr[i - 1] + arr[i];
                if (!duplicatedEmails.containsKey(nickName)) {
                    duplicatedEmails.put(nickName, new ArrayList<>());
                }
                duplicatedEmails.get(nickName).add(form.get(0));
            }
        }
        return duplicatedEmails;
    }
}

