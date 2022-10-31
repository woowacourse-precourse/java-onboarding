package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        answer = findDupNickname(forms);

        return answer;
    }

    /**
     * DESCRIPTION
     *   forms가 전달되면, form을 하나씩 살펴보며 form에 속한 닉네임이 닉네임 통과조건에 부합한지 판단
     *
     * Params
     *   forms - 각 유저의 {email, nickname}을 포함하고 있는 list
     *
     * RETURN
     *   닉네임 조건을 통과하지 못한 유저들의, 오름차순으로 정리된 이메일 list
     */
    public static List<String> findDupNickname(List<List<String>> forms){
        List<String> result = new ArrayList<>(); // 반환되는 이메일(결과값)을 저장
        Map<String, String> dupleNames = new HashMap<>(); // 각 닉네임을 2글자씩 자른 SubString을 구한 후, (2글자 SubString, email)로 저장

        for(List<String> form : forms){ // forms에 있는 form 순회
            String email = form.get(0);
            String nickname = form.get(1);

            for(int i = 0; i < nickname.length() - 1; i++){ // 닉네임을 2글자씩 분해하기 위한 반복
                String sub = nickname.substring(i, i+2); // 닉네임 분해

                // 조건 1. 현재 2글자로 닉네임이 지금까지 나온 닉네임들에 속해있는지
                // 조건 2. 중복 닉네임이 자기 자신한테서 나온 것이 아닐 시(e.g. 포비비비 에서 앞 '비비'와 뒤 '비비'는 무효)
                if(dupleNames.containsKey(sub) && !dupleNames.get(sub).equals(email)) {
                    result.add(email);

                    if(!result.contains(dupleNames.get(sub))) // 상대방 이메일도 result에 포함시킴
                        result.add(dupleNames.get(sub));

                    break;
                }
                else{ // 현재 2글자 SubString이 중복이 아닐 시
                    dupleNames.put(sub, email);
                }
            }
        }

        Collections.sort(result); // 이메일을 기준으로 오름차순 정렬 후 반환
        return result;
   }
}
