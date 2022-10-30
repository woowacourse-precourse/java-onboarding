package onboarding;

import java.util.*;

public class Problem6 {

    public static Map<String, LinkedList<String>> makeTokens(List<List<String>> forms){
        Map<String, LinkedList<String>> result = new HashMap<>();

        for (List<String> form : forms){
            String nickname = form.get(1);
            for(int i =0; i<nickname.length()-1;i++){
                String token = nickname.substring(i,i+2);
                if(!result.keySet().contains(token)){
                    result.put(token, new LinkedList<>());
                }
                result.get(token).add(nickname);
            }
        }
        return result;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Set<String> overlapNicknameList = new HashSet<>();
        Map<String,String> formsMap = new HashMap<>();
        Map<String, LinkedList<String>> m = makeTokens(forms);

        for(List<String> form : forms){
            formsMap.put(form.get(1),form.get(0));
        }
        for(String token : m.keySet()){
            LinkedList<String> l = m.get(token);
            if (l.size() >= 2){
                for(String overlapNickname : l){
                    overlapNicknameList.add(overlapNickname);
                }
            }
        }

        for (String overlapNickname : overlapNicknameList){
            answer.add(formsMap.get(overlapNickname));
        }

        Collections.sort(answer);

        return answer;
    }
}
