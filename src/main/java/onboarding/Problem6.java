package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {

    public static HashMap<String, String> subsetList;
    public static HashSet<String> duplicateEmails;

    public static List<String> getDuplicateList(List<List<String>> forms) {
        subsetList = new HashMap<>();
        duplicateEmails = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);
            checkSubsetList(name, email);
        }
        return getDuplicateEmails();
    }

    private static List<String> getDuplicateEmails() {
        List<String> emails = new ArrayList<>(duplicateEmails);
        return emails;
    }

    private static void checkSubsetList(String name, String email) {
        String subset[] = new String[name.length() - 1];
        for (int i = 0; i < name.length() - 1; i++) {
            subset[i] = name.substring(i, i + 2);
        }
        for (int i = 0; i < subset.length; i++) {
            if(subsetList.containsKey(subset[i])) {
                if(subsetList.get(subset[i]).equals(email)) {
                    continue;
                }
                else {
                    duplicateEmails.add(subsetList.get(subset[i]));
                    duplicateEmails.add(email);
                }
            }
            else {
                subsetList.put(subset[i], email);
            }
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getDuplicateList(forms);
        return answer;
    }
}
