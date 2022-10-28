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
                    System.out.println(ElementByTwoDimension);
                    System.out.println(ElementByOneDimension);
                }
            }


        }

        List<String> answer = List.of("answer");
        return answer;
    }
}
