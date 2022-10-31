package onboarding;

import java.util.*;

public class Problem6 {
    /*
    * 1. 닉네임을 2글자씩 끊어서 Map에 저장합니다.
    *    저장시에 2글자를 key로 value로 있는 set에 자신의 이메일을 저장합니다.
    * 2. 이후 길이가 2 이상인 set들은 모두 겹치는 사람들의 이메일을 포함합니다.
    * 3. 해당 set들을 union하여 출력합니다.
    * */
    public static List<String> solution(List<List<String>> forms) {

        Map<String, Set<String>> wordMap = new HashMap<>();
        for(var form : forms){
            String email = form.get(0);
            String nickname = form.get(1);
            for(int j =0; j<nickname.length()-1; j++){
                String twoChars = nickname.substring(j, j+2);
                wordMap.putIfAbsent(twoChars, new HashSet<>());
                wordMap.get(twoChars).add(email);
            }
        }

        Set<String> dupEmails = new HashSet<>();
        for(Set<String> emailSets : wordMap.values()){
            if(emailSets.size() > 1)
                dupEmails.addAll(emailSets);
        }

        List<String> answer = new ArrayList<>(dupEmails);
        answer.sort(String::compareTo);

        return answer;
    }
}
