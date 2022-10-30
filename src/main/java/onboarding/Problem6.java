package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getOverlapNicknameByTwoWords(forms);
        answer = getSortAndDeduplicationList(answer);
        return answer;
    }

    /**
     * 두 글자 이상인 닉네임중 연속 된 두 글자가 포함된 유저의 이메일 목록을 얻는다.
     *
     * @param forms 유저들의 정보
     * @return 신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 유저의 이메일 목록을 반환한다.
     */
    private static List<String> getOverlapNicknameByTwoWords(List<List<String>> forms) {
        // twoWordForms = {{이메일, 두 글자 이상의 문자}, ...}
        List<List<String>> twoWordForms = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        for (List<String> user : forms) {
            String nickname = user.get(1);
            if (nickname.length() != 1) {
                for (int i = 0; i <= nickname.length() - 2; i++) {
                    String twoWord = nickname.substring(i, i + 2);
                    for (List<String> twoWordForm : twoWordForms) {
                        if (twoWordForm.contains(twoWord)) {
                            emails.add(user.get(0));
                            emails.add(twoWordForm.get(0));
                        }
                    }
                    twoWordForms.add(new ArrayList<>(List.of(user.get(0), twoWord)));
                }
            }
        }
        return emails;
    }

    private static List<String> getSortAndDeduplicationList(List<String> emails) {
        emails = emails.stream().distinct().collect(Collectors.toList());
        Collections.sort(emails);
        return emails;
    }
}
