package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    /*
    1. 닉네임 두개를 선택
    2. 두 닉네임의 중복 여부 검사
    3. 중복일 시 리스트에 이메일 push
    4. 이메일 리스트 정렬
     */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i=0; i<forms.size(); i++){
            String nickname1 = forms.get(i).get(1);

            for (int j=i+1; j<forms.size(); j++) {
                String nickname2 = forms.get(j).get(1);
                boolean isDuplicate = isDuplicate(nickname1, nickname2);

                if(isDuplicate) {
                    String email1 = forms.get(i).get(0);
                    String email2 = forms.get(j).get(0);
                    addEmail(answer, email1);
                    addEmail(answer, email2);
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

    // 두 닉네임의 중복 여부를 검사하는 함수 isDuplicate()
    private static boolean isDuplicate(String nickname1, String nickname2) {
        for (int i=0; i<nickname1.length()-1; i++){
            String substr1 = nickname1.substring(i, i+2);
            for (int j=0; j<nickname2.length()-1; j++){
                String substr2 = nickname2.substring(j, j+2);
                if(substr1.equals(substr2)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 리스트에 없는 이메일만 추가하는 함수 addEmail()
    private static void addEmail(List<String> answer, String email){
        if(!answer.contains(email)){
            answer.add(email);
        }
    }

}
