package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashSet<String> HS = new HashSet<>();
        Map<String, String> HM = new HashMap<>();

        for(int i = 0;i<forms.size();i++){

            String nick = forms.get(i).get(1);

            if(nick.length() < 2)// 닉네임이 1글자 일경우 제외
                break;

            for(int j = 0; j < nick.length() - 1;j++){
                /*
                    1. 닉네임을 substring을 통해 2글자를 따서 전부 HashMap에 이메일과 저장한다.
                        1-1 조건을 통해 딴 두글자가 map에 없을경우 저장 HM(닉네임의 일부, 이메일)
                        1-2 이미 map에 존재하는 키라면.

                    2. HashSet 에 email 저장.
                */
                String subNick = nick.substring(j,j+2);
                if(HM.containsKey(subNick)){
                    String email = HM.get(subNick);

                    if(!email.equals(forms.get(i).get(0))){
                        HS.add(forms.get(i).get(0));
                        HS.add(email);
                    }
                }
                HM.put(subNick, forms.get(i).get(0));
            }

        }

        List<String> answer = new ArrayList<>(HS);
        Collections.sort(answer);

        return answer;
    }
}
