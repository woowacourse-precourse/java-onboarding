package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> repetitiveStrings = findRepetitiveStrings(forms);

        // find name containing repetitive string
        for (int i=0; i<repetitiveStrings.size(); i++){
            for (int j=0; j<forms.size(); j++){
                String testName = forms.get(j).get(1);
                if (testName.contains(repetitiveStrings.get(i)))
                    answer.add(forms.get(j).get(0));
            }
        }

        answer = removeRepetitionFromList(answer); // remove repetition
        Collections.sort(answer); // sorting
        return answer;
    }

    public static List<String> findRepetitiveStrings(List<List<String>> forms){
        List<String> checkedStrings = new ArrayList<>();
        List<String> repetitiveStrings = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++){
            String testString = forms.get(i).get(1);

            for (int j = 0; j < testString.length()-1; j++){
                String tmp = testString.substring(j,j+2);

                if (!checkedStrings.contains(tmp))
                    checkedStrings.add(tmp);
                else {
                    if (!repetitiveStrings.contains(tmp))
                        repetitiveStrings.add(tmp);
                }
            }
        }

        return repetitiveStrings;
    }
    public static List<String> removeRepetitionFromList(List<String> tmpList){
        Set<String> setList = new HashSet<>(tmpList);
        return new ArrayList<>(setList);
    }
}
