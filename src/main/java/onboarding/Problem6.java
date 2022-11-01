/*
기능 목록
i) checkRedupli -> 두 String을 입력 받아 서로 중복인지 체크하여 중복이라면 true, 아니라면 false 반환한다.
ii) makeIndexList -> forms를 입력 받아 i)를 이용하여 중복이 아닌 index와 중복인 index를 기록한 indexlist를 반환한다.
iii) makeEmailList -> forms를 입력 받고 ii)를 이용하여 최종적으로 출력할 email 목록들을 list 형태로 반환한다.
iv) solution -> iii)을 이용하여 정답을 반환한다.
 */

package onboarding;

import java.util.List;

public class Problem6 {


    boolean checkRedupli(String name1, String name2){

        boolean temp_result = false;

        for (int i = 0; i < name1.length() - 1; i++){
            for (int j = 0; i < name1.length() - 1; i++) {
                if (name1.substring(i, i+2).equals(name2.substring(j,j+2))) temp_result = true;
            }
        }

        return temp_result;
    }


    int[] makeIndexList(List<List<String>> forms){

        int[] temp_array = new int[forms.size()];

        for (int i = 0; i < forms.size() - 1; i++){
            for(int j = i+1; j < forms.size(); j++){
                if(checkRedupli(forms.get(i).get(1), forms.get(j).get(1))) {
                    temp_array[i] = 1;
                    temp_array[j] = 1;
                }
            }
        }

        return temp_array;
    }


    List<String> makeEmailList(List<List<String>> forms, int[] checklist){

        List<String> temp_email = null;

        for (int i = 0; i < forms.size(); i++){
            if (checklist[i] == 0) temp_email.add(forms.get(i).get(0));
        }

        return temp_email;
    }


    public static List<String> solution(List<List<String>> forms) {
        Problem6 agent = new Problem6();
        List<String> answer = agent.makeEmailList(forms, agent.makeIndexList(forms));
        return answer;
    }
}
