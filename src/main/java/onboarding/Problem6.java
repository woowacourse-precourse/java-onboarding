package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //중복제거
        TreeSet<String> ans = new TreeSet<>();

        //1. 닉네임에서 연속된 2글자 추출
        //2. 다른 닉네임에 추출한 글자가 포함되면 ans에 이메일 넣음
        //3. 글자 포함된 닉네임이 있었다면 1.닉네임도 ans에 이메일 넣음
        for (int i = 0; i < forms.size(); i++) {
            String nickName = forms.get(i).get(1);
            for (int j = 0; j < nickName.length() - 1; j++) {
                String nameStr = nickName.substring(j, j + 2);
                for (int k = 0; k < forms.size(); k++) {
                    if (i == k) continue;
                    if (forms.get(k).get(1).contains(nameStr)) {
                        ans.add(forms.get(k).get(0));
                    }
                }
            }
        }
        List<String> answer = new ArrayList<>(ans);
        return answer;
    }
}
