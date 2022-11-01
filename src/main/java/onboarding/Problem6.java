package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        answer.addAll(email(forms));

        Collections.sort(answer);
        return answer;
    }

    //닉네임에 같은 글자 연속적으로 포함되는 지원자의 이메일 목록을 저장한다.
    public static Set<String> email(List<List<String>> forms){
        Set<String> email = new HashSet<>();

        for(int i=0; i<forms.size(); i++){
            String email1 = forms.get(i).get(0);
            String nickname1 = forms.get(i).get(1);

            //닉네임의 연속적인 글자 저장
            List<String> letters = new ArrayList<>();
            for(int j=0; j<nickname1.length()-1; j++){
                letters.add(nickname1.substring(j, j+2));
            }

            for(int j=i+1; j<forms.size(); j++){
                String email2 = forms.get(j).get(0);
                String nickname2 = forms.get(j).get(1);

                //연속적인 글자가 중복되면 이메일 저장
                for(String duplicate : letters){
                    if(nickname2.contains(duplicate)){
                        email.add(email1);
                        email.add(email2);
                        break;
                    }
                }
            }
        }

        return email;
    }

}
