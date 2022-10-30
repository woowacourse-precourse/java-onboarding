package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> emails = new ArrayList<>(compareAllName(forms));
        Collections.sort(emails);
        return emails;
    }

    private static boolean isSimilar(String name1, String name2) {
        for (int i = 0; i < name1.length() - 1; i++) {
            if (name2.contains(name1.substring(i, i+2)))
                return true;
        }

        return false;
    }

    private static Set<String> compareAllName(List<List<String>> forms) {
        Set<String> emails = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String srcEmail = forms.get(i).get(0);
            String srcName = forms.get(i).get(1);
            for (int j = i+1; j < forms.size(); j++) {
                String targetEmail = forms.get(j).get(0);
                String targetName = forms.get(j).get(1);
                if (srcEmail.equals(targetEmail)) continue;
                if (isSimilar(srcName, targetName)) {
                    emails.add(srcEmail);
                    emails.add(targetEmail);
                }
            }
        }
        return emails;
    }
}
