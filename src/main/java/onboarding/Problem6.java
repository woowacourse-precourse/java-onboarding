package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    static final Integer EMAIL = 0;
    static final Integer NICKNAME = 1;
    static final Integer MINIMUM_LENGTH = 2;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> alreadyCheckedNicknames = new ArrayList<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            String pivotEmail = forms.get(i).get(EMAIL);
            String pivotNickname = forms.get(i).get(NICKNAME);

            // nickname이 두 글자(MINIMUM_LENGTH)보다 짧으면, 제한사항에 따라 닉네임이 겹칠 일 없음
            if (pivotNickname.length() < MINIMUM_LENGTH) {
                continue;
            }

            // nickname으로 만들 수 있는 모든 가능성
            // 세 글자가 겹침 -> 두 글자는 당연히 겹침 => 연속된 두 글자에 대해서만 검증
            List<String> subNicknames = getSubNicknames(pivotNickname);

            for (String subNickname : subNicknames) {
                // 이미 검증한 subnickname이 아니면 검증 시작
                if (!alreadyCheckedNicknames.contains(subNickname)) {
                    // 기준 nickname 이후의 크루들에 대해
                    for (int j = i + 1; j < forms.size(); j++) {
                        String comparedEmail = forms.get(j).get(EMAIL);
                        String comparedNickname = forms.get(j).get(NICKNAME);

                        // 크루의 닉네임이 기준 닉네임과 겹친다면
                        if (comparedNickname.contains(subNickname)) {
                            // 이전에 다른 이유로 겹치지 않았다면 정답에 추가
                            if (!answer.contains(comparedEmail)) {
                                answer.add(comparedEmail);
                            }
                            if (!answer.contains(pivotEmail)) {
                                answer.add(pivotEmail);
                            }
                        }
                    }
                    // 이번에 검증한 서브 닉네임은 다음에 검증하지 않음
                    alreadyCheckedNicknames.add(subNickname);
                }
            }
        }

        answer.sort(String.CASE_INSENSITIVE_ORDER);

        return answer;
    }

    private static List<String> getSubNicknames(String name) {
        List<String> subNicknames = new ArrayList<>();

        for (int i = 0; i <= name.length() - MINIMUM_LENGTH; i++) {
            subNicknames.add(name.substring(i, MINIMUM_LENGTH + i));
        }

        return subNicknames;
    }
}
