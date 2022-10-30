package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i=0; i< forms.size(); i++){
            String nickname = forms.get(i).get(1);
            for(int j=0; j < nickname.length()-1; j++){
                String word = nickname.substring(j, j+2);
            }
        }
        return answer;
    }
}
