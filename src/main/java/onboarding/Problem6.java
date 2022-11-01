package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // 최대 10000번 반복
        for (int i = 0; i < forms.size(); i++){
            // 닉네임이 한 글자 이하라면 넘어감
            if (forms.get(i).get(1).length() <= 1)
                continue;

            // 최대 19번 반복
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++){
                String target = forms.get(i).get(1).substring(j, j + 2);    // 2자리 이상 겹치면 중복 -> 2자리만 겹쳐도 중복
                //System.out.println(target);
                // 최대 10000번 반복
                for (int k = 0; k < forms.size(); k++){
                    // 비교하려는 닉네임이 한 글자 이하 -> 넘어감
                    if (forms.get(k).get(1).length() <= 1)
                        continue;
                    // 본인과 비교하는 경우 -> 넘어감
                    else if (forms.get(k).get(0).equals(forms.get(i).get(0))
                            && forms.get(k).get(1).equals(forms.get(i).get(1)))
                        continue;
                    // 문자열과 부분 문자열 비교 -> 중복 확인 됐을 때
                    else if (forms.get(k).get(1).contains(target)){
                        if (!answer.contains(forms.get(k).get(0)))
                            answer.add(forms.get(k).get(0));
                    }
                    // 그 외의 경우 -> 넘어감
                    else{
                        continue;
                    }
                }
            }
        }
        Collections.sort(answer);

        return answer;
    }
}
