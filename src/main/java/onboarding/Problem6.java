package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        // 리스트 내 1번 index를 추출을 위한 반복문
        for (int i = 0; i < forms.size(); i++) {
            // 이름의 글자수로 반복문
            if ((forms.get(i).get(1)).length() > 1) {
                for (int j = 0; j < (forms.get(i).get(1)).length() - 1; j++) {
                    // 다른 이름과 비교를 위한 반복문
                    for (int k = 0; k < forms.size(); k++) {
                        // 이름별 두글자씩 잘라 다른 이름과 비교
                        if ((forms.get(k).get(1)).contains((forms.get(i).get(1)).substring(j, j + 2)) && k != i) {
                            // 배열에 이메일 추가
                            answer.add(forms.get(k).get(0));
                        }
                    }
                }
            }
        }
        // 배열의 중복 제거 및 오름차순 정렬
        answer = answer.stream().distinct().sorted().collect(Collectors.toList());
        return answer;
    }
}
