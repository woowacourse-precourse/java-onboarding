package onboarding;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        String name = forms.get(0).get(1);
        Set<String> twoOfName = new HashSet<>();
        for (int i = 0; i < name.length() - 1; i++) {
            twoOfName.add(name.substring(i, i + 1));
        }
        List<String> answer = List.of("answer");
        return answer;
    }

    public static Set<String> getPattern(String name) {
        Set<String> twoOfName = new HashSet<String>();
        for (int i = 0; i < name.length() - 1; i++) {
            twoOfName.add(name.substring(i, i + 2));
        }
        return twoOfName;
    }
    public static boolean search(String parent, Set<String> twoOfName) {
        Iterator<String> it = twoOfName.iterator();
        boolean isExsist = false;
        Labal:
        while (it.hasNext()) {
            for (int i = 0; i < parent.length() - 1; i++) {
                if (parent.substring(i, i + 2).equals(it.next())) {
                    isExsist = true;
                    break Labal;
                }
            }
        }
        return isExsist;
    }



}
