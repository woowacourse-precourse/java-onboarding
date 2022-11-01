package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> set = new HashSet();
        int size = forms.size();

        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                List<String> form1 = forms.get(i);
                List<String> form2 = forms.get(j);

                if(hasDuplication(form1.get(1), form2.get(1))) {
                    set.add(form1.get(0));
                    set.add(form2.get(0));
                }
            }
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        return list;
    }

    static boolean hasDuplication(String name1, String name2) {
        int size = name1.length();

        for(int i = 0; i < size - 1; i++) {
            String twoWords = name1.substring(i, i + 2);

            if(name2.contains(twoWords)) {
                return true;
            }
        }

        return false;
    }
}
