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
        return answer;
    }
}
