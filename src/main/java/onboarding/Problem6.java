package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;

public class Problem6 {
    private static HashMap<String, Integer> subNicknameDic; //각 닉네임의 두글자씩 카운트하는 딕셔너리

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        subNicknameDic = new HashMap<>(); //닉네임카운트 초기화
        checkAllNickname(forms); //모든 닉네임 확인

        for(int i=0;i<forms.size();i++){
            List<String> form = forms.get(i);

            //입력된 form의 사이즈가 2개가 아니라면 continue
            if(form.size() != 2){
                continue;
            }

            String email = form.get(0);
            String nickname = form.get(1);
            int count = getCountInDic(nickname);
            
            //딕셔너리에 닉네임 부분이 2개 이상
            //중복 제거를 위해 contains 사용
            if(count > 1 && !answer.contains(email)){
                answer.add(email);
            }
        }
        Collections.sort(answer); //오름차순 정렬
        return answer;
    }

    //모든 닉네임들에 대하여 subNicknameCount하는 함수
    private static void checkAllNickname(List<List<String>> forms){
        for(int i=0;i<forms.size();i++){
            List<String> form = forms.get(i);
            String nickname = form.get(1);
            subNicknameCount(nickname);
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
            ret = Math.max(ret, subNicknameDic.getOrDefault(subNickname,0));
        }
        return ret;
    }
}