package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> list = new HashSet<>();
        List<String> mailList = new ArrayList<>();

        for (List<String> form : forms) {
            for (int j = 0; j < form.get(1).length() - 1; j++) {
                list.add(form.get(1).substring(j, j + 2));
            }
        }

        for(String word : list) {
            int temp = 0;
            int count = 0;
            for (int i = 0; i<forms.size(); i++) {
                if(forms.get(i).get(1).contains(word)){
                    count ++;
                    if (count == 1 ) {
                        temp = i;
                    } else if (count >= 2) {
                        mailList.add(forms.get(i).get(0));
                        mailList.add(forms.get(temp).get(0));
                    }
                }
            }
        }
        HashSet<String> result = new HashSet<>(mailList);
        return new ArrayList<>(result);
    }
}
