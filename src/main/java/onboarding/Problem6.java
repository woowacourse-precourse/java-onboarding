package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Problem6 p6 = new Problem6();
        return p6.getEmailOfOverlap(forms);
    }

    private List<String> getEmailOfOverlap(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                String name1 = forms.get(i).get(1);
                String name2 = forms.get(j).get(1);

                List<String> stringTokens1 = getStringTokens(name1);
                List<String> stringTokens2 = getStringTokens(name2);

                if (isOverlapped(stringTokens1, stringTokens2)) {
                    if (!isAlreadyInList(result, forms.get(i).get(0))) {
                        result.add(forms.get(i).get(0));
                    }

                    if (!isAlreadyInList(result, forms.get(j).get(0))) {
                        result.add(forms.get(j).get(0));
                    }
                }
            }
        }
        result = sortEmails(result);
        return result;
    }

    private List<String> sortEmails(List<String> emails) {
        return emails.stream().map(e -> e.split("@")[0]).sorted().map(e -> e + "@email.com").collect(Collectors.toList());
    }

    private boolean isAlreadyInList(List<String> list, String target) {
        return list.contains(target);
    }

    private boolean isOverlapped(List<String> l1, List<String> l2) {
        for (String element : l1) {
            if (l2.contains(element)) {
                return true;
            }
        }
        return false;
    }

    private HashMap<String, String> getHashMappedForm(List<List<String>> forms) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> info : forms) {
            map.put(info.get(0), info.get(1));
        }
        return map;
    }

    private List<String> getStringTokens(String word) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < word.length() - 1; i++) {
            String temp = Character.toString(word.charAt(i)) + Character.toString(word.charAt(i + 1));
            result.add(temp);
        }
        return result;
    }
}
