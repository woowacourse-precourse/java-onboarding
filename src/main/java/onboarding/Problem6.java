package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                if (compareString(forms.get(i).get(1), forms.get(j).get(1))) {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }
        return removeDuplicates(answer);
    }

    public static boolean compareString(String s1, String s2) {
        for (int i = 0; i < s1.length() - 1; i++) {
            if (s2.contains(s1.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }

    public static List<String> removeDuplicates(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            if (!newList.contains(s)) {
                newList.add(s);
            }
        }
        Collections.sort(newList);
        return newList;
    }
}
