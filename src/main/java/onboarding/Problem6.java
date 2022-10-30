package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        //중복을 제거하기 위해 set 사용
        Set<String> set = new HashSet<>();
        int n = forms.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                String name1 = forms.get(i).get(1);
                String name2 = forms.get(j).get(1);
                if (hasDuplication(name1, name2)) {
                    addEmail(forms.get(i), set);
                    addEmail(forms.get(j), set);
                }
            }
        }
        //List로 변환후 정렬
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static void addEmail(List<String> form, Set<String> emailList) {
        emailList.add(form.get(0));

    }

    public static boolean hasDuplication(String name1, String name2) {
        int n1 = name1.length();
        int n2 = name2.length();

        for (int i = 0; i < n1 - 1; i++) {
            for (int j = 0; j < n2 - 1; j++) {
                if (findDuplication(name1, name2, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean findDuplication(String name1, String name2, int i, int j) {
        if (name1.charAt(i) == name2.charAt(j)) {
            return name1.charAt(i + 1) == name2.charAt(j + 1);
        }
        return false;
    }
}
