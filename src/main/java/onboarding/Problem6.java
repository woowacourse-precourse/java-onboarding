package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NAME = 1;
    private static List<String> getNameList(List<List<String>> forms){
        List<String> name_list = new ArrayList<>();
        for (List<String> crew : forms){
            name_list.add(crew.get(NAME));
        }
        return name_list;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
