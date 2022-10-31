package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(); // 정답을 저장

        // 1. 각 닉네임에서 길이 2의 token을 set으로 구성하여 수집함
        HashSet<String> tokens = getTokens(forms);

        return answer;
    }

    // 각 닉네임에서 길이 2의 token을 set으로 구성하여 수집
    private static HashSet<String> getTokens(List<List<String>> forms) {
        HashSet<String> tokens = new HashSet<>(); // 길이 2의 token의 set

        for(List<String> form : forms) {
            String nickname = form.get(1);
            if(nickname.length() <= 1) continue; // nickname의 길이가 1이어서 수집할 token이 없는 경우
            for(int i=0 ; i<nickname.length()-1 ; i++)
                tokens.add(nickname.substring(i, i+2));
        }

        return tokens;
    }
}
