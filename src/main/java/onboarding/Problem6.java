package onboarding;

import java.util.*;

public class Problem6 {
    public static void compareNickname(List<String> targetList,String[] name,List<List<String>> forms,int curIndex,Set<String> result){
        for(int i=0;i<name.length-1;i++){
            String compStr = name[i] + name[i+1];
            String targetName = targetList.get(1);
            if(targetName.contains(compStr)){
                result.add(forms.get(curIndex).get(0));
                result.add(targetList.get(0));
                break;
            }
        }
    }
    public static Set<String> checkDupl(List<List<String>> forms){
        Set<String> result = new HashSet<>();
        for(int i=0;i<forms.size()-1;i++){
            String nickname = forms.get(i).get(1);
            String[] nameArr = nickname.split("");
            for(int j=i+1;j<forms.size();j++){
                List<String> targetList = forms.get(j);
                compareNickname(targetList,nameArr,forms,i,result);
            }
        }
        return result;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(checkDupl(forms));
        Collections.sort(answer);
        return answer;
    }
}