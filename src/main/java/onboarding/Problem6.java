package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();
        String subString = "";
        List<List<String>> dTwoChar = new ArrayList<>();
        HashMap<String, Integer> tCharMap = new HashMap<>();
        int numPeople = 0;

        for (int i=0; i<forms.size(); i++) {
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);

            if (!email.contains("@email.com")) continue;

            for (int j=0; j<name.length() - 1; j++) {
                subString = "" + name.charAt(j) + name.charAt(j+1);

                for (int k=0; k<forms.size(); k++) {
                    if (forms.get(k).get(1).equals(name)) continue;
                    if (forms.get(k).get(1).contains(subString) && !answer.contains(forms.get(k).get(0))) {
                        answer.add(forms.get(k).get(0));
                    }
                }
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
