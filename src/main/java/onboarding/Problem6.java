package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        String email = "";
        String name = "";
        String sub = "";
        ArrayList<String> list;

        for (List<String> form : forms) {
            email = form.get(0);
            name = form.get(1);
            for (int i = 0; i < name.length() - 1; i++) {
                sub = name.substring(i, i + 2);
                list = new ArrayList<>();
                if (map.containsKey(sub)) {
                    list = map.get(sub);
                }
                list.add(email);
                map.put(sub, list);
            }
        }

        for (ArrayList<String> values : map.values()) {
            if (values.size() > 1) {
                answer.addAll(values);
            }
        }

        TreeSet<String> arr = new TreeSet<>(answer);
        answer = new ArrayList<>(arr);

        return answer;
    }
}
