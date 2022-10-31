package onboarding;


import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> email = new HashSet<String>();
        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                if (search(forms.get(j).get(1), getPattern(forms.get(i).get(1)))) {
                    email.add(forms.get(i).get(0));
                    email.add(forms.get(j).get(0));
                }
            }
        }
        List<String> answer = sort(email);
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
            String check = it.next();
            if (parent.length() == 1) {
                break;
            }
            for (int i = 0; i < parent.length() - 1; i++) {
                if (parent.substring(i, i + 2).equals(check)) {
                    isExsist = true;
                    break Labal;
                }
            }
        }
        return isExsist;
    }

    public static List<String> sort(Set<String> email) {
        List<String> a = new ArrayList<>(email);
        Collections.sort(a);
        return a;
    }
}
