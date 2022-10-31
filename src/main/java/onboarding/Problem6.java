package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> slice_list = slice_count(forms);
        return email_finder(forms, slice_list);
    }

    public static List<String> slice_count(List<List<String>> forms) {
        Map<String, Integer> slice_counter = new HashMap<>();
        List<String> slice_list = new ArrayList<>();

        for (List<String> form : forms) {
            String name = form.get(1);
            int len = name.length();

            for (int i = 2; i <= len; i++) {
                String slice = name.substring(i - 2, i);
                slice_counter.put(slice, slice_counter.getOrDefault(slice, 0) + 1);
            }
        }

        for (String key : slice_counter.keySet()) {
            if (slice_counter.get(key) > 1) {
                slice_list.add(key);
            }
        }
        return slice_list;
    }

    public static List<String> email_finder(List<List<String>> forms, List<String> slice_list) {
        Set<String> set = new HashSet<String>();

        for (List<String> form : forms) {
            for (String slice : slice_list) {
                if (form.get(1).contains(slice))
                    set.add(form.get(0));
            }
        }

        List<String> email_list = new ArrayList<String>(set);
        Collections.sort(email_list);
        return email_list;
    }
}
