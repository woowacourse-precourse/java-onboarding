package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = checkDuplicateNickname(forms);
        Collections.sort(answer);
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
    public static List<String> exceptTargetNickname(List<String> nickname, int index){
        List<String> nicknames = new ArrayList<>();
        for(int i=0; i<nickname.size(); i++){
            if(i!=index) nicknames.add(nickname.get(i));
        }
        return nicknames;
    }
    // 문자를 두 글자 씩 자르기
    public static List<String> splitWord(String nickname){
        List<String> splitNickname = new ArrayList<>();
        for(int j=0; j<nickname.length()-1; j++){
            if(nickname.length()==2){
                splitNickname.add(nickname);
            }
            splitNickname.add(nickname.substring(j,j+2));
        }
        return splitNickname;
    }
    //중복검사
    public static List<String> checkDuplicateNickname(List<List<String>> forms) {
        List<String> nicknameList = getNicknameList(forms);
        List<String> nicknameExcept;
        List<String> duplicateList = new ArrayList<>();
        List<String> split = new ArrayList<>();
        for (int i = 0; i < nicknameList.size(); i++) {
            nicknameExcept = exceptTargetNickname(nicknameList, i);
            split = splitWord(nicknameList.get(i));
            for (String word: split) {
                for(String nickname : nicknameExcept) {
                    if (nickname.contains(word)) {
                        duplicateList.add(forms.get(i).get(0));
                        break;
                    }
                }
            }
        }
        return duplicateList;
    }

}