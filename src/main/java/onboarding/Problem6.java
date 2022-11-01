package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> result = new ArrayList<>();
        for (List<String> form : forms) {
            String s = form.get(1);
            for (int i =0; i< s.length()-1;i++){
                String temp = s.substring(i,i+2);
                for (List<String> checkForm : forms){
                    if (form.get(0)!=checkForm.get(0) && checkForm.get(1).contains(temp)){
                        if (!result.contains(checkForm.get(0)))
                            result.add(checkForm.get(0));
                        if (!result.contains(form.get(0)))
                            result.add(form.get(0));
                    }
                }
            }
        }
        result.sort(Comparator.naturalOrder());
        answer=result;
        return answer;

    }

}
