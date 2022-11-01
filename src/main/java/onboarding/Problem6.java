package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> getDuplicatedEmails(List<List<String>> forms) {
        List<String> keywords = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        HashSet<String> duplications = new HashSet<>();
        for (List<String> form: forms) {
            for (int i = 0; i + 1 < form.get(1).length(); i++) {
                String keyword = form.get(1).substring(i, i + 2);
                if(keywords.contains(keyword)) {
                    emails.add(form.get(0));
                    duplications.add(keyword);
                    break;
                }
                else {
                    keywords.add(keyword);
                }
            }
        }

        for (int i = 0; i + 1 < forms.get(0).get(1).length(); i++) {
            String keyword = forms.get(0).get(1).substring(i, i + 2);
            if (duplications.contains(keyword)) {
                emails.add(forms.get(0).get(0));
            }
        }

        HashSet<String> duplicatedEmails = new HashSet<>(emails);
        List<String> result = new ArrayList<>(duplicatedEmails);
        Collections.sort(result);

        return result;
    }
    public static List<String> solution(List<List<String>> forms) {
        return getDuplicatedEmails(forms);
    }
}
