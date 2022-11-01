package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        for (int i = 0; i < forms.size() - 1; ++i) {
            // 비교 기준점이 될 지원자의 정보
            List<String> mainInfor = forms.get(i);
            String mainEmail = mainInfor.get(0);
            String mainName = mainInfor.get(1);

            for (int j = 0; j < mainName.length() - 1; ++j) {
                // 비교할 문자열
                String strToCompare = mainName.substring(j, j + 2);

                for (int k = i + 1; k < forms.size(); ++k) {
                    // 기준이 되는 지원자의 뒤 순서에 오는 지원자들의 닉네임 검사
                    List<String> otherInfor = forms.get(k);
                    String otherEmail = otherInfor.get(0);
                    String otherName = otherInfor.get(1);

                    if (otherName.contains(strToCompare)) {
                        // 중복 시 추가 안함
                        if (!answer.contains(mainEmail)) {
                            answer.add(mainEmail);
                        }
                        if (!answer.contains(otherEmail)) {
                            answer.add(otherEmail);
                        }
                    }
                }
            }
        }

        // 오름차순으로 정렬
        Collections.sort(answer);

        return answer;
    }
}
