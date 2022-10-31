package onboarding;

import java.util.*;

public class Problem6 {
    static HashMap<String, String> formsMap = new HashMap<>();
    static HashSet<String> answerSet = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        initFormsMap(forms);
        trimName();
        sortEmailSet(answer);

        return answer;
    }

    private static void initFormsMap(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);

            formsMap.put(name, email);
        }
    }

    private static void trimName() {
        for (String name : formsMap.keySet()) {
            int nameLength = name.length();

            for (int trim = 2; trim < nameLength; trim++) {
                for (int i = 0; i < nameLength - trim+1; i++) {
                    String trimmedName = name.substring(i, i + trim);//error
                    for (String nameInSet : formsMap.keySet()) {
                        if (nameInSet.contains(trimmedName) && !nameInSet.equals(name)) {
                            answerSet.add(formsMap.get(nameInSet));
                        }
                    }
                }
            }
        }
    }

    private static List<String> sortEmailSet(List<String> rtnList) {
        for (String name : answerSet) {
            rtnList.add(name);
        }
        Collections.sort(rtnList);

        return rtnList;
    }
}
