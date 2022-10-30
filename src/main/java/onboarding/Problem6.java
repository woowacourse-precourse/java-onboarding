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
  
        return answer;
    }




}
