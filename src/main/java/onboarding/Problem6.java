package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        String defaultDomain = "@email.com";
        HashMap<String, String> map = new HashMap<>();
        Set<String> set = new TreeSet<>();

        for (List<String> form : forms) {
            ArrayList<String> arrList = new ArrayList<>(form);
            String name = arrList.get(1);
            String mailAddress = arrList.get(0).split("@")[0];

            for (int j = 0; j < name.length() - 1; j++) {
                String namePart = name.substring(j, j + 2);

                if (map.containsKey(namePart)) {
                    set.add(map.get(namePart) + defaultDomain);
                    set.add(mailAddress + defaultDomain);
                    break;
                }

                map.put(namePart, mailAddress);
            }
        }

        List<String> answer = new ArrayList<>(set);
        return answer;
    }
}
