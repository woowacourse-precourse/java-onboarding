package onboarding;

import java.util.ArrayList;
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

                    }
                }
            }
        }
        result.sort(Comparator.naturalOrder());
        answer=result;
        return answer;

    }

}
