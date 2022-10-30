package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return User.getUserDuplicatedNickName(forms);
    }
}

class User {
    static List<String> getUserDuplicatedNickName(List<List<String>> forms){
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size()-1; i++) {
            int cnt = 0;
            String firstUserName = forms.get(i).get(1);
            for (int j = i+1; j < forms.size(); j++) {
                String comparedUser = forms.get(j).get(1);
                if(isContains(firstUserName, comparedUser)){
                    answer.add(forms.get(j).get(0));
                    cnt++;
                }
            }
            if(cnt > 0)
                answer.add(forms.get(i).get(0));
        }
        return removeDuplicatedEmail(answer);
    }

    private static List<String> removeDuplicatedEmail(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    public static boolean isContains(String name1, String name2) {
        for (int i = 0; i < name1.length()-1; i++) {
        // 부분문자열 2개를 추출
            String substring = name1.substring(i, i + 2);
            if(name2.contains(substring))
                return true;
        }
        return false;
    }
}