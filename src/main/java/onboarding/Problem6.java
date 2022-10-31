package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        if (isException(forms)) throw new RuntimeException("잘못된 인자입니다.");

        Map<String, List<String>> emailMap = getDuplicateEmail(forms);
        List<List<String>> emailLists = emailMap.values().stream()
                .filter(list -> list.size() > 1).collect(Collectors.toList());

        List<String> emailList = getDistinctList(emailLists);
        Collections.sort(emailList);

        return emailList;
    }

    private static Boolean isException(List<List<String>> forms) {
        if (forms.size() < 1 || forms.size() > 1000000) return true;
        return forms.stream()
                .anyMatch(form ->
                        (form.get(1).length() < 1 || form.get(1).length() > 20) ||
                                (form.get(0).length() < 11 || form.get(0).length() > 20));
    }

    private static void setEmailMap(String stringToken, Map<String, List<String>> emailMap, String email) {
        if (emailMap.get(stringToken) == null) {
            emailMap.put(stringToken, new ArrayList<>() {{
                add(email);
            }});
            return;
        }
        emailMap.get(stringToken).add(email);
    }

    private static void nicknameSplitByTwo(String nickname, Map<String, List<String>> emailMap, String email) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            setEmailMap(nickname.substring(i, i + 2), emailMap, email);
        }
    }

    private static Map<String, List<String>> getDuplicateEmail(List<List<String>> forms) {
        Map<String, List<String>> emailMap = new HashMap<>();
        for (List<String> form : forms) {
            nicknameSplitByTwo(form.get(1), emailMap, form.get(0));
        }
        return emailMap;
    }

    private static List<String> getDistinctList(List<List<String>> list) {
        Set<String> set = new HashSet<>();
        for (List<String> stringList : list) {
            for (String string : stringList) {
                set.add(string);
            }
        }
        return new ArrayList<>(set);
    }
}
