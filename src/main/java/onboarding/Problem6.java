package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<Set<String>> tokenList = new ArrayList<>();

        for (List<String> form : forms) {
            String nickName = form.get(1);
            Set<String> tokens = nickToToken(nickName);
            tokenList.add(tokens);
        }

        return answer;
    }

    /**
     * nickname을 글자 2개씩 끊어서 토큰화
     * */
    private static Set<String> nickToToken(String nickname){
        Set<String> subSet = new HashSet<>();
        for(int i=0;i<nickname.length()-1;i++){
            String temp = nickname.substring(i,i+2);
            subSet.add(temp);
        }
        return subSet;
    }

}
