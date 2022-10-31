package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i=0; i< forms.size()-1 ; i++){
            List<String> tmp = new ArrayList<>();

            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);
            int name_len = name.length();
            for(int j=0; j< name_len-1; j++){
                tmp.add(name.substring(j,j+2)); // 이름을 두글자씩 자른다.
            }
            for(int k=i+1; k< forms.size(); k++){
                String compare_email = forms.get(k).get(0);
                String compare_name = forms.get(k).get(1);
                for(String str : tmp){
                    if(compare_name.contains(str)){
                        if(!answer.contains(email)){
                            answer.add(email);
                        }
                        if(!answer.contains(compare_email)){
                        answer.add(compare_email);}
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
        /** 같은 글자 처리를 어떻게 할 것인가?
         *  순차 탐색? --> 일단 이메일 순으로 정렬 하고, 처음 인덱스의 값 -->
         *  두 글자씩 잘라서 넣기
         *
         *
         * */
    }
}
