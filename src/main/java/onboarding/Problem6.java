package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    // 같은 글자가 연속적으로 포함되는 경우를 찾아 리스트에 메일 추가
    static List<String> findDup(List<List<String>> forms){
        List<String> mailList = new ArrayList<>();
        // 크루의 닉네임 중에서 2글자를 substring으로 추출
        for(int i=0; i<forms.get(i).get(1).length()-2; i++){
            String substring = forms.get(i).get(1).substring(i, i+2);
            // substring이 다른 크루들의 닉네임에 포함되어 있는지 확인
            for(int j=0; j<forms.size(); j++){
                if(forms.get(j).get(1).contains(substring)){
                    mailList.add(forms.get(j).get(0));
                }
            }
        }
        return mailList;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = findDup(forms);
        Collections.sort(answer);
        return answer;
    }
}
