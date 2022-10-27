package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    // 두 문자열 비교
    static boolean checkString(String a, String b){

        return false;
    }

    // chkNum번 유저와 자신 뒤에 사람들 비교
    static List<Integer> checkSimilar(List<List<String>> forms, List<Integer> S_List, int chkNum){
        for(int i = chkNum+1; i < S_List.size(); i++){
            if(checkString(forms.get(chkNum).get(1), forms.get(i).get(1))){
                S_List.set(chkNum, 1);
                S_List.set(i,1);
            }
        }
        return S_List;
    }

    // 비슷한 닉네임 인덱스 모음 리스트 반환
    static List<Integer> findSimilarList(List<List<String>> forms){
        ArrayList<Integer> similarList = new ArrayList<>();
//        for(int i = 0; i < forms.size(); i++){
//            similarList.add(0);
//        }

        for(int i = 0; i < forms.size(); i++){
            similarList = (ArrayList<Integer>) checkSimilar(forms, similarList, i);
        }

        return similarList;
    }

    // 인덱스 모음 리스트에 따른 이메일 리스트 반환
    static List<String> returnEmail(List<List<String>> forms, List<Integer> similarList){
        ArrayList<String> emailList = new ArrayList<>();
        for(int i = 0; i < similarList.size(); i++){
            if(similarList.get(i) == 1){
                emailList.add(forms.get(i).get(0));
            }
        }
        return emailList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
