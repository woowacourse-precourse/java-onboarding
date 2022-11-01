package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < forms.size(); i++){
            for (int j = 0; j < forms.size(); j++){
                if(i != j && Check(forms.get(i).get(1),forms.get(j).get(1)) == 0) {
                    answer.add(forms.get(i).get(0));
                    break;
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
    public static Integer Check(String username,String username2){

        for(int i = 0; i < username.length() - 1; i++){
            for(int j = i + 2; j < username.length() + 1; j++){
                String part = username.substring(i,j);
                if(username2.contains(part)) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
