package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //TODO: 토큰화; 이름의 두 글자씩 잘라서 {토큰:[토큰이포함된이메일주소,..]} 을 만든다.
        Map<String, Set<String>> dictionary=new HashMap<>();
        for(List<String>form :forms){
            String email=form.get(0);
            String nickname=form.get(1);
            for(int i=0;i<nickname.length()-1;i++){
                String token=nickname.substring(i,i+2);
                Set<String> tokenEmails=dictionary.getOrDefault(token,new HashSet<>());
                tokenEmails.add(email);
                dictionary.put(token,tokenEmails);
            }
        }
        //TODO: 공통값찾기;
        Set<String> preAnswer=new TreeSet<>();
        dictionary.entrySet().stream()
                .filter(x->x.getValue().size()>=2)
                .forEach(x->preAnswer.addAll(x.getValue()));
        List<String> answer = new ArrayList<>(preAnswer);
        return answer;
    }
}
