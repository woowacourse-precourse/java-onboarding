package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    /***
     * 닉네임 중복 체크 함수
     * 중복 제거, 닉네임 오름차순 정렬 함수
     * 중복되는 이메일 List에 넣는 함수
     */
    public static List<String> solution(List<List<String>> forms) {
        return nik_check(forms);
    }

    /**
     * 닉네임 중복 체크 함수
     */
    static boolean check(String name, String name2){
        for(int i=1;i<name.length();i++){
            for(int j=1;j<name2.length();j++){
                if(name.substring(i-1,i+1).equals(name2.substring(j-1,j+1))) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 중복 제거, 닉네임 오름차순 정렬 함수
     */
    static List<String> organize(List<String> answer){
        answer = answer.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);
        return answer;
    }

    /**
     * 중복되는 이메일 List에 넣는 함수
     */
    static List<String> nik_check(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();

        for(int i=0;i<forms.size();i++){
            for(int j=i+1;j<forms.size();j++){
                List<String> me = forms.get(i);
                List<String> you =forms.get(j);
                if(check(me.get(1),you.get(1))){
                    answer.add(me.get(0));
                    answer.add(you.get(0));
                }
            }
        }
        return organize(answer);
    }
}
