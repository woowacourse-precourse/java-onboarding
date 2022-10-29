package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {


        List<String> answer = List.of("answer");
        return answer;
    }

    public static List<String> getNickNameList(List<List<String >> forms) {

        List<String> nickNames = new ArrayList<>();

        for (int i = 0; i <= forms.size(); i ++) {
            nickNames.add(forms.get(i).get(1));
        }

        return nickNames;

    }




}
