package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    // 닉네임들만 저장
    public static List<String> getNicknameList(List<List<String>> forms){
        List<String> nicknameList = new ArrayList<>();
        for(int i=0; i<forms.size(); i++){
            nicknameList.add(forms.get(i).get(1));
        }
        return nicknameList;
    }

}