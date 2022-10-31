package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static String getPartOfName(String name, int index){
        String partOfName = name.substring(index, index + 2);
        return partOfName;
    }
}
