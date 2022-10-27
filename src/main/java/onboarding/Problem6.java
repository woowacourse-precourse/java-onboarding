package onboarding;

import java.util.*;

public class Problem6 {
    private static List<String> split(String str) {
        List<String> ret = new ArrayList<>();

        for(int i = 0; i < str.length() - 1; i++)
            ret.add(str.substring(i, i + 2));

        return ret;
    }

    private static String overlap(HashMap<String, String> map, List<String> list) {
        for(String i : list) {
            if(map.containsKey(i))
                return i;
        }
        return "";
    }

    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> map = new HashMap<>();
        TreeSet<String> emails = new TreeSet<>();

        for(List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);

            List<String> list = split(name);

            String req = overlap(map, list);

            if(!req.isBlank()) {
                emails.add(email);
                emails.add(map.get(req));
                continue;
            }

            for(String i : list)
                map.put(i, email);
        }

        return new ArrayList<>(emails);
    }
}
