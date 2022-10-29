package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 주의 사항
        // 1. 크루 인원은 1~10_000명
        // 2. 이메일 길이는 11~19자 (20자 미만.)
        // 3. @ 뒤에는 무조건 email.com 만 가능.
        // 4. 닉네임은 한글만 가능
        // 5. 닉네임 길이는 1~19자
        // 6. 마지막엔 오른차순 정렬. 중복X.

        Set<String> answer = new HashSet<>();
        if (forms.size() > 10_000 || forms.size() < 1)
            return new ArrayList<>();
        for (List formA : forms) {
            if (-1 == checkValidation(formA)) {
                return new ArrayList<>();
            }
            for (List formB : forms) {
                if (formA == formB)
                    continue;
                String formAName = formA.get(1).toString();
                String formBName = formB.get(1).toString();
                for (int i = 0; i < formAName.length() - 1; i++) {
                    for (int j = 0; j < formBName.length() - 1; j++) {
                        if (formAName == formBName)
                            continue;
                        if (formAName.substring(i, i + 2).equals(formBName.substring(j, j + 2))) {
                            answer.add(formA.get(0).toString());
                            answer.add(formB.get(0).toString());
                        }
                    }
                }
            }
        }
        List<String> answerList = new ArrayList<String>(answer);
        Collections.sort(answerList);
        return answerList;
    }

    public static int checkValidation(List arr) {
        String email = arr.get(0).toString();
        String name = arr.get(1).toString();
        if (email.length() >= 20 || email.length() < 11) {
            return -1;
        }
        if (name.length() >= 20 || name.length() < 1) {
            return -1;
        }

        if (!"email.com".equals(email.substring(email.length() - 9, email.length()))) {
            return -1;
        }
        return 0;
    }
}
