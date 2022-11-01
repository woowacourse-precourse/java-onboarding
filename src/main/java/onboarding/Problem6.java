package onboarding;

import java.util.*;

public class Problem6 {
    // 기능 목록 1 : 닉네임을 두 글자씩 나누는 함수
    public static List<String> makeNewnickname(String nickname){
        List<String> new_nickname = new ArrayList<>();

        for(int i=0;i<nickname.length()-1;i++){
            String temp = "";
            temp+=nickname.charAt(i);
            temp+=nickname.charAt((i+1));
            new_nickname.add(temp);
        }

        return new_nickname;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
