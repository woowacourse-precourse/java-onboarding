package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        answer = new ArrayList<>();
        for (int i=0; i<forms.size(); i++){
            List<String> me = forms.get(i);
            for(int j=i+1; j<forms.size(); j++){
                List<String> you = forms.get(j);

                if (me.get(1) != you.get(1) // string의 주소까지 같아야 하므로 equals 아닌 != 사용!
                    && isDuplicated(me.get(1),you.get(1))) { // 중복체크
                    addWithoutDuplication(answer, me.get(0));
                    addWithoutDuplication(answer, you.get(0));
                }
            }
        }

        answer.sort(String.CASE_INSENSITIVE_ORDER);
        return answer;
    }

    private static boolean isDuplicated(String myName, String yourName){
        for(int i=0; i<myName.length()-1 ; i++){
            for (int j=0; j<yourName.length()-1; j++){
                if (myName.substring(i,i+2).equals(yourName.substring(j,j+2)))
                    return true;
            }
        }
        return false;
    }

    private static void addWithoutDuplication(List<String> emailList, String email){
        if(!emailList.contains(email))
            emailList.add(email);
    }

}
