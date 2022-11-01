package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> get(List<String> ls1,List<String> ls2) {

    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i=0; i<forms.size(); i++) {
            for (int j =i+1; j < forms.size(); j++) {
                if(null==get(forms.get(i),forms.get(j))) continue;

                answer.add(get(forms.get(i),forms.get(j)).get(0));
                answer.add(get(forms.get(i),forms.get(j)).get(1));

            }
        }answer=answer.stream().distinct().collect(Collectors.toList());

        return answer;

    }
}