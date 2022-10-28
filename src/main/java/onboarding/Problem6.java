package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }


    // 닉네임의 연속된 두 글자를 체크리스트로 반환하는 메소드
    private static List<String> getCheckList(List<List<String>> forms) {
        List<String> nickNameList = getNickNameList(forms);
        Set<String> set = new HashSet<>();

        for (String nickName : nickNameList) {

            for (int i = 0; i < nickName.length() - 1; i++) {
                String needCheck = nickName.substring(i, i+2);
                set.add(needCheck);
            }
        }

        return new ArrayList<>(set);
    }


    // 이메일 리스트를 반환하는 메소드
    private static List<String> getEmailList(List<List<String>> forms) {
        List<String> email = new ArrayList<>();

        for (List<String> form : forms) {
            email.add(form.get(0));
        }

        return email;
    }


    // 닉네임 리스트를 반환하는 메소드
    private static List<String> getNickNameList(List<List<String>> forms) {
        List<String> nickName = new ArrayList<>();

        for (List<String> form : forms) {
            nickName.add(form.get(1));
        }

        return nickName;
    }

}