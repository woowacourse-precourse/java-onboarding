package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        List<String> formsEmail = new ArrayList<String>();
        List<String> formsName = new ArrayList<String>();

        for (int i = 0; i < forms.size(); i++) {
            String temp = new String();
            temp = forms.get(i).get(0);
            formsEmail.add(temp);
            temp = forms.get(i).get(1);
            formsName.add(temp);
        }

        for (int i = 0; i < formsName.size()-1; i++) {
            for (int j = i + 1; j < formsName.size(); j++) {
                String name1 = formsName.get(i);
                String name2 = formsName.get(j);
            }
        }






        return answer;
    }
}
