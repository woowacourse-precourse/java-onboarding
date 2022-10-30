package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<Set<String>> tokenList = new ArrayList<>();
        Map<String, Integer> countOfToken = new HashMap<>();

        for (List<String> form : forms) {
            String nickName = form.get(1);
            Set<String> tokens = nickToToken(nickName);
            tokenList.add(tokens);
            makeCountMap(countOfToken, tokens);
        }

        for(int i=0;i<tokenList.size();i++){
            for (String token : tokenList.get(i)) {
                if (countOfToken.get(token) > 1) {
                    answer.add(forms.get(i).get(0));
                    break;
                }
            }
        }
        answer.sort((o1,o2)->{
            return o1.compareTo(o2);
        });
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

    /**
     * 토큰 set을 얻어와 contOfToken에 값을 집어넣음
     * */
    private static void makeCountMap(Map<String, Integer> countOfToken, Set<String> tokens){
        for (String token : tokens) {
            countOfToken.put(token, countOfToken.getOrDefault(token, 0)+1);
        }
    }

}
