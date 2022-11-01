package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();
        List<String> email = new ArrayList<>();

        for (int i = 0; i < forms.size()-1; i++) {
            String check = forms.get(i).get(1);

            for (int j = i + 1; j < forms.size(); j++) {

                for (int k = 0; k < forms.get(i).get(1).length() - 1; k++) {

                    for (int l = 0; l < forms.get(j).get(1).length() - 1; l++) {

                        if (check.charAt(k) == forms.get(j).get(1).charAt(l)
                                && check.charAt(k + 1) == forms.get(j).get(1).charAt(l + 1)) {

                            email.add(forms.get(i).get(0));
                            email.add(forms.get(j).get(0));
                        }
                    }
                }
            }
        }
        for(int i=0;i<email.size();i++){
            if(!answer.contains(email.get(i))){
                answer.add(email.get(i));
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
