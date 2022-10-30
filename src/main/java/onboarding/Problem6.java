package onboarding;

import java.util.*;
/*
기능 목록
1. 닉네임 길이별로 나눠서 map에 저장
2. 닉네임을 포함하고 있으면 answer에 추가, 만일 answer에 중복되는 이메일이 없다면 추가
** 제한 사항 **
answer의 중복 제거, 알파벳 순서 나열
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        for(List<String> form: forms){
            String email = form.get(0);
            String nickName = form.get(1);
            for(int i = 0;i<nickName.length()-1;i++){
                String keyName = nickName.substring(i,i+1);
                map.put(keyName,email);
        }
        return answer;
    }
}
