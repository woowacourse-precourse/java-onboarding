package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        int idxStr = 0;
        int idxChar = 0;
        int j = 0;

        while (idxStr < forms.size())
        {
            idxChar = 0;
            while (idxChar < forms.get(idxStr).get(1).length() - 1) {
                String targetTwoChars = forms.get(idxStr).get(1).substring(idxChar, idxChar + 2);
                j = 0;
                while (j < forms.size()){
                    if (j != idxStr && forms.get(j).get(1).contains(targetTwoChars) && !answer.contains(forms.get(j).get(0)))
                        answer.add(forms.get(j).get(0));
                    j++;
                }
                idxChar++;
            }
            idxStr++;
        }
        Collections.sort(answer);

        return answer;
    }
}
