package onboarding;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Hashtable<String, String> table = new Hashtable<>();
        TreeSet<String> set = new TreeSet<>();

        for (List<String> form : forms) {
            for (int i = 1; form.get(1).length() > i; i++) {
                if (table.get(form.get(1).substring(i - 1, i + 1)) == null) {

                    table.put(form.get(1).substring(i - 1, i + 1), form.get(0));
                } else {
                    set.add(form.get(0));
                    set.add(table.get(form.get(1).substring(i - 1, i + 1)));
                }
            }
        }
        return new ArrayList<>(set);
    }
}

