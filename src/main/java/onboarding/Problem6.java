package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class  Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        List<String> words = new ArrayList<>();

        // 닉네임 두글자씩 잘라서 리스트에 포함
        for (int i=0; i<forms.size(); i++){
            String nickname = forms.get(i).get(1);
            for(int j=1; j<nickname.length(); j++){
                words.add(nickname.substring(j-1,j+1));
            }
        }

        // 리스트안에 값과 닉네임을 비교해서 2번이상(자신 것 포함) 나오면 이메일 추가
        for (int i=0; i<forms.size(); i++) {
            int cnt = 0;
            for(int j=0; j<words.size(); j++){
                boolean check = forms.get(i).get(1).contains(words.get(j));
                if (check == true) cnt += 1;
            }
            if (cnt >= forms.get(i).get(1).length()){
                answer.add(forms.get(i).get(0));
            }
        }

        // 이메일 중복 제거하고 오름차순
        answer = answer.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);

        return answer;
    }

}
