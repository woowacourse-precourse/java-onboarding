package onboarding;

import java.util.*;

public class Problem6 {
    static List<List<String>> forms = new ArrayList<>();
    static Set<String> setResult = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                if (nameCheck(forms.get(i).get(1), forms.get(j).get(1))) {
                    setResult.add(forms.get(i).get(0));
                    setResult.add(forms.get(j).get(0));
                }
            }
        }
        List<String> result = new ArrayList<>(setResult);
        Collections.sort(result);
        return result;
    }

    static boolean nameCheck(String name1, String name2) {
        outLoop:
        for (int i = 0; i < name1.length() - 1; i++) {
            String subStr1 = name1.substring(i, i + 2);
            for (int j = 0; j < name2.length() - 1; j++) {
                String subStr2 = name2.substring(j, j + 2);
                if (subStr1.equals(subStr2)) {
                    return true;
                }
            }
        }
        return false;
    }

    static List<String> info(String email, String name) {
        List<String> user = new ArrayList<>();
        user.add(email);
        user.add(name);
        return user;
    }

}
