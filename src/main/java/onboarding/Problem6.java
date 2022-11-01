package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i=0; i<forms.size(); i++){
            List<String> containList = isContain(i,forms);
            answer.removeAll(containList); //중복제거
            answer.addAll(containList);
        }
        Collections.sort(answer);
        return answer;
    }

    //2개씩 단어 피스로 비교
    public static boolean compareWordPiece(String nowNick, String nextNick){
        for(int j=0; j<nextNick.length()-1; j++) {
            String tmpWord = nextNick.substring(j, j + 2);
            if (nowNick.contains(tmpWord)) {
                return true;
            }
        }
        return false;
    }

    //닉네임 포함되는 경우 기능 구현
    public static List<String> isContain(int index, List<List<String>> forms){
        List<String> emailIndexList = new ArrayList<>();
        String nowFormNick = forms.get(index).get(1);
        for(int i=index+1; i<forms.size();i++){
            String nextFormNick = forms.get(i).get(1);
            if (compareWordPiece(nowFormNick,nextFormNick)) {
                emailIndexList.add(forms.get(i).get(0));
                break;
            }
        }
        if (emailIndexList.size() != 0){
            emailIndexList.add(forms.get(index).get(0));
        }
        return emailIndexList;
    }
}
