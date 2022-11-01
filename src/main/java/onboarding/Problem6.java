package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        String emailReg = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com";
        String nicknameReg = "^[가-힣]*$";
        HashMap<String, Integer> nicknameMap = new HashMap<>();

        for(int i = 0 ; i < forms.size() ; i++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            //형식에 맞지 않는 데이터 제거
            if(!Pattern.matches(emailReg, email) ||
                    email.length() < 11 || email.length() >= 20){
                    continue;
            }
            if(!Pattern.matches(nicknameReg, nickname) ||
                    nickname.length() < 1 || email.length() >= 20){
                continue;
            }

            //닉네임 중복 등록
            String[] nicknameArray = nickname.split("");
            for(int j = 0 ; j  < nickname.length() - 1 ; j++){
                String unit = nicknameArray[j]+nicknameArray[j+1];
                if(nicknameMap.containsKey(unit))
                    nicknameMap.put(unit, nicknameMap.get(unit) + 1);
                else nicknameMap.put(unit, 1);
            }
        }

        //확인
        for(int i = 0 ; i < forms.size() ; i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            String[] nicknameArray = nickname.split("");
            for(int j = 0 ; j  < nickname.length() - 1 ; j++){
                String unit = nicknameArray[j]+nicknameArray[j+1];
                if(nicknameMap.get(unit) >= 2) {
                    answer.add(email);
                    break;
                }
            }
        }


        Collections.sort(answer);
        return answer;
    }
}
