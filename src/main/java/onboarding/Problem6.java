package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {

    public static HashMap<String, String> subsetList;
    public static HashSet<String> duplicateEmails;

    public static List<String> getDuplicateList(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);
            checkSubsetList(name, email);
        }
        return getDuplicateEmails();
    }

    private static List<String> getDuplicateEmails() {
    }

    private static void checkSubsetList(String name, String email) {
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getDuplicateList(forms);
        return answer;
    }
}
