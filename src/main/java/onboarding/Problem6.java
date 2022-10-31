package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();//List.of("answer");
        List<String> name = new ArrayList<String>();
        answer.clear();
        for(List<String> form : forms)
        {
            name.clear();
            for(int i = 0; i < form.get(1).length() - 1; i++)
            {
                name.add(form.get(1).substring(i,i+2));
            }
            for(List<String> form2 : forms)
            {
                for(String name_ : name)
                {
                    if(form != form2)
                        if(form2.get(1).contains(name_)==true)
                        {
                            answer.add(form2.get(0));
                            break;
                        }
                }
            }
        }
        Set<String> set = new HashSet<String>(answer);
        List<String> newList = new ArrayList<String>(set);
        answer = newList;
        Collections.sort(answer);
        return answer;
    }
}
