package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {

    private static final Map<String, String> nickNameMap = new HashMap<>();
    private static final HashSet<String> emails = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        addDuplicateEmailList(forms);
        List<String> answer = sortEmail(emails);
        return answer;
    }

    private static void addDuplicateEmailList(List<List<String>> forms){
        for (List<String> form : forms){
            String targetName = form.get(1);
            String targetEmail = form.get(0);
            for (int j = 0; j < targetName.length() - 1; j++) {
                String key = targetName.substring(j, j+2);
                if(isDuplicateName(key)){
                    addEmail(targetEmail,key);
                }
                nickNameMap.put(key, targetEmail);
            }
        }
    }

    private static List<String> sortEmail(HashSet<String> emails){
        List<String> result = emails.stream()
                .sorted()
                .collect(Collectors.toList());
        return result;
    }

    private static boolean isDuplicateName(String key){
        return nickNameMap.containsKey(key);
    }

    private static void addEmail(String targetEmail,String key){
        String OldDuplicateEmail = nickNameMap.get(key);
        emails.add(OldDuplicateEmail);
        emails.add(targetEmail);
    }
}
