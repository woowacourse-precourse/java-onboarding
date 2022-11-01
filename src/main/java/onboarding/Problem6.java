package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, ArrayList<Integer>> formsMap = new HashMap<>();
        HashSet<Integer> answerSet = new HashSet<>();
        ArrayList<String> answer = new ArrayList<>();
        //formsMap만들기
        for(int i=0;i<forms.size();i++){
            List<String> tmp = forms.get(i);
            makeFormsMap(tmp.get(1),i,formsMap); //tmp.get(1)은 닉네임
        }

        //formsSet만들기
        for(String key : formsMap.keySet()){
            makeAnswerSet(key,formsMap,answerSet);
        }

        // answer에 이메일 보낼 사람 추가
        for(int idx : answerSet){
            String email = forms.get(idx).get(0);
            answer.add(email);
        }

        Collections.sort(answer);
        return answer;
    }

    public static void makeFormsMap(String nickName, int idx, HashMap<String, ArrayList<Integer>> formsMap){
        if(nickName.length()<2) return;

        for(int i=0;i<nickName.length()-1;i++){
            String doubleChar = nickName.substring(i, i+2);

            if(formsMap.containsKey(doubleChar)){
                formsMap.get(doubleChar).add(idx);
            }
            else{
                formsMap.put(doubleChar, new ArrayList<Integer>(Arrays.asList(idx)));
            }
        }
    }

    public static void makeAnswerSet(String key, HashMap<String, ArrayList<Integer>> formsMap, HashSet<Integer> answerSet){

        if(formsMap.get(key).size()>1){
            answerSet.addAll(formsMap.get(key));
        }
    }

}
