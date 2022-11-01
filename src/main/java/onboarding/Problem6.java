package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //List<String> answer = List.of();
        //List<String> duplicateList = new ArrayList<>();
        //List<String> userIdList = new ArrayList<>();
        //duplicateList.retainAll(userIdList);
        List<String> tmp = new ArrayList<>();
        forms.forEach(form->{
            tmp.add(form.get(1));

        });
        //function(tmp);
        return (tmp);
        //return answer;
    }
}

