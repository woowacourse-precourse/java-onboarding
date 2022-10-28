package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {


        for (int i = 0; i < forms.size(); i++) {

            List ElementByTwoDimension = forms.get(i);

            for (int j = 0; j < forms.size(); j++) {
                if (j == i) {
                } else {
                    List ElementByOneDimension = forms.get(j);

                    String setName = (String) ElementByTwoDimension.get(1);
                    String compareName = (String) ElementByOneDimension.get(1);

                    if (checkConsecutiveCharacter(setName, compareName) == true) {
                        System.out.println(setName);
                    }
                }
            }
        }

        List<String> answer = List.of("answer");
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
