package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getDuplicateEmail(forms);
        return answer;
    }

    private static List<String> getDuplicateEmail(List<List<String>> forms){

        HashSet<String> emails = new HashSet<>();
        Map<String, String> nickNameMap = new HashMap<>();
        for (List<String> form : forms){
            String targetName = form.get(1);
            String targetEmail = form.get(0);
            for (int j = 0; j < targetName.length() - 1; j++) {
                String key = targetName.substring(j, j+2);
                if(nickNameMap.containsKey(key)){
                    String duplicateEmail = nickNameMap.get(key);
                    emails.add(duplicateEmail);
                    emails.add(targetEmail);
                }
                nickNameMap.put(key, targetEmail);
            }
        }
        List<String> result = sortEmail(emails);
        return result;
    }

    private static List<String> sortEmail(HashSet<String> emails){
        List<String> result = emails.stream()
                .sorted()
                .collect(Collectors.toList());
        return result;
    }


}
