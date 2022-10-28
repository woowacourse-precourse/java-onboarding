package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();


        HashSet<String> hashSet = new HashSet<>();  //중복된 이메일 제거를 위한 자료구조

        for(int i = 0 ; i < forms.size() ; i++){

            String nickname = forms.get(i).get(1);  //비교할 대상의 이름 추출

            for(int j = 0 ; j < nickname.length() ; j++){  //비교할 대상의 이름을 2글자 부터 자를 수 있는 크기만큼 자름

                for(int s = j+2 ; s < nickname.length() ; s++){

                    String containNickname = nickname.substring(j,s);   //비교할 대상의 이름을 자른 문자열

                    for(int k = 0 ; k < forms.size() ; k++){    //자른 닉네임을 forms를 돌면서 포함되어 있는지 확인

                        String compareNickname = forms.get(k).get(1);

                        if(compareNickname.contains(containNickname) && !nickname.equals(compareNickname)){ //자기 자신은 제거
                            hashSet.add(forms.get(k).get(0));   //비교한 대상 추가
                            hashSet.add(forms.get(i).get(0));   //기존 추가
                        }
                    }
                }
            }
        }

        for(String email : hashSet){    //반환 타입 변환
            answer.add(email);
        }


        return answer;
    }
}
