package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> selectedList = new ArrayList<String>();

        for (int i = 0; i < forms.size(); i++) {

            List elementByTwoDimension = forms.get(i);

            for (int j = 0; j < forms.size(); j++) {
                if (j == i) {
                } else {
                    List ElementByOneDimension = forms.get(j);

                    String setName = (String) elementByTwoDimension.get(1);
                    String setEmail = (String) elementByTwoDimension.get(0);
                    String compareName = (String) ElementByOneDimension.get(1);


                    if (checkConsecutiveCharacter(setName, compareName) == true) {
                        selectedList.add(setEmail);
                    }
                }
            }
        }

        List<String> answer = removeDuplication(selectedList);
        answer.sort(Comparator.naturalOrder());

        return answer;
    }

    private static List<String> removeDuplication(List<String> selectedList) {
        List<String> answer = new ArrayList<String>();
        answer = selectedList.stream().distinct().collect(Collectors.toList());
        return answer;
    }

    private static boolean checkConsecutiveCharacter(String setName, String compareName) {
        boolean isContainsConsecutive = false;
        for (int i = 0; i < setName.length() - 1; i++) {
            String sub = setName.substring(i, i + 2);
            if (compareName.contains(sub)) {
                isContainsConsecutive = true;
            }
        }
        return isContainsConsecutive;
    }
}
