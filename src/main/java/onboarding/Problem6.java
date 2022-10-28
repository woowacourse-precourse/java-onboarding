package onboarding;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Collectors;


public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NAME = 1;

    private static final int MINIMUM_NAME_LENGTH = 2;

    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (List<String> form : forms) {

            String str = checkOverlabByMap(form.get(NAME), map);
            if (!str.isEmpty()) {
                set.add(str);
                set.add(form.get(EMAIL));
            }

            nameCaseInsertMap(form.get(NAME), form.get(EMAIL), map);
        }

        return set.stream().sorted().collect(Collectors.toList());
    }

    private static void nameCaseInsertMap(String name, String email, Map<String, String> map) {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            return;
        }

        map.put(name, email);

        for (int i = 1; i < name.length(); i++) {
            nameCaseInsertMap(name.substring(i), email, map);
            nameCaseInsertMap(name.substring(0, name.length() - i), email, map);
        }
    }

    private static String checkOverlabByMap(String name, Map<String, String> map) {
        Iterator<String> iter = map.keySet().iterator();

        while (iter.hasNext()) {
            String str = iter.next();
            if (name.contains(str)) {
                return map.get(str);
            }
        }

        return "";
    }
}
