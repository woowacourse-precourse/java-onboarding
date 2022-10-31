package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer_set = new HashSet<String>();
        String name = "";
        String name_sub = "";
        for(int i = 0; i < forms.size(); i++) {
            name = forms.get(i).get(1); // i번째 학생의 이름을 저장
            for(int j = 0; j < name.length() - 1 ; j++) {
                name_sub = name.substring(j, j + 2); // i번째 학생 이름의 j, j+1번째 문자 저장
                for(int k = i + 1 ; k < forms.size(); k ++) { // i+1번째 끝 학생까지 name_sub 와 겹치는 이름이 있는지 확인
                    if(forms.get(k).get(1).contains(name_sub)) {
                        answer_set.add(forms.get(i).get(0)); //겹치면 answer_set 에 i 번째 학생 이메일 추가
                        answer_set.add(forms.get(k).get(0)); //겹치면 answer_set 에 k번째 학생 이메일 추가
                    }
                }
            }

        }
        List<String> answer = new ArrayList<String>(answer_set);
        Collections.sort(answer);
        return answer;
    }
}
