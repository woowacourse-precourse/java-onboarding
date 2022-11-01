package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(); // 최종 리턴 값
        List<Set<String>> tokensList = new ArrayList<>(); // 리스트 변수 생성
        Map<String, Integer> tokenCounter = new HashMap<>();// 해쉬 맵 생성
        forms.stream()
                .map(arg -> tokenizer(arg.get(1)))// 이름 값만 추출 후 tokenizer : line33
                        .forEach(tokens -> {

                    tokensList.add(tokens);//token
                    tokens.forEach(token ->
                            tokenCounter.put(token, tokenCounter.getOrDefault(token, 0) + 1));//해쉬맵에서 token을 getOrDefault 이용해서 존재하면 value+1

                });

        for (int i = 0; i < tokensList.size(); i++) { //tokensList size만큼 반복
            if (tokensList.get(i).stream().anyMatch(token -> tokenCounter.get(token) > 1)) { //tokenList에서 stream의 매칭메소드를 이용해서 tokenCounter에 키를 넘기고 받은 값이 1보다 크면
                answer.add(forms.get(i).get(0));// 위 코드의 조건을 만족한 사람의 emial을 answer에 추가
            }
        }

        answer.sort(String::compareTo);
        return answer;
    }
    private static Set<String> tokenizer(String arg) {
        Set<String> tokenSet = new HashSet<>();//해쉬세트 선언
        for (int i = 0; i < arg.length() - 1; i++) {//arg 의 길이에서 -1 만큼 반복
            String token = arg.substring(i, i + 2); // arg 에서 두 글자씩 추출해서
            tokenSet.add(token);//해쉬세트에 추가
        }
        return tokenSet;//한 arg 인자에 대해 token 을 추출 => Hashset 에 추가 => Hashset 리턴
    }

}