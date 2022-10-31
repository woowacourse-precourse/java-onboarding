package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //Key = 두글자 단어, Value = 이메일
        Map<String,String> twoWord = new HashMap<>();
        //중복된 사람들의 이메일
        Set<String> duplicationTarget = new HashSet<>();

        for(int i =0; i < forms.size(); i++){
            List<String> target = forms.get(i);
            String nickname = target.get(1);

            for(int j = 1; j < nickname.length(); j++){
                String word = nickname.substring(j-1,j + 1);
                if(twoWord.containsKey(word)){
                    duplicationTarget.add(twoWord.get(word));
                    duplicationTarget.add(target.get(0));
                }
                else
                    twoWord.put(word, target.get(0));
            }
        }

        List<String> answer = new ArrayList<>(duplicationTarget);
        Collections.sort(answer);
        return answer;
    }
}
