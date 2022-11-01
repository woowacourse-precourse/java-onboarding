package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    static ArrayList<String> caseOfNickName = new ArrayList<>();
    static HashMap<Integer, Integer> duplicateIndex = new HashMap<>();

    public static List<String> caseArray (List<List<String>> forms){
        ArrayList<String> nickName = new ArrayList<>();
        for(List<String> name : forms) // 닉네임 리스트 만들기
            nickName.add(name.get(1));

        for(String n : nickName){
            for(int j = 0; j <= n.length()-2; j++){
                caseOfNickName.add(n.substring(j, j+2)); // 닉네임에서 두 글자 조합 만들기
            }
        }
        return containsNickName(nickName, forms);
    }

    public static List<String> containsNickName(ArrayList nickName, List<List<String>> forms){
        for(int i = 0; i < nickName.size(); i++){
            for(String s : caseOfNickName){
                if(nickName.get(i).toString().contains(s)) // 같은 글자가 포함되는 닉네임 찾기
                    duplicateIndex.put(i, duplicateIndex.containsKey(i) ? duplicateIndex.get(i)+1 : 0); // 포함 횟수 count
                else duplicateIndex.put(i, duplicateIndex.getOrDefault(i, 0));
            }
        }return getEmail(forms);
    }

    public static List<String> getEmail(List<List<String>> forms){
        List<String> emailList = new ArrayList<>();
        for(int i = 0; i < duplicateIndex.size(); i++){
            if(duplicateIndex.get(i)-(forms.get(i).get(1).length()-1)>0) // 총 count에서 닉네임으로 만들 수 있는 두 글자 조합의 개수 빼기
                emailList.add(forms.get(i).get(0));
        }Collections.sort(emailList);
        return emailList;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = caseArray(forms);
        return answer;
    }
}

