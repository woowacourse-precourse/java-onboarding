package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //중복을 제거하기 위해 set 사용
        Set<String> set = new HashSet<>();
        int n = forms.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                List<String> form1 = forms.get(i);
                List<String> form2 = forms.get(j);
                if (hasDuplication(form1.get(1), form2.get(1))) {
                    set.add(form1.get(0));
                    set.add(form2.get(0));
                }
            }
        }
        //List로 변환후 정렬
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static boolean hasDuplication(String name1, String name2) {
        int n = name1.length();
        for (int i = 0; i < n - 1; i++) {
            //연속된 2글자씩 끊어서 중복여부 확인
            String twoWords = name1.substring(i, i + 2);
            if(name2.contains(twoWords)) return true;
        }
        return false;
    }
}
