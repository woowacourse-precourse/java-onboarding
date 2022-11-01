package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        return checkDup(forms);

    }

    public static List<String> checkDup(List<List<String>> forms){
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<String>();

        // for 문을 돌며 이용자를 하나씩 탐색
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);

            // 연속된 닉네임 탐색을 위해 sub_name으로 분리
            for (int j = 0; j < name.length() - 1; j++) {
                String sub_name = name.substring(j, j + 2);

                // 다른 이용자가 sub_name을 포함한 닉네임을 사용하는지 탐색
                for (int k = i ; k < forms.size(); k++) {
                    if (forms.get(j).get(1).contains(sub_name)){
                        set.add(forms.get(i).get(0));
                    }
                }
            }
        }
            // 중복 제거를 위해 set으로 반환.
            return new ArrayList<>(set);
        }

}
