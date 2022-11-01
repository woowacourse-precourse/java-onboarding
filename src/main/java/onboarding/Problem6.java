package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {

    static ArrayList<String> caseOfNickName = new ArrayList<>();
    static HashMap<Integer, Integer> duplicateIndex = new HashMap<>();

    public static List<String> containsNickName(ArrayList nickName, List<List<String>> forms){
        for(int i = 0; i < nickName.size(); i++){
            for(String s : caseOfNickName){
                if(nickName.get(i).toString().contains(s))
                    duplicateIndex.put(i, duplicateIndex.containsKey(i) ? duplicateIndex.get(i)+1 : 0);
                else duplicateIndex.put(i, duplicateIndex.containsKey(i) ? duplicateIndex.get(i) : 0);
            }
        }return getEmail(forms);
    }

    public static List<String> getEmail(List<List<String>> forms){
        List<String> emailList = new ArrayList<>();
        for(int i = 0; i < duplicateIndex.size(); i++){
            if(duplicateIndex.get(i)-(forms.get(i).get(1).length()-1)>0)
                emailList.add(forms.get(i).get(0));
        }
        Collections.sort(emailList);
        return emailList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
