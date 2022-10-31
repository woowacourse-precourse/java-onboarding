package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer =  new ArrayList<String>();
        List<String> name = new ArrayList<String>();
        List<String> sim = List.of();

        for(int i=0; i<forms.size(); i++){
            name.add(forms.get(i).get(1));
        }

        for(int i=0; i<forms.size(); i++) { // 10000 * 20 * 10000
            boolean usable = true;
            for (int j = 0; j <= forms.get(i).get(1).length() - 2; j++) {
                for(int k=0; k<name.size(); k++){
                    if(i==k) continue;
                    if (name.get(k).contains(forms.get(i).get(1).substring(j, j + 2))) { // 이름이 중복되면
                        usable = false;
                        answer.add(forms.get(i).get(0));
                        break;
                    }
                }
                if(!usable) break;
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
