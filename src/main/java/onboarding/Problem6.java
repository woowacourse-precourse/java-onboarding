package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        List<Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i < forms.size(); i++) temp.add(0);
        for(int i = 0; i < forms.size()-1; i++){
            if (temp.get(i) == 1) continue;
            for(int j = i+1; j < forms.size(); j++){
                if (temp.get(j) == 1) continue;
                for(int k = 0; k < forms.get(i).get(1).length()-1; k++){

                }
            }
        }



        return answer;
    }
}
