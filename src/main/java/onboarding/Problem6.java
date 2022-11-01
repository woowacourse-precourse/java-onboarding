package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> alertNickName = new HashSet<>();
        Map<String, List<String>> nickAndForm = new HashMap<>();
        List<String> result = null;

        for (List<String> form : forms) {
            String nickName = form.get(1);

            makeSubNick(alertNickName, nickAndForm, form, nickName);
        }

        result = new ArrayList<>(alertNickName);
        Collections.sort(result);
        return result;
    }

    private static void makeSubNick(Set<String> alertNickName, Map<String, List<String>> nickAndForm, List<String> form, String nickName) {
        for (int i = 0; i < nickName.length(); i++) {
            for (int j = i; j < nickName.length(); j++) {
                if (j - i >= 1) {
                    String subName = nickName.substring(i, j + 1);

                    findDupSubNick(alertNickName, nickAndForm, form, subName);
                    nickAndForm.put(subName, form);
                }
            }
        }
    }

    private static void findDupSubNick(Set<String> alertNickName, Map<String, List<String>> nickAndForm, List<String> form, String subName) {
        if (nickAndForm.containsKey(subName)) {
            verifyDupSubNick(alertNickName, nickAndForm, form, subName);
        }
    }

    private static void verifyDupSubNick(Set<String> alertNickName, Map<String, List<String>> nickAndForm, List<String> form, String subName) {
        for (Map.Entry<String, List<String>> entry : nickAndForm.entrySet()) {
            if (entry.getKey().equals(subName) && !entry.getValue().get(0).equals(form.get(0))) {
                addAlert(alertNickName, form, entry);
            }
        }
    }

    private static void addAlert(Set<String> alertNickName, List<String> form, Map.Entry<String, List<String>> entry) {
        alertNickName.add(entry.getValue().get(0));
        alertNickName.add(form.get(0));
    }
}
