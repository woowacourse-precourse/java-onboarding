package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> sepNames = new ArrayList<>();


        for (List<String> form : forms) {
            String name = form.get(1);
            for(int i = 0;i<name.length()-1;i++)
            {
                sepNames.add(name.substring(i,i+2));
            }

        }
        String dupName = "";
        for (String sepName : sepNames) {
            if(Collections.frequency(sepNames,sepName) != 1)
            {
                dupName = sepName;
                break;
            }

        }

        for (List<String> form : forms) {
            if (form.get(1).contains(dupName)) answer.add(form.get(0));
        }



        Collections.sort(answer);
        return answer;
    }




}
