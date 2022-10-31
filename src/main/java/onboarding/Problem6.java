package onboarding;

import java.util.*;

public class Problem6 {
    public static Map<String, Integer> getDuplCheckDict(List<List<String>> forms) {
        Map<String, Integer> duplDict = new HashMap<String, Integer>();
        forms.forEach(form -> {
            for (int j = 0; j < getNickname(form).length() - 1; j++) {
                if (duplDict.containsKey(getNickname(form).substring(j, j + 2))) {
                    int cnt = duplDict.get(getNickname(form).substring(j, j + 2));
                    duplDict.put(getNickname(form).substring(j, j + 2), cnt + 1);
                } else {
                    duplDict.put(getNickname(form).substring(j, j + 2), 1);
                }
            }
        });
        return duplDict;
    }

    public static List<String> getDuplEmailList(List<List<String>> forms, Map<String, Integer> duplCheckDict) {
        List<String> duplEmailList = new ArrayList<String>();
        duplCheckDict.keySet().forEach(duplStr -> {
            if (duplCheckDict.get(duplStr) != 1) {
                forms.forEach(form -> {
                    if (getNickname(form).contains(duplStr) == true) {
                        duplEmailList.add(getEmail(form));
                    }
                });
            }
        });
        Collections.sort(duplEmailList);
        return new ArrayList<String>(new HashSet(duplEmailList));
    }
    public static String getEmail(List<String> form) {
        return form.get(0);
    }

    public static String getNickname(List<String> form) {
        return form.get(1);
    }
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> duplCheckDict = getDuplCheckDict(forms);
        List<String> duplEmailList = getDuplEmailList(forms, duplCheckDict);
        return duplEmailList;
    }
}
