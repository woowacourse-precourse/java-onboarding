package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> nicknamecnt = new HashMap<>();
        for (int i=0; i<forms.size(); i++) {

            map.put(forms.get(i).get(1), forms.get(i).get(0));

            for (int j=0; j<forms.get(i).get(1).length()-1; j++) {

                String nicknameparts = forms.get(i).get(1).substring(j, j+2);
                nicknamecnt.put(nicknameparts, nicknamecnt.getOrDefault(nicknameparts,0)+1);
            }
        }
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            for (int j = 0; j < name.length() - 1; j++) {
                if (nicknamecnt.get(name.substring(j, j + 2)) - 1 > 1) {
                    answer.add(map.get(name));
                    break;
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
