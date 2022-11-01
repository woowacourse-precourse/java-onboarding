package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> nameList = makeNameList(forms);


        List<String> answer = List.of("answer");
        return answer;
    }

    static List<String> makeNameList(List<List<String>> forms) {
        List<String> nameList = new ArrayList<>();
        for (List<String> list : forms) {
            nameList.add(list.get(1));
        }
        return nameList;
    }
}
