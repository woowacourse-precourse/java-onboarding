package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {

    public static Boolean is_duplicate(String a, String b) {

        for(int i=0; i < a.length()-1; i++) {
            for(int j=0; j < b.length()-1; j++) {
                if(a.charAt(i) == b.charAt(j) && a.charAt(i+1) == b.charAt(j+1)) {
                    return true;
                }
            }
        }

        return false;
    }


    public static List<String> solution(List<List<String>> forms) {

        int size = forms.size();
        List<Boolean> chk = new ArrayList<>(size);
        List<String> answer = new ArrayList<>();
        for(int i=0; i<size; i++) chk.add(true);


        for(int i=0; i<size; i++) {
            for(int j=i+1; j<size; j++) {

                if (is_duplicate(forms.get(i).get(1), forms.get(j).get(1))) {

                    if (chk.get(i)) {
                        answer.add(forms.get(i).get(0));
                        chk.set(i, false);
                    }

                    if (chk.get(j)) {
                        answer.add(forms.get(j).get(0));
                        chk.set(j, false);
                    }

                }
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
