package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    // 6. email만 따로 리스트 만들기
    public static List<String> getEmailList(List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();

        for (List<String> form : forms) {
            emailList.add(form.get(0));
        }
        return emailList;
    }

    // 7. 닉네임만 따로 리스트 만들기
    public static List<String> getNicknameList(List<List<String>> forms) {
        List<String> nicknameList = new ArrayList<>();

        for (List<String> form : forms) {
            nicknameList.add(form.get(1));
        }
        return nicknameList;
    }
}
