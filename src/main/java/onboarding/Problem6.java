package onboarding;

import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Problem6 {
//    해쉬맵에 닉네임을 2글자씩 key값으로 이메일을 value값으로 넣어 key가 없을 경우 추가 있을 경우 이메일 비교 후 중복 이메일에 추가
//    중복 이메일 목록에서 중복항목 제거하기 위해 HashSet 이용
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> dup_mail = new HashSet<>();
        HashMap<String,String> dup_word = new HashMap<>();

        for (int i = 0; i<forms.size(); i++){
            String Email = forms.get(i).get(0);
            String user_name = forms.get(i).get(1);

            for (int j = 0;j < user_name.length() - 1; j++){
                String word = user_name.substring(j, j+2);
                if (dup_word.get(word) == null){
                    dup_word.put(word, Email);
                }
//                제이제이 등 자신의 닉네임에서 겹치는 경우를 제외하기 위해 해쉬맵의 value값과 Email이 다를 경우에만 추가
                else if (dup_word.get(word) != Email){
                    dup_mail.add(Email);
                    dup_mail.add(dup_word.get(word));
                }
            }
        }
        List<String> answer = new ArrayList<>(dup_mail);
        Collections.sort(answer);
        return answer;
    }
}
