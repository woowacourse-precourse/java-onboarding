package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    static boolean[] isDuplication;
    static List<List<String>> list;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        list = forms;
        isDuplication = new boolean[forms.size()];
        for(int i=0; i<forms.size(); i++){
            String curName = forms.get(i).get(1);
            permutation(curName, i);
        }
        for(int i=0; i<isDuplication.length; i++){
            if(!isDuplication[i]) continue;
            answer.add(list.get(i).get(0));
        }
        Collections.sort(answer);
        return answer;
    }
    public static void permutation(String name, int listIdx){
        for(int i=0; i<name.length(); i++){
            if(i+1 >= name.length()) break;
            String s = name.substring(i, i+2);
            checkDuplication(s, listIdx);
        }
    }
    public static void checkDuplication(String s, int listIdx){
        int cnt=0;
        for(int i=0; i<list.size(); i++){
            if(i == listIdx || isDuplication[i]) continue;
            if(list.get(i).get(1).contains(s)){
                isDuplication[i] = true;
                cnt++;
            }
        }
        //1개이상 중복되면 자기 자신도 제거
        if (cnt >0)
            isDuplication[listIdx] = true;

    }
}
