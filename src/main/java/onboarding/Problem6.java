package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>(findAnswer(forms));

        return answer;
    }

    public static Set<String> findAnswer(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();


        for (int i = 0; i < forms.size() - 1; i++) {
            String[] targetNameArr = forms.get(i).get(1).split("");
            for (int j = i + 1; j < forms.size(); j++) {
                String compareArr = forms.get(j).get(1);

                findTwoSameLetter(forms, i, j, targetNameArr, compareArr, answer);
            }
        }
        return answer;
    }

    public static void findTwoSameLetter(List<List<String>> forms, int i, int j, String[] targetNameArr, String compareArr, Set<String> answer) {
        for (int z = 0; z < targetNameArr.length - 1; z++) {
            String targetTwoLetter = targetNameArr[z] + targetNameArr[z + 1];

            if (compareArr.contains(targetTwoLetter)) {
                answer.add(forms.get(i).get(0));
                answer.add(forms.get(j).get(0));
                break;
            }
        }
    }
}
