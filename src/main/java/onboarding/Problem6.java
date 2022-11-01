package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Problem6 P = new Problem6();
        for(int i = 0; i<forms.size(); i++){
            for(int j = 0; j<forms.size(); j++){
                if(i==j) continue;
                String name1 = P.nickName(forms.get(i));
                String name2 = P.nickName(forms.get(j));
                int pointer1 = 0, pointer2 = 0, cnt = 0;
                while(pointer1 < name1.length() && pointer2 < name2.length()){
                    if(name1.charAt(pointer1) == name2.charAt(pointer2)){
                        cnt++;
                        pointer1++;
                        pointer2++;
                    }else{
                        pointer1++;
                    }
                }
                if(cnt >= 2) {
                    if(!answer.contains(P.email(forms.get(i)))){
                        answer.add(P.email(forms.get(i)));
                    }
                }
                pointer1 = 0;
                pointer2 = 0;
                cnt = 0;
            }
        }
        Collections.sort(answer);
        return answer;
    }

    // 리스트에서 닉네임을 문자열로 반환하는 메서드
    public String nickName(List<String> list) {
        String nickname = list.get(1);
        return nickname;
    }

    // 리스트에서 이메일을 문자열로 반환하는 메서드
    public String email(List<String> list){
        String email = list.get(0);
        return email;
    }
}
