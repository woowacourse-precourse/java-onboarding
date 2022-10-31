package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> qwer = new ArrayList<>();
        String name= "";
        String name2= "";
        String email = "";
        String email2 = "";

        if(forms.size() < 10000) {
            for (int i = 0; i < forms.size(); i++) {
                email = forms.get(i).get(0);
                name = forms.get(i).get(1);
                if (email.length() < 20 && email.length() > 10 && email.contains("email.com")) {
                    for (int j = i + 1; j < forms.size(); j++) {
                        name2 = forms.get(j).get(1);
                        email2 = forms.get(j).get(0);
                        for(int k =0; k<name2.length()-1; k++) {
                            String substring_name = name2.substring(k, k+2);
                            if (name.contains(substring_name)) {
                                qwer.add(email);
                                qwer.add(email2);
                            }
                        }
                    }
                }
            }
            qwer.sort(Comparator.naturalOrder());
            answer = qwer.stream().distinct().collect(Collectors.toList());
        }
        return answer;



    }
}
