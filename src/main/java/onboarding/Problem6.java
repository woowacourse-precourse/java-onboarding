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

    /**
     * 같은 글자가 연속적으로 포함된 크루 추출 함수 ( 중복 제거 )
     * @param tokenMap : 닉네임 토큰화 map
     * @return : 같은 글자가 연속적으로 포함된 닉네임 작성 지원자 이메일 set
     */
    public static HashSet<String> findEmailSet(Map<String, List<String>> tokenMap){
        HashSet<String> set = new HashSet<>();
        for (Map.Entry<String,List<String>> info : tokenMap.entrySet()){
            if(info.getValue().size()>1){
                set.addAll(info.getValue());
            }
        }
        return set;
    }


    public static List<String> solution(List<List<String>> forms) {

        Map<String, List<String>> tokenMap = makeTokenDict(forms);

        HashSet<String> set = findEmailSet(tokenMap);

        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer);

        return answer;
    }
}
