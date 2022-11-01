package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<>();

        List<String> nicknameArr = new ArrayList<>();
        String nickname, splitNick;
        List<String> emailArr;

        // 1. 닉네임을 2글자로 쪼개기.
        for (List<String> form : forms) {
            nickname = form.get(1);
            for (int i = 1; i < nickname.length(); i++) {
                splitNick = Character.toString(nickname.charAt(i - 1)).concat(Character.toString(nickname.charAt(i)));
                nicknameArr.add(splitNick);
            }
        }

        // 2. 쪼갠 2글자 중복 제거
        nicknameArr = nicknameArr.stream().distinct().collect(Collectors.toList());
        // 3. 쪼갠 2글자를 포함한 닉네임이 2개이상일 때 해당 닉네임 사용을 제한.
        for (String gram : nicknameArr) {
            emailArr = new ArrayList<>();
            for (int j=0; j < forms.size(); j++) {
                nickname = forms.get(j).get(1);

                if (nickname.contains(gram)) {
                    emailArr.add(forms.get(j).get(0));
                }
            }
            if (emailArr.size() >= 2) {
                for (String email : emailArr) {
                    answer.add(email);
                }
            }
        }
        return answer;
    }
}
