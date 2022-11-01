package onboarding;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Problem6 problem6 = new Problem6();

        for(int i = 0; i < forms.size(); i++){
            String ctrName = forms.get(i).get(1);
            //List<String> ctrNameList =  ctrName;
            for (int j = i+1; j < forms.size() - i; j++){
                String expName = forms.get(j).get(1);
                //ctrNameList.retainAll();
                // 하나씩 꺼내서 비교하기
                
                if (problem6.isDuplicate(ctrName, expName)){
                    answer.add(ctrName);
                    answer.add(expName);
                }
            }
        }

        // List를 Set으로 변경
        Set<String> set = new HashSet<String>(answer);

        // Set을 List로 변경
        List<String> newList = List.of("set");

        return newList;
    }

    private boolean isDuplicate(String ctrName, String expName){
        int cnt = 0;
        if(ctrName.length() < expName.length()){
            for(int i = 0; i < expName.length(); i++){
                if(ctrName.charAt(i) == expName.charAt(i)){
                    cnt ++;
                }
            }
        }
        else{
            for(int i = 0; i < ctrName.length(); i++){
                if(ctrName.charAt(i) == expName.charAt(i)){
                    cnt ++;
                }
            }
        }
        if (cnt > 1){
            return true;
        }
        else{
            return false;
        }
    }
    
}
