package onboarding;

import java.util.List;
import java.util.HashMap;

public class Problem6 {
    private static HashMap<String, Integer> subNicknameDic; //각 닉네임의 두글자씩 카운트하는 딕셔너리

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        subNicknameDic = new HashMap<>(); //닉네임카운트 초기화
        checkAllNickname(forms); //모든 닉네임 확인
        return answer;
    }

    //모든 닉네임들에 대하여 subNicknameCount하는 함수
    private static void checkAllNickname(List<List<String>> forms){
        for(int i=0;i<forms.size();i++){
            List<String> form = forms.get(0);
            subNicknameCount(form.get(1));
        }
    }

    //각 닉네임에 대한 부분 숫자 카운트
    private static void subNicknameCount(String nickname){
        for(int i=0;i<nickname.length()-1;i++){
            String subNickname = nickname.substring(i,i+2);
            subNicknameDic.put(subNickname, subNicknameDic.getOrDefault(subNickname,0) + 1);
        }
    }

    //subNicknameDic에서 각 닉네임의 두글자씩에 해당하는 숫자 중 큰값 구하는 함수
    private static int getCountInDic(String nickname){
        int ret = -1;
        for(int i=0;i<nickname.length()-1;i++){
            String subNickname = nickname.substring(i,i+2);
            ret = Math.max(ret, subNicknameDic.get(subNickname));
        }
        return ret;
    }
}