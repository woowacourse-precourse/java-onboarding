package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 기능 목록
 * 1. 중복 비교를 위한 form과 해당 닉네임에 포함된 두글자 모음 리스트 구현
 * 2. 다른 form을 탐색하면서 중복된 닉네임에 해당하는 이메일 추가
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        boolean[] isSelected = new boolean[forms.size()];

        for (int i = 0; i < forms.size(); i++) {

            if (isSelected[i]) {
                continue;
            }

            List<String> standardForm = forms.get(i);
            String standardFormEmail = standardForm.get(0);
            String standardFormNickname = standardForm.get(1);

            List<String> twoLetters = new ArrayList<>();

            for (int j = 0; j < standardFormNickname.length() - 1; j++) {
                twoLetters.add(standardFormNickname.substring(j, j + 2));
            }

            for (int j = 0; j < forms.size(); j++) {
                boolean isDuplicate = false;

                for (String letter : twoLetters) {

                    List<String> nextForm = forms.get(j);
                    String nextFormEmail = nextForm.get(0);
                    String nextFormNickname = nextForm.get(1);

                    // 기준이랑 문자열이 아예 같으면 continue
                    // 선택 됐는지 체크하기
                    if (isSelected[j] || standardFormNickname == nextFormNickname) {
                        break;
                    }

                    if (nextFormNickname.contains(letter)) {
                        answer.add(nextFormEmail);
                        isDuplicate = true;
                        isSelected[j] = true;
                    }
                }

                if (isDuplicate && !isSelected[i]) {
                    answer.add(standardFormEmail);
                    isSelected[i] = true;
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
