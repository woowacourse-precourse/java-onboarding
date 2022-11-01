package onboarding;

import java.util.*;

public class Problem6 {

    private static Map<String, List<String>> nicknameMap;

    public static void makeNicknameList(String nickname, String email){

        for (int i = 0; i<nickname.length();i++) {
            for (int j = i + 2; j <= nickname.length(); j++) {
                String subNickname = nickname.substring(i, j);
                List<String> emailList = nicknameMap.getOrDefault(subNickname, new ArrayList<>());
                emailList.add(email);
                nicknameMap.put(subNickname, emailList);
            }
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        nicknameMap = new HashMap<>();
        Set<String> answerSet = new TreeSet<>();
        for (int i = 0; i<forms.size();i++){
            makeNicknameList(forms.get(i).get(1), forms.get(i).get(0));
        }
        for (String nickname : nicknameMap.keySet()){
            if (nicknameMap.get(nickname).size() > 1){
                answerSet.addAll(nicknameMap.get(nickname));
            }
        }
        return new ArrayList<>(answerSet);
    }
}
