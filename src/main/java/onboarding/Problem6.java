package onboarding;

import java.util.*;

public class Problem6 {


    public static Map<String, LinkedList<String>> makeTokens(Map<String, String> formsMap){
        Map<String, LinkedList<String>> result = new HashMap<>();

        for (String nickname : formsMap.keySet()){
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
    public static Map<String,String > makeFormsMap(List<List<String>> forms){
        Map<String,String> formsMap = new HashMap<>();

        for(List<String> form : forms){
            formsMap.put(form.get(1),form.get(0));
        }
        return formsMap;
    }
    public static Set<String> makeOverlapNicknameList(Map<String, LinkedList<String>> m){
        Set<String> overlapNicknameList = new HashSet<>();
        for(String token : m.keySet()){
            LinkedList<String> l = m.get(token);
            if (l.size() >= 2){
                for(String overlapNickname : l){
                    overlapNicknameList.add(overlapNickname);
                }
            }
        }
        return overlapNicknameList;
    }

    public static List<String> OverlapNicknameListToEmailList(Map<String,String> formsMap , Set<String> overlapNicknameList){
        List<String> answer = new ArrayList<>();

        for (String overlapNickname : overlapNicknameList){
            answer.add(formsMap.get(overlapNickname));
        }

        Collections.sort(answer);
        return  answer;
    }

    public static List<String> solution(List<List<String>> forms) {
        Map<String,String> formsMap = makeFormsMap(forms);
        Map<String, LinkedList<String>> m = makeTokens(formsMap);
        Set<String> overlapNicknameList = makeOverlapNicknameList(m);

        return OverlapNicknameListToEmailList(formsMap,overlapNicknameList);
    }
}
