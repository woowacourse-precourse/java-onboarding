package onboarding;

import java.util.*;

public class Problem6 {

    /**
     * 닉네임 토큰화 하여 딕셔너리 생성 ( Key : 닉네임 토큰 , value : 해당 토큰을 포함한 이메일 리스트 )
     * @param forms : 지원자 닉네임, 이메일 목록
     * @return : 토큰화된 닉네임 딕셔너리
     */
    public static Map<String, List<String>> makeTokenDict(List<List<String>> forms){
        Map<String, List<String>> tokenMap = new HashMap<>(); // 토큰 정보 저장

        for(List<String> info : forms){
            String email = info.get(0);
            String nickname = info.get(1);
            for (int i =0; i< nickname.length()-1; i++){
                String token = nickname.substring(i, i+2);
                if (tokenMap.containsKey(token)){
                    tokenMap.get(token).add(email);
                }else{
                    List<String> newList = new ArrayList<>();
                    newList.add(email);
                    tokenMap.put(token, newList);
                }
            }
        }
        return tokenMap;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        Map<String, List<String>> tokenMap = makeTokenDict(forms);


        return answer;
    }
}
