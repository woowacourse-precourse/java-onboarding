package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> email = new ArrayList<>();
        List<List<String>> name = new ArrayList<>(new ArrayList<>());
        List<String> answer = List.of();
        for(int i = 0; i<forms.size(); i++){
            email.add(forms.get(i).get(0));
            List<String> name_set = new ArrayList<>();
            for (int j = 0; j < forms.get(i).get(1).length()-1; j++) {
                name_set.add(forms.get(i).get(1).substring(j, j+2));
                }
                name.add(name_set);
            }


        return answer;
    }
}
