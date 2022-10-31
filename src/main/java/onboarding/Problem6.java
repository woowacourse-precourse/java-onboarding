package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashSet<String> email = new HashSet<>();

        int len = forms.size()-1;

        // 마지막 사람은 확인하지 않음
        for (int i=0; i<len-1;i++){

            // 선택한 사람
            String name = forms.get(i).get(1);

            // 닉네임이 한글자라면 건너뜀
            int nameSize = name.length();
            if (nameSize < 2) {
                break;
            }

            // 선택한 사람의 다음 사람부터 확인
            for (int t = i + 1; t < len; t++) {
                // 두 글자씩 잘라서
                for (int j=0; j<nameSize-2;j++){
                    String subName = name.substring(j,j+2);
                    // 연속된 두 글자가 포함되면 이메일 대상에 포함/루프 탈출
                    if (forms.get(t).get(1).contains(subName)) {
                        email.add(forms.get(t).get(0));
                        email.add(forms.get(i).get(0));
                        break;
                    }
                }
            }
        }

        ArrayList<String> answer = new ArrayList<>(email);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
