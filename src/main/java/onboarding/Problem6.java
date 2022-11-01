package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> repeatNickNameMap = new HashMap<>();
        Set<String> answerSet = new HashSet<>();

        for (List<String> crew : forms){
            String email = crew.get(0);
            String nickName = crew.get(1);

            for (String nickNameSubString : getSubStringList(nickName)){
                if (repeatNickNameMap.containsKey(nickNameSubString)){
                    answerSet.add(repeatNickNameMap.get(nickNameSubString));
                    answerSet.add(email);
                }
                else{
                    repeatNickNameMap.put(nickNameSubString, email);
                }
            }
        }
        List<String> answer = new ArrayList<>(answerSet);
        answer.sort(String::compareTo);
        return answer;
    }

    private static List<String> getSubStringList(String nickName){
        List<String> subStringList = new ArrayList<>();
        StringBuilder nickNameBuilder = new StringBuilder(nickName);
        for (int nowIndex = 0; nowIndex < nickName.length() - 1; nowIndex++){
            subStringList.add(nickNameBuilder.substring(nowIndex, nowIndex + 2));
        }
        return subStringList;
    }
}
