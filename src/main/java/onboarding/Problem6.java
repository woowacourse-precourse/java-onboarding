package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<Crew> crews = new ArrayList<>();
        /**
         * 크루원들을 리스트에 넣으면서
         * 현재의 크루원이 이전의 크루원들의 닉네임과 2글자 이상 중복되는지 체크한 후 duplication 값을 업데이트
         * duplication 값이 true 크루원들의 이메일을 모아 정렬 후 리턴.
         */
        for (var str : forms ) {
            String email = str.get(0);
            String nickName = str.get(1);
            Crew cur = new Crew(email,nickName);
            for(var crew : crews){
                if(!isPossible(crew.nickName,sequenceString(cur.nickName))){
                    crew.duplication = true;
                    cur.duplication = true;
                }
            }
            crews.add(cur);
        }
        answer = crews.stream()
                .filter(ele->ele.duplication)
                .map(ele->ele.email)
                .collect(Collectors.toList());
        Collections.sort(answer);
        return answer;
    }
    // 기존의 닉네임과 2글자씩 분리한 닉네임을 비교
    static boolean isPossible(String origin , List<String> seq){
        for(int i =0 ;i<seq.size();i++){
            if(origin.contains(seq.get(i))) return false;
        }
        return true;
    }
    // 닉네임을 2글자씩 분리해서 관리
    static List<String> sequenceString(String str){
        List<String > seq = new ArrayList<>() ;
        for(int i = 0;i<str.length() - 1;i++){
            String temp = str.substring(i,i+2);
            seq.add(temp);
        }
        return seq;
    }
    static class Crew{
        String email;
        String nickName;
        Boolean duplication;
        public Crew(String email, String nickName) {
            this.duplication = false;
            this.email = email;
            this.nickName = nickName;
        }
    }
}
