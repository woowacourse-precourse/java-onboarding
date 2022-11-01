package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        char[][] nickNames = new char[forms.size()][];

        for(int i = 0; i < forms.size()-1;i++){
            for(int j = 0; j < 18; j++) {
                if (nickNames[i][j] == nickNames[i+1][j] && nickNames[i][j+1] == nickNames[i+1][j+1]){
                    answer.add(String.valueOf(forms.get(i)));
                    answer.add(String.valueOf(forms.get(i+1)));
                }
            }
        }
        //중복제거
        return answer;
    }
}
