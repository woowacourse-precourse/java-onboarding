package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        int len = forms.size();

        List<String> repetitiveStrings = generateTestCaseStrings(forms);
        for (int i=0; i<repetitiveStrings.size(); i++){
            for (int j=0; j<forms.size(); j++){
                if (forms.get(j).get(1).contains(repetitiveStrings.get(i)))
                    answer.add(forms.get(j).get(0));
            }
        }

        Set<String> setAnswer = new HashSet<String>(answer);
        List<String> finalAnswer = new ArrayList<String>(setAnswer);
        Collections.sort(finalAnswer);
        return finalAnswer;
    }

    public static List<String> generateTestCaseStrings(List<List<String>> forms){
        List<String> testStrings = new ArrayList<>();
        List<String> repetitiveStrings = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++){
            String name = forms.get(i).get(1);
            for (int j = 0; j < name.length()-1; j++){
                String tmp = name.substring(j,j+2);
                if (!testStrings.contains(tmp))
                    testStrings.add(tmp);
                else {
                    if (!repetitiveStrings.contains(tmp))
                        repetitiveStrings.add(tmp);
                }
            }
        }

        return repetitiveStrings;
    }

}
