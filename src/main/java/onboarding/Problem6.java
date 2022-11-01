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
    // 본인 제외 닉네임 리스트
    public static List<String> nicknameExcept(List<String> nickname, int index){
        List<String> nicknames = new ArrayList<>();
        for(int i=0; i<nickname.size(); i++){
            if(i!=index) nicknames.add(nickname.get(i));
        }
        return nicknames;
    }

}