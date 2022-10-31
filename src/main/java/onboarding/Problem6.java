package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    //닉네임을 두글자씩 슬라이싱
    static List<List<String>> part_of_nickname(List<List<String>> forms){
        List<List<String>> part = new ArrayList<>();

        for(int i=0;i<forms.size();i++){
            String tmp = forms.get(i).get(1);
            List<String> tmp_part = new ArrayList<>();
            for(int j=0;j<tmp.length()-1;j++) {
                if(tmp.length()>=2) {
                    tmp_part.add(tmp.substring(j, j + 2));
                }
            }
            part.add(tmp_part);
        }

        return part;
    }

    //닉네임 조각을 비교해서 중복체크를 하는 함수

    //실행을 위한 process 함수

}

