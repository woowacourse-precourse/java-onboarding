package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> duplicateSet = new HashSet<>(); // 닉네임 글자 목록
        HashSet<String> tmp = new HashSet<>(); // 닉네임 중 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자 이메일 임시 목록
        for (List<String> form : forms) {
            for (int j = 0; j < form.get(1).length() - 1; j++) {
                if (duplicateSet.contains(form.get(1).substring(j, j + 2))) // 같은 글자 포함되는 경우
                    tmp.add(form.get(0));
                else // 같은 글자 포함되지 않는 경우
                    duplicateSet.add(form.get(1).substring(j, j + 2));
            }
        }
        for (int j = 0; j < forms.get(0).get(1).length() - 1; j++) { // 맨 처음 지원자에 대해 다시 중복 여부 체크
            if (duplicateSet.contains(forms.get(0).get(1).substring(j, j + 2)))
                tmp.add(forms.get(0).get(0));
        }

        List<String> answer = new ArrayList<>(List.copyOf(tmp));
        Collections.sort(answer);
        return answer;
    }
}
