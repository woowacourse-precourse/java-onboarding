package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    public static Set<String> checkName(List<List<String>> forms){// 중복되는 닉네임 찾기
        Set<String> dupliName = new HashSet<String>();

        for(int i=0; i<forms.size(); i++){
            String name = forms.get(i).get(1);
            for(int j=0; j<name.length() -1; j++){
                String temp = name.substring(j,j+2); //두 글자씩 자름
                for(int k=i; k<forms.size()-1; k++){
                    String tempCheck = "";
                    tempCheck = forms.get(k+1).get(1);
                    if(tempCheck.contains(temp)){ //연속적으로 포함되면
                        dupliName.add(forms.get(i).get(0)); //기준되는 닉네임 추가
                        dupliName.add(forms.get(k+1).get(0)); //중복된 닉네임 추가
                    }
                }
            }
        }
        return dupliName;
    }
}
