package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static HashSet<String> duplicateEmailList;
    public static HashMap<String,String> subsetInfo;
    public static List<String> checkDuplicateName(List<List<String>> forms) {
        duplicateEmailList = new HashSet<>();
        subsetInfo = new HashMap<>();

        for(int index = 0; index < forms.size(); index ++) {
            String email = forms.get(index).get(0);
            String name = forms.get(index).get(1);

            checkNameSubsetDuplicate(name,email);
        }

        List<String> answer = duplicateEmailList.stream()
                .sorted()
                .collect(Collectors.toList());

        return answer;
    }
    public static void checkNameSubsetDuplicate(String name, String email) {
        for(int index = 0; index < name.length() - 1; index++) {
            String key = name.substring(index,index+2);
            checkSubsetExist(key,email);
            subsetInfo.put(key,email);
        }
    }
    public static void checkSubsetExist(String key,String email) {
        if(subsetInfo.containsKey(key)) {
            inputDuplicateEmail(key,email);
        }
    }
    public static void inputDuplicateEmail(String key, String email) {
        String subsetEmail = subsetInfo.get(key);
        if(subsetEmail.equals(email) == false) {
            duplicateEmailList.add(email);
            duplicateEmailList.add(subsetEmail);
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = checkDuplicateName(forms);
        return answer;
    }
}
